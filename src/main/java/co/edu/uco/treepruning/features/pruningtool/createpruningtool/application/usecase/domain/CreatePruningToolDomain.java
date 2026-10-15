package co.edu.uco.treepruning.features.pruningtool.createpruningtool.application.usecase.domain;

import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public final class CreatePruningToolDomain {

    private UUID pruning;
    private UUID tool;

    @JsonCreator
    public CreatePruningToolDomain(
            @JsonProperty("pruning") UUID pruning,
            @JsonProperty("tool") UUID tool) {
        setPruning(pruning);
        setTool(tool);
    }

    public CreatePruningToolDomain() {
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
