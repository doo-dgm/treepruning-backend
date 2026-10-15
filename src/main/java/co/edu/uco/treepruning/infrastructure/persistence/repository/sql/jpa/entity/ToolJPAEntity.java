package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tool")
public class ToolJPAEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "description", length = 200)
    private String description;

    public ToolJPAEntity() {}

    public ToolJPAEntity(UUID id, String name, String description) {
        setId(id);
        setName(name);
        setDescription(description);
    }

    public UUID getId() {
        return id;
        }
    public String getName() {
        return name;
        }
    public String getDescription() {
        return description;
        }

    public void setId(UUID id) {
        this.id = id;
        }
    public void setName(String name) {
        this.name = name;
        }
    public void setDescription(String description) {
        this.description = description;
        }
}
