package co.edu.uco.treepruning.features.notification.gethistory.application.inputport;

import java.util.List;

import co.edu.uco.treepruning.application.inputport.InputPort;
import co.edu.uco.treepruning.features.notification.gethistory.application.inputport.dto.GetNotificationHistoryDTO;
import co.edu.uco.treepruning.features.notification.gethistory.application.inputport.dto.NotificationHistoryItemDTO;

public interface GetNotificationHistoryInputPort 
	extends InputPort<GetNotificationHistoryDTO, List<NotificationHistoryItemDTO>> {
}