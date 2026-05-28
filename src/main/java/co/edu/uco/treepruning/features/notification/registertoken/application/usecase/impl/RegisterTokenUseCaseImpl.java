package co.edu.uco.treepruning.features.notification.registertoken.application.usecase.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.treepruning.features.notification.registertoken.application.usecase.RegisterTokenUseCase;
import co.edu.uco.treepruning.features.notification.registertoken.application.usecase.domain.NotificationTokenDomain;
import co.edu.uco.treepruning.features.notification.registertoken.application.usecase.impl.mapper.NotificationTokenDomainMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.NotificationTokenRepository;

@Service
@Transactional
public class RegisterTokenUseCaseImpl implements RegisterTokenUseCase {

    private static final Logger log = LoggerFactory.getLogger(RegisterTokenUseCaseImpl.class);

    private final NotificationTokenRepository tokenRepository;
    private final NotificationTokenDomainMapper domainMapper;

    public RegisterTokenUseCaseImpl(NotificationTokenRepository tokenRepository, NotificationTokenDomainMapper domainMapper) {
        this.tokenRepository = tokenRepository;
        this.domainMapper = domainMapper;
    }

    @Override
    public Void execute(NotificationTokenDomain domain) {
        log.info("RegisterTokenUseCaseImpl — processing token for user {}", domain.getUserId());
        tokenRepository.findByFcmToken(domain.getFcmToken())
            .ifPresentOrElse(
                existing -> {
                    existing.activate();
                    existing.updateLanguage(domain.getLanguage());
                    tokenRepository.save(domainMapper.toEntity(existing));
                },
                () -> tokenRepository.save(domainMapper.toEntity(domain))
            );
        return null;
    }
}