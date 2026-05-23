package co.edu.uco.treepruning.crosscutting.event;

import java.util.UUID;

public class PqrSubmittedEvent extends TreePruningEvent {

    private final UUID pqrId;
    private final UUID sectorId;

    public PqrSubmittedEvent(UUID pqrId, UUID sectorId) {
    	
        super("SubmitPQRUseCase");
        this.pqrId = pqrId;
        this.sectorId = sectorId;
    }

    public UUID getPqrId() { 
    	return pqrId; 
    	}
    public UUID getSectorId() { 
    	return sectorId; 
    	}
}
