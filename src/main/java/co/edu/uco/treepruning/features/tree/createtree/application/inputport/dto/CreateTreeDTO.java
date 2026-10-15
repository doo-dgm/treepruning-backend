package co.edu.uco.treepruning.features.tree.createtree.application.inputport.dto;

import co.edu.uco.treepruning.crosscutting.helper.NumericHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import java.math.BigDecimal;
import java.util.UUID;

public final class CreateTreeDTO {

    private BigDecimal longitude;
    private BigDecimal latitude;
    private UUID family;
    private UUID sector;
    private UUID programming;

    public CreateTreeDTO(BigDecimal longitude, BigDecimal latitude, UUID family, UUID sector, UUID programming) {
        setLongitude(longitude);
        setLatitude(latitude);
        setFamily(family);
        setSector(sector);
        setProgramming(programming);
    }

    public CreateTreeDTO() {
        setLongitude(NumericHelper.getDefaultBigDecimal());
        setLatitude(NumericHelper.getDefaultBigDecimal());
        setFamily(UUIDHelper.getDefault());
        setSector(UUIDHelper.getDefault());
        setProgramming(UUIDHelper.getDefault());
    }

    public BigDecimal getLongitude() {
        return longitude;
    }
    public BigDecimal getLatitude() {
        return latitude;
    }
    public UUID getFamily() {
        return family;
    }
    public UUID getSector() {
        return sector;
    }
    public UUID getProgramming() {
        return programming;
    }

    private void setLongitude(final BigDecimal longitude) {
        this.longitude = NumericHelper.getDefaultBigDecimal(longitude);
    }
    private void setLatitude(final BigDecimal latitude) {
        this.latitude = NumericHelper.getDefaultBigDecimal(latitude);
    }
    private void setFamily(final UUID family) {
        this.family = UUIDHelper.getDefault(family);
    }
    private void setSector(final UUID sector) {
        this.sector = UUIDHelper.getDefault(sector);
    }
    private void setProgramming(final UUID programming) {
        this.programming = UUIDHelper.getDefault(programming);
    }
}
