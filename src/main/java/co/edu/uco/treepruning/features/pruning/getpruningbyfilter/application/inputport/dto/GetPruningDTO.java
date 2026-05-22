package co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport.dto;

import java.time.LocalDate;
import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.NumericHelper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscutting.util.CrossCuttingConstants;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport.dto.GetQuadrilleDTO;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport.dto.GetStatusDTO;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.dto.GetTreeDTO;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.dto.GetTypeDTO;

public final class GetPruningDTO {
    private UUID id;
    private GetStatusDTO status;
    private LocalDate plannedDate;
    private LocalDate executedDate;
    private GetTreeDTO tree;
    private GetQuadrilleDTO quadrille;
    private GetTypeDTO type;
    private UUID pqr;
    private String photographicRecordPath;
    private String observations;
    private int page;
    private int size;

    public GetPruningDTO(UUID id, GetStatusDTO status,
            LocalDate plannedDate, LocalDate executedDate,
            GetTreeDTO tree, GetQuadrilleDTO quadrille, GetTypeDTO type,
            UUID pqr, String photographicRecordPath, String observations,
            int page, int size) {
        setId(id);
        setStatus(status);
        setPlannedDate(plannedDate);
        setExecutedDate(executedDate);
        setTree(tree);
        setQuadrille(quadrille);
        setType(type);
        setPqr(pqr);
        setPhotographicRecordPath(photographicRecordPath);
        setObservations(observations);
        setPage(page);
        setSize(size);
    }

    public GetPruningDTO(UUID id, GetStatusDTO status,
            LocalDate plannedDate, LocalDate executedDate,
            GetTreeDTO tree, GetQuadrilleDTO quadrille, GetTypeDTO type,
            UUID pqr, String photographicRecordPath, String observations) {
        this(id, status, plannedDate, executedDate, tree, quadrille, type,
                pqr, photographicRecordPath, observations,
                0, CrossCuttingConstants.DEFAULT_PAGE_SIZE);
    }

    public GetPruningDTO(UUID id) {
        this(id, new GetStatusDTO(), DateHelper.getDefault(), DateHelper.getDefault(),
                new GetTreeDTO(), new GetQuadrilleDTO(), new GetTypeDTO(),
                UUIDHelper.getDefault(), TextHelper.getDefault(), TextHelper.getDefault(),
                0, CrossCuttingConstants.DEFAULT_PAGE_SIZE);
    }

    public GetPruningDTO() {
        this(UUIDHelper.getDefault());
    }

    public UUID getId() { return id; }
    public GetStatusDTO getStatus() { return status; }
    public LocalDate getPlannedDate() { return plannedDate; }
    public LocalDate getExecutedDate() { return executedDate; }
    public GetTreeDTO getTree() { return tree; }
    public GetQuadrilleDTO getQuadrille() { return quadrille; }
    public GetTypeDTO getType() { return type; }
    public UUID getPqr() { return pqr; }
    public String getPhotographicRecordPath() { return photographicRecordPath; }
    public String getObservations() { return observations; }
    public int getPage() { return page; }
    public int getSize() { return size; }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    private void setStatus(final GetStatusDTO status) {
        this.status = ObjectHelper.getDefault(status, new GetStatusDTO());
    }
    private void setPlannedDate(final LocalDate plannedDate) {
        this.plannedDate = DateHelper.getDefault(plannedDate);
    }
    private void setExecutedDate(final LocalDate executedDate) {
        this.executedDate = DateHelper.getDefault(executedDate);
    }
    private void setTree(final GetTreeDTO tree) {
        this.tree = ObjectHelper.getDefault(tree, new GetTreeDTO());
    }
    private void setQuadrille(final GetQuadrilleDTO quadrille) {
        this.quadrille = ObjectHelper.getDefault(quadrille, new GetQuadrilleDTO());
    }
    private void setType(final GetTypeDTO type) {
        this.type = ObjectHelper.getDefault(type, new GetTypeDTO());
    }
    private void setPqr(final UUID pqr) {
        this.pqr = UUIDHelper.getDefault(pqr);
    }
    private void setPhotographicRecordPath(final String photographicRecordPath) {
        this.photographicRecordPath = TextHelper.getDefaultWithTrim(photographicRecordPath);
    }
    private void setObservations(final String observations) {
        this.observations = TextHelper.getDefaultWithTrim(observations);
    }
    private void setPage(final int page) {
        this.page = Math.max(0, NumericHelper.getDefaultInt(page));
    }
    private void setSize(final int size) {
        int s = size <= 0 ? CrossCuttingConstants.DEFAULT_PAGE_SIZE : size;
        this.size = Math.min(s, CrossCuttingConstants.MAX_PAGE_SIZE);
    }
}
