package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.NotificationHistoryJPAEntity;

public interface NotificationHistoryJPARepository extends JpaRepository<NotificationHistoryJPAEntity, UUID>{

	List<NotificationHistoryJPAEntity> findByUserIdOrderBySentAtDesc(UUID userId, Pageable pageable);
}
