package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.NotificationHistoryEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.NotificationHistoryJPAEntity;

public interface NotificationHistoryEntityMapper {
	NotificationHistoryJPAEntity toJPA(NotificationHistoryEntity entity);
	NotificationHistoryEntity toEntity(NotificationHistoryJPAEntity jpaEntity);
}
