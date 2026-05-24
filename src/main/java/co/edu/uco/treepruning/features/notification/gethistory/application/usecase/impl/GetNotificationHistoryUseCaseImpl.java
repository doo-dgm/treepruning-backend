package co.edu.uco.treepruning.features.notification.gethistory.application.usecase.impl;

import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.edu.uco.treepruning.features.notification.gethistory.application.inputport.dto.GetNotificationHistoryDTO;
import co.edu.uco.treepruning.features.notification.gethistory.application.usecase.GetNotificationHistoryUseCase;
import co.edu.uco.treepruning.features.notification.gethistory.application.usecase.domain.NotificationHistoryDomain;
import co.edu.uco.treepruning.features.notification.gethistory.application.usecase.impl.mapper.GetNotificationHistoryDomainMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.NotificationHistoryRepository;


@Service
@Transactional(readOnly = true)
public class GetNotificationHistoryUseCaseImpl implements GetNotificationHistoryUseCase {

    private static final Logger log = LoggerFactory.getLogger(GetNotificationHistoryUseCaseImpl.class);

    private final NotificationHistoryRepository historyRepository;
    private final GetNotificationHistoryDomainMapper domainMapper;

    public GetNotificationHistoryUseCaseImpl(
            NotificationHistoryRepository historyRepository,
            GetNotificationHistoryDomainMapper domainMapper) {
        this.historyRepository = historyRepository;
        this.domainMapper      = domainMapper;
    }

    @Override
    public List<NotificationHistoryDomain> execute(GetNotificationHistoryDTO data) {
        log.info("GetNotificationHistoryUseCaseImpl — querying for user {}", data.getUserId());
        return historyRepository
            .findByUserId(data.getUserId(), PageRequest.of(data.getPage(), data.getSize()))
            .stream().toList();
    }

}