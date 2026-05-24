package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;

import co.edu.uco.treepruning.features.notification.gethistory.application.usecase.domain.NotificationHistoryDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.NotificationHistoryRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.NotificationHistoryEntity;

public class NotificationHistoryJPARepositoryAdapter implements NotificationHistoryRepository{

	@Override
	public void save(NotificationHistoryEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<NotificationHistoryDomain> findByUserId(UUID id, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
