package co.edu.uco.treepruning.infrastructure.persistence.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;

import co.edu.uco.treepruning.features.notification.gethistory.application.usecase.domain.NotificationHistoryDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.NotificationHistoryEntity;

public interface NotificationHistoryRepository {
	void save(NotificationHistoryEntity entity);
	List<NotificationHistoryDomain> findByUserId(UUID id , Pageable pageable);
}
