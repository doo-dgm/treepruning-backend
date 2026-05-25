package co.edu.uco.treepruning.features.notification.gethistory.application.usecase;

import java.util.List;

import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.features.notification.gethistory.application.inputport.dto.GetNotificationHistoryDTO;
import co.edu.uco.treepruning.features.notification.gethistory.application.usecase.domain.NotificationHistoryDomain;


public interface GetNotificationHistoryUseCase extends UseCase<GetNotificationHistoryDTO, List<NotificationHistoryDomain>> {

}
