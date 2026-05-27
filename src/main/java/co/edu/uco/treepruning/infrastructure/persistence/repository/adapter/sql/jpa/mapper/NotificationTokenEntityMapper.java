package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import org.mapstruct.Mapper;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.NotificationTokenEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.NotificationTokenJPAEntity;

@Mapper(componentModel = "spring")
public interface NotificationTokenEntityMapper {

    default NotificationTokenJPAEntity toJPA(NotificationTokenEntity entity) {
        if (entity == null) return null;
        return new NotificationTokenJPAEntity(
            entity.getId(),
            entity.getUserId(),
            entity.getFcmToken(),
            entity.getLanguage(),
            entity.getCreatedAt(),
            entity.getUpdatedAt(),
            entity.isActive()
        );
    }

    default NotificationTokenEntity toEntity(NotificationTokenJPAEntity jpa) {
        if (jpa == null) return null;
        return new NotificationTokenEntity(
            jpa.getId(),
            jpa.getUserId(),
            jpa.getFcmToken(),
            jpa.getLanguage(),
            jpa.getCreatedAt(),
            jpa.getUpdatedAt(),
            jpa.isActive()
        );
    }
}
