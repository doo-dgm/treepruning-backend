package co.edu.uco.treepruning.crosscutting.event;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class TreePruningEvent {

    private final UUID eventId = UUID.randomUUID();
    private final LocalDateTime occurredAt = LocalDateTime.now();
    private final String source;

    protected TreePruningEvent(String source) {
        this.source = source;
    }

    public UUID getEventId() { 
    	return eventId;
    	}
    public LocalDateTime getOccurredAt() { 
    	return occurredAt;
    	}
    public String getSource() { 
    	return source; 
    	}
}
