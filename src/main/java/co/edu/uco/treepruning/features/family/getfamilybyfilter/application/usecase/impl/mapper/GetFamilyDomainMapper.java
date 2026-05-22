package co.edu.uco.treepruning.features.family.getfamilybyfilter.application.usecase.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.usecase.domain.GetFamilyDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.FamilyEntity;

@Mapper(componentModel = "spring")
public interface GetFamilyDomainMapper {

    default GetFamilyDomain toDomain(FamilyEntity entity) {
        if (ObjectHelper.isNull(entity)) return null;
        return new GetFamilyDomain(entity.getId(), entity.getCommonName(), entity.getScientificName());
    }
}
