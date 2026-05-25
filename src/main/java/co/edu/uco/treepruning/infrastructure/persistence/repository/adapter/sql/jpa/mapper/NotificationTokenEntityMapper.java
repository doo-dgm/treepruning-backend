package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import org.mapstruct.Mapper;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.NotificationTokenEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.NotificationTokenJPAEntity;

@Mapper(componentModel = "spring")
public interface NotificationTokenEntityMapper {
	NotificationTokenJPAEntity toJPA(NotificationTokenEntity entity);
	NotificationTokenEntity toEntity(NotificationTokenJPAEntity jpaEntity);
}
