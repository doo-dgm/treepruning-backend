package co.edu.uco.treepruning.features.status.getstatusbyfilter.application.usecase.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.usecase.domain.GetStatusDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.StatusEntity;

@Mapper(componentModel = "spring")
public interface GetStatusDomainMapper {

    default GetStatusDomain toDomain(StatusEntity entity) {
        if (ObjectHelper.isNull(entity)) return null;
        return new GetStatusDomain(entity.getId(), entity.getName());
    }
}
