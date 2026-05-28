package co.edu.uco.treepruning.features.notification.sendnotification.application.usecase.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.features.notification.gethistory.application.usecase.domain.NotificationHistoryDomain;
import co.edu.uco.treepruning.features.notification.gethistory.application.usecase.impl.mapper.GetNotificationHistoryDomainMapper;
import co.edu.uco.treepruning.features.notification.registertoken.application.usecase.domain.NotificationTokenDomain;
import co.edu.uco.treepruning.features.notification.registertoken.application.usecase.impl.mapper.NotificationTokenDomainMapper;
import co.edu.uco.treepruning.features.notification.sendnotification.application.usecase.SendNotificationUseCase;
import co.edu.uco.treepruning.features.notification.sendnotification.application.usecase.domain.SendNotificationDomain;
import co.edu.uco.treepruning.infrastructure.externalservices.notification.FcmService;
import co.edu.uco.treepruning.infrastructure.persistence.repository.NotificationHistoryRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.NotificationTokenRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.PruningRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.NotificationHistoryEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.NotificationTokenEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PruningEntity;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class SendNotificationUseCaseImpl implements SendNotificationUseCase {

    private static final Logger log      = LoggerFactory.getLogger(SendNotificationUseCaseImpl.class);
    private static final String DEFAULT_LANG = "es";

    private final NotificationTokenRepository        tokenRepository;
    private final NotificationHistoryRepository      historyRepository;
    private final GetNotificationHistoryDomainMapper historyDomainMapper;
    private final PruningRepository                  pruningRepository;
    private final NotificationTokenDomainMapper      tokenDomainMapper;
    private final FcmService                         fcmService;
    private final MessageCatalogService              messageCatalogService;

    public SendNotificationUseCaseImpl(
            NotificationTokenRepository tokenRepository,
            NotificationHistoryRepository historyRepository,
            GetNotificationHistoryDomainMapper historyDomainMapper,
            PruningRepository pruningRepository,
            NotificationTokenDomainMapper tokenDomainMapper,
            FcmService fcmService,
            MessageCatalogService messageCatalogService) {
        this.tokenRepository       = tokenRepository;
        this.historyRepository     = historyRepository;
        this.historyDomainMapper   = historyDomainMapper;
        this.pruningRepository     = pruningRepository;
        this.tokenDomainMapper     = tokenDomainMapper;
        this.fcmService            = fcmService;
        this.messageCatalogService = messageCatalogService;
    }

    @Override
    public Void execute(SendNotificationDomain domain) {
        log.info("[NOTIFICATION] SendNotificationUseCaseImpl — sending to user {}", domain.getUserId());

        List<NotificationTokenDomain> tokens = tokenRepository
                .findAllActiveByUserId(domain.getUserId());

        if (tokens.isEmpty()) {
            log.warn("[NOTIFICATION] No hay tokens activos para el usuario {}", domain.getUserId());
            return null;
        }

        PruningEntity pruningEntity = pruningRepository.findById(domain.getPruningId());

        // Historial: se guarda en el idioma del primer token activo (best-effort).
        String historyLang  = langOf(tokens.get(0));
        String historyTitle = resolveTitle(domain, historyLang);
        String historyBody  = resolveBody(domain, historyLang);

        NotificationHistoryDomain historyDomain = new NotificationHistoryDomain(
                domain.getUserId(),
                historyTitle,
                historyBody,
                domain.getPruningId(),
                pruningEntity.getType().getId(),
                LocalDateTime.now()
        );
        historyRepository.save(historyDomainMapper.toEntity(historyDomain));

        // Envio: cada token recibe el mensaje en su propio idioma.
        for (NotificationTokenDomain token : tokens) {
            String lang  = langOf(token);
            String title = resolveTitle(domain, lang);
            String body  = resolveBody(domain, lang);

            log.debug("[NOTIFICATION] token={} lang={} title={}", token.getFcmToken(), lang, title);

            boolean success = fcmService.send(token.getFcmToken(), title, body);

            if (!success) {
                log.warn("[NOTIFICATION] Token invalido; desactivando.");
                token.deactivate();
                NotificationTokenEntity tokenEntity = tokenDomainMapper.toEntity(token);
                tokenRepository.save(tokenEntity);
            }
        }
        return null;
    }

    // ── helpers ──────────────────────────────────────────────────────────────

    /** Devuelve el idioma del token o el idioma por defecto si esta vacio. */
    private String langOf(NotificationTokenDomain token) {
        String lang = token.getLanguage();
        return (lang != null && !lang.isBlank()) ? lang : DEFAULT_LANG;
    }

    /**
     * Resuelve el titulo en el idioma del token.
     * Usa el sistema de locale de Strapi (?locale=en) en lugar de
     * embeber el idioma en el codigo.
     * Codigo Strapi: "notifications.pruning-scheduled.title"
     */
    private String resolveTitle(SendNotificationDomain domain, String lang) {
        return messageCatalogService.resolve(domain.getTitleCode(), lang);
    }

    /**
     * Resuelve el cuerpo con variables en el idioma del token.
     * Codigo Strapi: "notifications.pruning-scheduled.body"
     */
    private String resolveBody(SendNotificationDomain domain, String lang) {
        return messageCatalogService.resolve(domain.getBodyCode(), lang, domain.getVars());
    }
}