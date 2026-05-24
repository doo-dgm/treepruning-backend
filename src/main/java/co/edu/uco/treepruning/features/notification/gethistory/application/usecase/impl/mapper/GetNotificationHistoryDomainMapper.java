package co.edu.uco.treepruning.features.notification.gethistory.application.usecase.impl.mapper;

import org.mapstruct.Mapper;

import co.edu.uco.treepruning.features.notification.gethistory.application.usecase.domain.NotificationHistoryDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.NotificationHistoryEntity;

@Mapper(componentModel = "spring")
public interface GetNotificationHistoryDomainMapper {
	default NotificationHistoryEntity toEntity(
			 NotificationHistoryDomain domain) {
		 if (domain == null) return null;
		 return new NotificationHistoryEntity(
			 domain.getId(),
			 domain.getUserId(),
			 domain.getTitle(),
			 domain.getBody(),
			 domain.getPruningId(),
			 domain.getType(),
			 domain.getSentAt()
		 );
	 }
	 default co.edu.uco.treepruning.features.notification.gethistory.application.usecase.domain.NotificationHistoryDomain toDomain(
			 co.edu.uco.treepruning.infrastructure.persistence.repository.entity.NotificationHistoryEntity entity) {
		 if (entity == null) return null;
		 return new NotificationHistoryDomain(
			 entity.getUserId(),
			 entity.getTitle(),
			 entity.getBody(),
			 entity.getPruningId(),
			 entity.getType(),
			 entity.getSentAt()
		 );
	 }
}
