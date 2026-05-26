package co.edu.uco.treepruning.features.notification.unregistertoken.application.inputport.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.features.notification.unregistertoken.application.inputport.dto.UnregisterTokenDTO;
import co.edu.uco.treepruning.features.notification.registertoken.application.usecase.domain.NotificationTokenDomain;

@Mapper(componentModel = "spring")
public interface UnregisterTokenDTOMapper {

    default NotificationTokenDomain toDomain(UnregisterTokenDTO dto) {
        if (ObjectHelper.isNull(dto)) return new NotificationTokenDomain();
        return new NotificationTokenDomain(UUIDHelper.getDefault(), dto.getFcmToken(), "es");
    }
}