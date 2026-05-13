package co.edu.uco.treepruning.features.pruning
        .schedulepreventivepruning.application.inputport.mapper;

import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.dto.SchedulePreventivePruningDTO;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.domain.SchedulePreventivePruningDomain;

public final class SchedulePreventivePruningDTOMapper {

    private SchedulePreventivePruningDTOMapper() {
    }

    public static SchedulePreventivePruningDomain toDomain(
            SchedulePreventivePruningDTO dto) {
        if (ObjectHelper.isNull(dto)) {
            throw TreePruningException.create(
                "No se pueden procesar los datos de la poda.",
                "SchedulePreventivePruningDTOMapper.toDomain: dto is null"
            );
        }
        return new SchedulePreventivePruningDomain(
            dto.getStatus(),
            dto.getPlannedDate(),
            dto.getExecutedDate(),
            dto.getTree(),
            dto.getQuadrille(),
            dto.getType(),
            dto.getPqr(),
            dto.getPhotographicRecordPath(),
            dto.getObservations()
        );
    }
}