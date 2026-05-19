package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.mapper;

import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.dto.SchedulePreventivePruningDTO;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.domain.SchedulePreventivePruningDomain;
import java.time.LocalDate;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-16T23:31:40-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 26.0.1 (Oracle Corporation)"
)
@Component
public class SchedulePreventivePruningDTOMapperImpl implements SchedulePreventivePruningDTOMapper {

    @Override
    public SchedulePreventivePruningDomain toDomain(SchedulePreventivePruningDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UUID status = null;
        LocalDate plannedDate = null;
        LocalDate executedDate = null;
        UUID tree = null;
        UUID quadrille = null;
        UUID type = null;
        String photographicRecordPath = null;
        String observations = null;

        status = dto.getStatus();
        plannedDate = dto.getPlannedDate();
        executedDate = dto.getExecutedDate();
        tree = dto.getTree();
        quadrille = dto.getQuadrille();
        type = dto.getType();
        photographicRecordPath = dto.getPhotographicRecordPath();
        observations = dto.getObservations();

        SchedulePreventivePruningDomain schedulePreventivePruningDomain = new SchedulePreventivePruningDomain( status, plannedDate, executedDate, tree, quadrille, type, photographicRecordPath, observations );

        return schedulePreventivePruningDomain;
    }
}
