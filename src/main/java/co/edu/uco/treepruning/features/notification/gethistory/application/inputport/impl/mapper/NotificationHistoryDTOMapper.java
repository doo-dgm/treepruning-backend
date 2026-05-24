package co.edu.uco.treepruning.features.notification.gethistory.application.inputport.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.features.notification.gethistory.application.inputport.dto.NotificationHistoryItemDTO;
import co.edu.uco.treepruning.features.notification.gethistory.application.usecase.domain.NotificationHistoryDomain;

@Mapper(componentModel = "spring")
public interface NotificationHistoryDTOMapper {
	
	default NotificationHistoryDomain toDomain(NotificationHistoryItemDTO dto) {
		if (ObjectHelper.isNull(dto)) return null;
		return new NotificationHistoryDomain(
			null,
			dto.getTitle(),
			dto.getBody(),
			null,
			null,
			dto.getSentAt()
		);
	}

    default NotificationHistoryItemDTO toDTO(NotificationHistoryDomain domain) {
        if (ObjectHelper.isNull(domain)) return new NotificationHistoryItemDTO();
        return new NotificationHistoryItemDTO(
            domain.getId(),
            domain.getTitle(),
            domain.getBody(),
            domain.getPruningId(),
            domain.getType(),
            domain.getSentAt(),
            domain.isSuccess()
        );
    }
}