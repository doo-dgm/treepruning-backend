package co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.usecase.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.usecase.domain.GetSectorDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.SectorEntity;

@Mapper(componentModel = "spring")
public interface GetSectorDomainMapper {

    default GetSectorDomain toDomain(SectorEntity entity) {
        if (ObjectHelper.isNull(entity)) return null;
        return new GetSectorDomain(entity.getId(), entity.getName());
    }
}
