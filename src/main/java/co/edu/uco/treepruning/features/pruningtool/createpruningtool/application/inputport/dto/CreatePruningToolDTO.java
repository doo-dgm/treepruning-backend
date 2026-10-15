package co.edu.uco.treepruning.features.pruningtool.createpruningtool.application.inputport.dto;

import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import java.util.UUID;

public final class CreatePruningToolDTO {

    private UUID pruning;
    private UUID tool;

    public CreatePruningToolDTO(UUID pruning, UUID tool) {
        setPruning(pruning);
        setTool(tool);
    }

    public CreatePruningToolDTO() {
        setPruning(UUIDHelper.getDefault());
        setTool(UUIDHelper.getDefault());
    }

    public UUID getPruning() {
        return pruning;
    }
    public UUID getTool() {
        return tool;
    }

    private void setPruning(final UUID pruning) {
        this.pruning = UUIDHelper.getDefault(pruning);
    }
    private void setTool(final UUID tool) {
        this.tool = UUIDHelper.getDefault(tool);
    }
}
