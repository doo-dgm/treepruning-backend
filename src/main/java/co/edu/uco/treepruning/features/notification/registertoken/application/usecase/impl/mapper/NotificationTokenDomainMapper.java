package co.edu.uco.treepruning.features.notification.registertoken.application.usecase.impl.mapper;

import org.mapstruct.Mapper;

import co.edu.uco.treepruning.features.notification.registertoken.application.usecase.domain.NotificationTokenDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.NotificationTokenEntity;

@Mapper(componentModel = "spring")
public interface NotificationTokenDomainMapper {
	default NotificationTokenEntity toEntity(NotificationTokenDomain domain) {
		if (domain == null) {
			return null;
		}
		return new NotificationTokenEntity(
			domain.getId(),
			domain.getUserId(),
			domain.getFcmToken(),
			domain.getCreatedAt(),
			domain.getUpdatedAt(),
			domain.isActive()
		);
	}
	
	default NotificationTokenDomain toDomain(NotificationTokenEntity entity) {
		if (entity == null) {
			return null;
		}
		return new NotificationTokenDomain(
			entity.getId(),
			entity.getUserId(),
			entity.getFcmToken(),
			entity.getCreatedAt(),
			entity.getUpdatedAt(),
			entity.isActive()
		);
	}
}
