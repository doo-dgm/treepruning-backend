package co.edu.uco.treepruning.features.type.gettypebyfilter.application.usecase.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.usecase.domain.GetTypeDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TypeEntity;

@Mapper(componentModel = "spring")
public interface GetTypeDomainMapper {

    default GetTypeDomain toDomain(TypeEntity entity) {
        if (ObjectHelper.isNull(entity)) return null;
        return new GetTypeDomain(entity.getId(), entity.getName());
    }
}
