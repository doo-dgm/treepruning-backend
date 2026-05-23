package co.edu.uco.treepruning.crosscutting.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TraceabilityEventListener {

    private static final Logger log = LoggerFactory.getLogger(TraceabilityEventListener.class);

    @EventListener
    public void onPruningScheduled(PruningScheduledEvent event) {
        log.info("[TRACE] event=PruningScheduled | source={} | pruningId={} | treeId={} | plannedDate={} | occurredAt={}",
                event.getSource(),
                event.getPruningId(),
                event.getTreeId(),
                event.getPlannedDate(),
                event.getOccurredAt());
    }

    @EventListener
    public void onPqrSubmitted(PqrSubmittedEvent event) {
        log.info("[TRACE] event=PqrSubmitted | source={} | pqrId={} | sectorId={} | occurredAt={}",
                event.getSource(),
                event.getPqrId(),
                event.getSectorId(),
                event.getOccurredAt());
    }
}
