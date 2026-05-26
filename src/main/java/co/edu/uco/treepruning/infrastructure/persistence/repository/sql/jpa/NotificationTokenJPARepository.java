package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.NotificationTokenJPAEntity;

public interface NotificationTokenJPARepository extends JpaRepository<NotificationTokenJPAEntity, UUID> {

    List<NotificationTokenJPAEntity> findByUserIdAndActiveTrue(UUID userId);

    Optional<NotificationTokenJPAEntity> findByFcmToken(String fcmToken);
}
