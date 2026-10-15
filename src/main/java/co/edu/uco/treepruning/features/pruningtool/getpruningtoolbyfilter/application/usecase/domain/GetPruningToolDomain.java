package co.edu.uco.treepruning.features.pruningtool.getpruningtoolbyfilter.application.usecase.domain;

import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public final class GetPruningToolDomain {

    private UUID id;
    private UUID pruning;
    private UUID tool;

    @JsonCreator
    public GetPruningToolDomain(
            @JsonProperty("id") UUID id,
            @JsonProperty("pruning") UUID pruning,
            @JsonProperty("tool") UUID tool) {
        setId(id);
        setPruning(pruning);
        setTool(tool);
    }

    public GetPruningToolDomain() {
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
