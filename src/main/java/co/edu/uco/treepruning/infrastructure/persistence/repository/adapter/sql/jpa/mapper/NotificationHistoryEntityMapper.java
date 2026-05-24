package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import org.mapstruct.Mapper;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.NotificationHistoryEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.NotificationHistoryJPAEntity;

@Mapper(componentModel = "spring")
public interface NotificationHistoryEntityMapper {
	NotificationHistoryJPAEntity toJPA(NotificationHistoryEntity entity);
	NotificationHistoryEntity toEntity(NotificationHistoryJPAEntity jpaEntity);
}
