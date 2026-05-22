package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.impl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.dto.SchedulePreventivePruningDTO;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.domain.SchedulePreventivePruningDomain;

@Mapper(componentModel = "spring")
public interface SchedulePreventivePruningDTOMapper {

    @Mapping(target = "id", ignore = true)
    SchedulePreventivePruningDomain toDomain(SchedulePreventivePruningDTO dto);
}
