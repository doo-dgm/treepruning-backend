package co.edu.uco.treepruning.crosscutting.event;

import java.time.LocalDate;
import java.util.UUID;

public class PruningScheduledEvent extends TreePruningEvent {

    private final UUID pruningId;
    private final UUID treeId;
    private final LocalDate plannedDate;

    public PruningScheduledEvent(UUID pruningId, UUID treeId, LocalDate plannedDate) {
    	
        super("SchedulePreventivePruningUseCase");
        this.pruningId = pruningId;
        this.treeId = treeId;
        this.plannedDate = plannedDate;
    }

    public UUID getPruningId() { 
    	return pruningId; 
    	}
    public UUID getTreeId() { 
    	return treeId; 
    	}
    public LocalDate getPlannedDate() {
    	return plannedDate;
    	}
}
