package co.edu.uco.treepruning.features.pruning.schedulecorrectivepruning.application.usecase.domain;

import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.UUID;

public final class ScheduleCorrectivePruningDomain {

    private UUID pqr;
    private UUID tree;
    private LocalDate plannedDate;
    private UUID quadrille;
    private UUID type;

    @JsonCreator
    public ScheduleCorrectivePruningDomain(
            @JsonProperty("pqr") UUID pqr,
            @JsonProperty("tree") UUID tree,
            @JsonProperty("plannedDate") LocalDate plannedDate,
            @JsonProperty("quadrille") UUID quadrille,
            @JsonProperty("type") UUID type) {
        setPqr(pqr);
        setTree(tree);
        setPlannedDate(plannedDate);
        setQuadrille(quadrille);
        setType(type);
    }

    public ScheduleCorrectivePruningDomain() {
        setPqr(UUIDHelper.getDefault());
        setTree(UUIDHelper.getDefault());
        setPlannedDate(DateHelper.getDefault());
        setQuadrille(UUIDHelper.getDefault());
        setType(UUIDHelper.getDefault());
    }

    public UUID getPqr() {
        return pqr;
    }
    public UUID getTree() {
        return tree;
    }
    public LocalDate getPlannedDate() {
        return plannedDate;
    }
    public UUID getQuadrille() {
        return quadrille;
    }
    public UUID getType() {
        return type;
    }

    private void setPqr(final UUID pqr) {
        this.pqr = UUIDHelper.getDefault(pqr);
    }
    private void setTree(final UUID tree) {
        this.tree = UUIDHelper.getDefault(tree);
    }
    private void setPlannedDate(final LocalDate plannedDate) {
        this.plannedDate = DateHelper.getDefault(plannedDate);
    }
    private void setQuadrille(final UUID quadrille) {
        this.quadrille = UUIDHelper.getDefault(quadrille);
    }
    private void setType(final UUID type) {
        this.type = UUIDHelper.getDefault(type);
    }
}
