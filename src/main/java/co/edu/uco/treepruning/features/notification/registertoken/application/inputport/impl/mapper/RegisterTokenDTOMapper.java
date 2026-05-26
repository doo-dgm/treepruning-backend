package co.edu.uco.treepruning.features.notification.registertoken.application.inputport.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.features.notification.registertoken.application.inputport.dto.RegisterTokenDTO;
import co.edu.uco.treepruning.features.notification.registertoken.application.usecase.domain.NotificationTokenDomain;

@Mapper(componentModel = "spring")
public interface RegisterTokenDTOMapper {

    default NotificationTokenDomain toDomain(RegisterTokenDTO dto) {
        if (ObjectHelper.isNull(dto)) return new NotificationTokenDomain();
        return new NotificationTokenDomain(dto.getUserId(), dto.getFcmToken(), dto.getLanguage());
    }
}