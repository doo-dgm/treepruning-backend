package co.edu.uco.treepruning.features.tree.gettreebyfilter.application.usecase.domain;

import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.usecase.domain.GetFamilyDomain;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.usecase.domain.GetProgrammingDomain;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.usecase.domain.GetSectorDomain;

public final class GetTreeDomain {
    private UUID id;
    private String longitude;
    private String latitude;
    private GetFamilyDomain family;
    private GetSectorDomain sector;
    private GetProgrammingDomain programming;

    public GetTreeDomain(UUID id, String longitude, String latitude,
            GetFamilyDomain family, GetSectorDomain sector, GetProgrammingDomain programming) {
        setId(id);
        setLongitude(longitude);
        setLatitude(latitude);
        setFamily(family);
        setSector(sector);
        setProgramming(programming);
    }

    public UUID getId() { return id; }
    public String getLongitude() { return longitude; }
    public String getLatitude() { return latitude; }
    public GetFamilyDomain getFamily() { return family; }
    public GetSectorDomain getSector() { return sector; }
    public GetProgrammingDomain getProgramming() { return programming; }

    private void setId(final UUID id) { this.id = UUIDHelper.getDefault(id); }
    private void setLongitude(final String longitude) { this.longitude = TextHelper.getDefaultWithTrim(longitude); }
    private void setLatitude(final String latitude) { this.latitude = TextHelper.getDefaultWithTrim(latitude); }
    private void setFamily(final GetFamilyDomain family) { this.family = family; }
    private void setSector(final GetSectorDomain sector) { this.sector = sector; }
    private void setProgramming(final GetProgrammingDomain programming) { this.programming = programming; }
}
