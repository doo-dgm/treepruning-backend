package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.impl.mapper;

import org.mapstruct.Mapper;

import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.dto.SchedulePreventivePruningDTO;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.domain.SchedulePreventivePruningDomain;

@Mapper(componentModel = "spring")
public interface SchedulePreventivePruningDTOMapper {

    default SchedulePreventivePruningDomain toDomain(SchedulePreventivePruningDTO dto) {
        if (dto == null) return null;
        return new SchedulePreventivePruningDomain(
                dto.getTrees(),
                dto.getPlannedDate(),
                dto.getQuadrille(),
                dto.getPhotographicRecordPath(),
                dto.getObservations());
    }
}
