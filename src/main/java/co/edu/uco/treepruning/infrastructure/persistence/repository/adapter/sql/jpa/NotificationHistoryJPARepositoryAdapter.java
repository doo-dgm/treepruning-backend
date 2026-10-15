package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.features.notification.gethistory.application.usecase.domain.NotificationHistoryDomain;
import co.edu.uco.treepruning.features.notification.gethistory.application.usecase.impl.mapper.GetNotificationHistoryDomainMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.NotificationHistoryRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.NotificationHistoryEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.NotificationHistoryEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.NotificationHistoryJPARepository;

@Repository
public class NotificationHistoryJPARepositoryAdapter implements NotificationHistoryRepository {

	private final NotificationHistoryJPARepository    jpaRepository;
	private final NotificationHistoryEntityMapper     entityMapper;
	private final GetNotificationHistoryDomainMapper  domainMapper;

	public NotificationHistoryJPARepositoryAdapter(
			NotificationHistoryJPARepository jpaRepository,
			NotificationHistoryEntityMapper entityMapper,
			GetNotificationHistoryDomainMapper domainMapper) {
		this.jpaRepository = jpaRepository;
		this.entityMapper  = entityMapper;
		this.domainMapper  = domainMapper;
	}

	@Override
	public void save(final NotificationHistoryEntity entity) {
		jpaRepository.save(entityMapper.toJPA(entity));
	}

	@Override
	public List<NotificationHistoryDomain> findByUserId(final UUID id, final Pageable pageable) {
		return jpaRepository.findByUserIdOrderBySentAtDesc(id, pageable)
				.stream()
				.map(entityMapper::toEntity)
				.map(domainMapper::toDomain)
				.toList();
	}

}
