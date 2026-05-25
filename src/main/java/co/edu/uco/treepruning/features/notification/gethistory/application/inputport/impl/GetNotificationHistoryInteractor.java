package co.edu.uco.treepruning.features.notification.gethistory.application.inputport.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import co.edu.uco.treepruning.features.notification.gethistory.application.inputport.GetNotificationHistoryInputPort;
import co.edu.uco.treepruning.features.notification.gethistory.application.inputport.dto.GetNotificationHistoryDTO;
import co.edu.uco.treepruning.features.notification.gethistory.application.inputport.dto.NotificationHistoryItemDTO;
import co.edu.uco.treepruning.features.notification.gethistory.application.inputport.impl.mapper.NotificationHistoryDTOMapper;
import co.edu.uco.treepruning.features.notification.gethistory.application.usecase.GetNotificationHistoryUseCase;

@Service
@Transactional(readOnly = true)
public class GetNotificationHistoryInteractor implements GetNotificationHistoryInputPort {

    private static final Logger log = LoggerFactory.getLogger(GetNotificationHistoryInteractor.class);

    private final GetNotificationHistoryUseCase   useCase;
    private final NotificationHistoryDTOMapper    dtoMapper;

    public GetNotificationHistoryInteractor(
            GetNotificationHistoryUseCase useCase,
            NotificationHistoryDTOMapper dtoMapper) {
        this.useCase   = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<NotificationHistoryItemDTO> execute(GetNotificationHistoryDTO dto) {
        log.info("GetNotificationHistoryInteractor — querying history for user {}", dto.getUserId());
        List<NotificationHistoryItemDTO> result = useCase.execute(dto)
                .stream()
                .map(dtoMapper::toDTO)
                .toList();
        log.info("GetNotificationHistoryInteractor — returned {} results", result.size());
        return result;
    }
}