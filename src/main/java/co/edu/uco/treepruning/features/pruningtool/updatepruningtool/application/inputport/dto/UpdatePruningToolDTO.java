package co.edu.uco.treepruning.features.pruningtool.updatepruningtool.application.inputport.dto;

import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import java.util.UUID;

public final class UpdatePruningToolDTO {

    private UUID id;
    private UUID pruning;
    private UUID tool;

    public UpdatePruningToolDTO(UUID id, UUID pruning, UUID tool) {
        setId(id);
        setPruning(pruning);
        setTool(tool);
    }

    public UpdatePruningToolDTO() {
        setId(UUIDHelper.getDefault());
        setPruning(UUIDHelper.getDefault());
        setTool(UUIDHelper.getDefault());
    }

    public UUID getId() {
        return id;
    }
    public UUID getPruning() {
        return pruning;
    }
    public UUID getTool() {
        return tool;
    }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    private void setPruning(final UUID pruning) {
        this.pruning = UUIDHelper.getDefault(pruning);
    }
    private void setTool(final UUID tool) {
        this.tool = UUIDHelper.getDefault(tool);
    }
}
