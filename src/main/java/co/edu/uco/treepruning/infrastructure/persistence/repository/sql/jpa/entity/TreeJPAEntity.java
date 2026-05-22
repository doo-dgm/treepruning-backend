package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity;

import java.math.BigDecimal;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tree")
public class TreeJPAEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "longitude", precision = 10, scale = 6)
    private BigDecimal longitude;

    @Column(name = "latitude", precision = 10, scale = 6)
    private BigDecimal latitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "family_id")
    private FamilyJPAEntity family;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sector_id")
    private SectorJPAEntity sector;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "programming_id")
    private ProgrammingJPAEntity programming;

    public TreeJPAEntity() {
    }

    public TreeJPAEntity(UUID id, BigDecimal longitude, BigDecimal latitude,
            FamilyJPAEntity family, SectorJPAEntity sector,
            ProgrammingJPAEntity programming) {
        setId(id);
        setLongitude(longitude);
        setLatitude(latitude);
        setFamily(family);
        setSector(sector);
        setProgramming(programming);
    }

    public UUID getId() {
        return id;
    }
    public BigDecimal getLongitude() {
        return longitude;
    }
    public BigDecimal getLatitude() {
        return latitude;
    }
    public FamilyJPAEntity getFamily() {
        return family;
    }
    public SectorJPAEntity getSector() {
        return sector;
    }
    public ProgrammingJPAEntity getProgramming() {
        return programming;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }
    public void setFamily(FamilyJPAEntity family) {
        this.family = family;
    }
    public void setSector(SectorJPAEntity sector) {
        this.sector = sector;
    }
    public void setProgramming(ProgrammingJPAEntity programming) {
        this.programming = programming;
    }
}
