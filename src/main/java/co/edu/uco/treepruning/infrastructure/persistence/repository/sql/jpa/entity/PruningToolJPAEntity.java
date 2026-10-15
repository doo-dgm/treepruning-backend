package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pruning_tool")
public class PruningToolJPAEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pruning_id")
    private PruningJPAEntity pruning;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tool_id")
    private ToolJPAEntity tool;

    public PruningToolJPAEntity() {}

<<<<<<< Updated upstream
    public PruningToolJPAEntity(UUID id, PruningJPAEntity pruning, ToolJPAEntity tool) {
=======
    public PruningToolJPAEntity(UUID id, PruningJPAEntity pruning,
            ToolJPAEntity tool) {
>>>>>>> Stashed changes
        setId(id);
        setPruning(pruning);
        setTool(tool);
    }

    public UUID getId() {
        return id;
        }
    public PruningJPAEntity getPruning() {
        return pruning;
        }
    public ToolJPAEntity getTool() {
        return tool;
        }

    public void setId(UUID id) {
        this.id = id;
        }
    public void setPruning(PruningJPAEntity pruning) {
        this.pruning = pruning;
        }
    public void setTool(ToolJPAEntity tool) {
        this.tool = tool;
        }
}
