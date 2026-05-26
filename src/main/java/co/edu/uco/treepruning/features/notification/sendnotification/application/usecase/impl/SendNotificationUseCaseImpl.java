package co.edu.uco.treepruning.features.notification.sendnotification.application.usecase.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger log = LoggerFactory.getLogger(SendNotificationUseCaseImpl.class);

    private final NotificationTokenRepository   tokenRepository;
    private final NotificationHistoryRepository historyRepository;
    private final GetNotificationHistoryDomainMapper    historyDomainMapper;
    private final PruningRepository 	  	  pruningRepository;
    private final NotificationTokenDomainMapper tokenDomainMapper;
    private final FcmService                    fcmService;

    public SendNotificationUseCaseImpl(
            NotificationTokenRepository tokenRepository,
            NotificationHistoryRepository historyRepository, GetNotificationHistoryDomainMapper historyDomainMapper, PruningRepository pruningRepository, NotificationTokenDomainMapper tokenDomainMapper,
            FcmService fcmService) {
        this.tokenRepository   = tokenRepository;
        this.historyRepository = historyRepository;
        this.historyDomainMapper = historyDomainMapper;
        this.pruningRepository = pruningRepository;
        this.tokenDomainMapper = tokenDomainMapper;
        this.fcmService        = fcmService;
    }

    @Override
    public Void execute(SendNotificationDomain domain) {
        log.info("SendNotificationUseCaseImpl — sending to user {}", domain.getUserId());

        List<NotificationTokenDomain> tokens = tokenRepository
            .findAllActiveByUserId(domain.getUserId());

        if (tokens.isEmpty()) {
            log.warn("SendNotificationUseCaseImpl — no active tokens for user {}", domain.getUserId());
            return null;
        }

        PruningEntity pruningEntity = pruningRepository.findById(domain.getPruningId());

        NotificationHistoryDomain historyDomain = new NotificationHistoryDomain(
            domain.getUserId(),
            domain.getTitle(),
            domain.getBody(),
            domain.getPruningId(),
            pruningEntity.getType().getId(),
            LocalDateTime.now()
        );

        NotificationHistoryEntity historyEntity = historyDomainMapper.toEntity(historyDomain);
        historyRepository.save(historyEntity);

        for (NotificationTokenDomain token : tokens) {
            boolean success = fcmService.send(
                token.getFcmToken(),
                domain.getTitle(),
                domain.getBody()
            );

            if (!success) {
                log.warn("SendNotificationUseCaseImpl — deactivating invalid token");
                token.deactivate();
                NotificationTokenEntity tokenEntity = tokenDomainMapper.toEntity(token);
                tokenRepository.save(tokenEntity);
            }
        }
        return null;
    }
}