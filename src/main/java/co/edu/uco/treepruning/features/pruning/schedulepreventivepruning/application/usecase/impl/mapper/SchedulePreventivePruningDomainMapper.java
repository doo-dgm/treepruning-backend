package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.impl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.domain.SchedulePreventivePruningDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PruningEntity;

@Mapper(componentModel = "spring")
public interface SchedulePreventivePruningDomainMapper {

    @Mapping(source = "status", target = "status.id")
    @Mapping(source = "tree", target = "tree.id")
    @Mapping(source = "quadrille", target = "quadrille.id")
    @Mapping(source = "type", target = "type.id")
    @Mapping(target = "pqr", ignore = true)
    PruningEntity toEntity(SchedulePreventivePruningDomain domain);
}
