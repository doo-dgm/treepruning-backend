package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.features.notification.registertoken.application.usecase.domain.NotificationTokenDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.NotificationTokenRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.NotificationTokenEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.NotificationTokenEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.NotificationTokenJPARepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.NotificationTokenJPAEntity;

@Repository
public class NotificationTokenJPARepositoryAdapter implements NotificationTokenRepository {

    private final NotificationTokenJPARepository   jpaRepository;
    private final NotificationTokenEntityMapper    entityMapper;
    private final co.edu.uco.treepruning.features.notification.registertoken.application.usecase.impl.mapper.NotificationTokenDomainMapper domainMapper;

    public NotificationTokenJPARepositoryAdapter(
            NotificationTokenJPARepository jpaRepository,
            NotificationTokenEntityMapper entityMapper,
            co.edu.uco.treepruning.features.notification.registertoken.application.usecase.impl.mapper.NotificationTokenDomainMapper domainMapper) {
        this.jpaRepository = jpaRepository;
        this.entityMapper  = entityMapper;
        this.domainMapper  = domainMapper;
    }

    @Override
    public void save(final NotificationTokenEntity entity) {
        NotificationTokenJPAEntity jpa = entityMapper.toJPA(entity);
        jpaRepository.save(jpa);
    }

    @Override
    public void update(final NotificationTokenEntity entity) {
        NotificationTokenJPAEntity jpa = entityMapper.toJPA(entity);
        jpaRepository.save(jpa);
    }

    @Override
    public void deleteById(final UUID id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public List<NotificationTokenDomain> findAllActiveByUserId(final UUID userId) {
        return jpaRepository.findByUserIdAndActiveTrue(userId)
                .stream()
                .map(entityMapper::toEntity)
                .map(domainMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<NotificationTokenDomain> findByFcmToken(final String fcmToken) {
        return jpaRepository.findByFcmToken(fcmToken)
                .map(entityMapper::toEntity)
                .map(domainMapper::toDomain);
    }
}
