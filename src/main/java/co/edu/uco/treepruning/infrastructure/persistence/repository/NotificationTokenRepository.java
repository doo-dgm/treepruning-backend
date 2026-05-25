package co.edu.uco.treepruning.infrastructure.persistence.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.treepruning.features.notification.registertoken.application.usecase.domain.NotificationTokenDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.NotificationTokenEntity;

public interface NotificationTokenRepository {
	void save(NotificationTokenEntity entity);
	void update(NotificationTokenEntity entity);
	void deleteById(UUID id);
	List<NotificationTokenDomain> findAllActiveByUserId(UUID userId);
	Optional<NotificationTokenDomain> findByFcmToken(String fcmToken);
}
