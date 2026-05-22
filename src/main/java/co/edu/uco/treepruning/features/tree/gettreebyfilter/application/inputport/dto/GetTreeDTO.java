package co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.dto;

import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.inputport.dto.GetFamilyDTO;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.inputport.dto.GetProgrammingDTO;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.inputport.dto.GetSectorDTO;

public final class GetTreeDTO {
    private UUID id;
    private String longitude;
    private String latitude;
    private GetFamilyDTO family;
    private GetSectorDTO sector;
    private GetProgrammingDTO programming;

    public GetTreeDTO(UUID id, String longitude, String latitude,
            GetFamilyDTO family, GetSectorDTO sector, GetProgrammingDTO programming) {
        setId(id);
        setLongitude(longitude);
        setLatitude(latitude);
        setFamily(family);
        setSector(sector);
        setProgramming(programming);
    }

    public GetTreeDTO(UUID id) {
        this(id, TextHelper.getDefault(), TextHelper.getDefault(),
                new GetFamilyDTO(), new GetSectorDTO(), new GetProgrammingDTO());
    }

    public GetTreeDTO() {
        this(UUIDHelper.getDefault());
    }

    public UUID getId() { return id; }
    public String getLongitude() { return longitude; }
    public String getLatitude() { return latitude; }
    public GetFamilyDTO getFamily() { return family; }
    public GetSectorDTO getSector() { return sector; }
    public GetProgrammingDTO getProgramming() { return programming; }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    private void setLongitude(final String longitude) {
        this.longitude = TextHelper.getDefaultWithTrim(longitude);
    }
    private void setLatitude(final String latitude) {
        this.latitude = TextHelper.getDefaultWithTrim(latitude);
    }
    private void setFamily(final GetFamilyDTO family) {
        this.family = ObjectHelper.getDefault(family, new GetFamilyDTO());
    }
    private void setSector(final GetSectorDTO sector) {
        this.sector = ObjectHelper.getDefault(sector, new GetSectorDTO());
    }
    private void setProgramming(final GetProgrammingDTO programming) {
        this.programming = ObjectHelper.getDefault(programming, new GetProgrammingDTO());
    }
}
