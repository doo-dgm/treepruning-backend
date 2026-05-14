package co.edu.uco.treepruning.features.pruning
        .schedulepreventivepruning.application.inputport.mapper;

import org.mapstruct.Mapper;

import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.dto.SchedulePreventivePruningDTO;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.domain.SchedulePreventivePruningDomain;

@Mapper(componentModel = "spring")
public interface SchedulePreventivePruningDTOMapper {

    SchedulePreventivePruningDomain toDomain(SchedulePreventivePruningDTO dto);
}
