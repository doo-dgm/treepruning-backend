package co.edu.uco.treepruning.features.notification.sendnotification.application.inputport.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.features.notification.sendnotification.application.inputport.dto.SendNotificationDTO;
import co.edu.uco.treepruning.features.notification.sendnotification.application.usecase.domain.SendNotificationDomain;

@Mapper(componentModel = "spring")
public interface SendNotificationDTOMapper {

    default SendNotificationDomain toDomain(SendNotificationDTO dto) {
        if (ObjectHelper.isNull(dto)) return new SendNotificationDomain();
        return new SendNotificationDomain(
            dto.getUserId(),
            dto.getPruningId(),
            dto.getTitle(),
            dto.getBody()
        );
    }
}