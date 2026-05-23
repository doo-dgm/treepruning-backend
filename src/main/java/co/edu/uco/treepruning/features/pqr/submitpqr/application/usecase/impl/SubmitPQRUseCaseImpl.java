package co.edu.uco.treepruning.features.pqr.submitpqr.application.usecase.impl;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.crosscutting.event.PqrSubmittedEvent;
import co.edu.uco.treepruning.features.pqr.submitpqr.application.usecase.SubmitPQRUseCase;
import co.edu.uco.treepruning.features.pqr.submitpqr.application.usecase.domain.SubmitPQRDomain;

@Service
public class SubmitPQRUseCaseImpl implements SubmitPQRUseCase {

    private final ApplicationEventPublisher eventPublisher;

    public SubmitPQRUseCaseImpl(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public Void execute(SubmitPQRDomain data) {
        eventPublisher.publishEvent(
            new PqrSubmittedEvent(data.getId(), data.getSector())
        );
        return null;
    }
}
