package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.features.notification.registertoken.application.usecase.domain.NotificationTokenDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.NotificationTokenRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.NotificationTokenEntity;

@Repository
public class NotificationTokenJPARepositoryAdapter implements NotificationTokenRepository{

	@Override
	public void save(final NotificationTokenEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(final NotificationTokenEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(final UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<NotificationTokenDomain> findAllActiveByUserId(final UUID userId) {
		// TODO Auto-generated method stub
		return List.of();
	}

	@Override
	public Optional<NotificationTokenDomain> findByFcmToken(final String fcmToken) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
