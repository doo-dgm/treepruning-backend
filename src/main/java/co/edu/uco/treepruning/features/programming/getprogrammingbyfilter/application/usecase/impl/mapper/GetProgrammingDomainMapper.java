package co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.usecase.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.usecase.domain.GetProgrammingDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ProgrammingEntity;

@Mapper(componentModel = "spring")
public interface GetProgrammingDomainMapper {

    default GetProgrammingDomain toDomain(ProgrammingEntity entity) {
        if (ObjectHelper.isNull(entity)) return null;
        return new GetProgrammingDomain(entity.getId(), entity.getInitialDate(),
                entity.getFrequencyMonths(), entity.getAmount());
    }
}
