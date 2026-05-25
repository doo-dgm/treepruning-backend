package co.edu.uco.treepruning.features.notification.sendnotification.application.inputport.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uco.treepruning.features.notification.sendnotification.application.inputport.SendNotificationInputPort;
import co.edu.uco.treepruning.features.notification.sendnotification.application.inputport.dto.SendNotificationDTO;
import co.edu.uco.treepruning.features.notification.sendnotification.application.inputport.impl.mapper.SendNotificationDTOMapper;
import co.edu.uco.treepruning.features.notification.sendnotification.application.usecase.SendNotificationUseCase;

@Service
@Transactional(readOnly = true)
public class SendNotificationInteractor implements SendNotificationInputPort {

    private static final Logger log = LoggerFactory.getLogger(SendNotificationInteractor.class);

    private final SendNotificationUseCase   useCase;
    private final SendNotificationDTOMapper dtoMapper;

    public SendNotificationInteractor(
            SendNotificationUseCase useCase,
            SendNotificationDTOMapper dtoMapper) {
        this.useCase   = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public Void execute(SendNotificationDTO dto) {
        log.info("SendNotificationInteractor — sending notification to user {}", dto.getUserId());
        useCase.execute(dtoMapper.toDomain(dto));
        log.info("SendNotificationInteractor — notification sent successfully");
        return null;
    }
}