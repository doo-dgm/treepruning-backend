package co.edu.uco.treepruning.features.notification.unregistertoken.application.usecase.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uco.treepruning.features.notification.registertoken.application.usecase.domain.NotificationTokenDomain;
import co.edu.uco.treepruning.features.notification.registertoken.application.usecase.impl.mapper.NotificationTokenDomainMapper;
import co.edu.uco.treepruning.features.notification.unregistertoken.application.usecase.UnregisterTokenUseCase;
import co.edu.uco.treepruning.infrastructure.persistence.repository.NotificationTokenRepository;

@Service
@Transactional
public class UnregisterTokenUseCaseImpl implements UnregisterTokenUseCase {

    private static final Logger log = LoggerFactory.getLogger(UnregisterTokenUseCaseImpl.class);

    private final NotificationTokenRepository tokenRepository;
    private final NotificationTokenDomainMapper domainMapper;

    public UnregisterTokenUseCaseImpl(NotificationTokenRepository tokenRepository, NotificationTokenDomainMapper domainMapper) {
        this.tokenRepository = tokenRepository;
        this.domainMapper = domainMapper;
    }

    @Override
    public Void execute(NotificationTokenDomain domain) {
        log.info("UnregisterTokenUseCaseImpl — deactivating token");
        tokenRepository.findByFcmToken(domain.getFcmToken())
            .ifPresent(token -> {
                token.deactivate();
                tokenRepository.save(domainMapper.toEntity(token));
            });
        return null;
    }
}