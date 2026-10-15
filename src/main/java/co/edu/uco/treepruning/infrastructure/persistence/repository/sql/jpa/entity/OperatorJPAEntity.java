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
// OPERATOR es palabra clave en SQL, por eso el nombre de la tabla va entre
// comillas (backticks de Hibernate) para que el dialecto lo escape.
@Table(name = "`operator`")
public class OperatorJPAEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private PersonJPAEntity person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quadrille_id")
    private QuadrilleJPAEntity quadrille;

    public OperatorJPAEntity() {}

    public OperatorJPAEntity(UUID id, PersonJPAEntity person,
            QuadrilleJPAEntity quadrille) {
        setId(id);
        setPerson(person);
        setQuadrille(quadrille);
    }

    public UUID getId() {
        return id;
        }
    public PersonJPAEntity getPerson() {
        return person;
        }
    public QuadrilleJPAEntity getQuadrille() {
        return quadrille;
        }

    public void setId(UUID id) {
        this.id = id;
        }
    public void setPerson(PersonJPAEntity person) {
        this.person = person;
        }
    public void setQuadrille(QuadrilleJPAEntity quadrille) {
        this.quadrille = quadrille;
        }
}
