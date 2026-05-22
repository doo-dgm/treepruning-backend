package co.edu.uco.treepruning.features.tree.gettreebyfilter.application.usecase.impl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.usecase.domain.GetFamilyDomain;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.usecase.domain.GetProgrammingDomain;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.usecase.domain.GetSectorDomain;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.usecase.domain.GetTreeDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.FamilyEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ProgrammingEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.SectorEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TreeEntity;

@Mapper(componentModel = "spring")
public interface GetTreeDomainMapper {

    @Mapping(target = "family",      expression = "java(buildFamily(entity.getFamily()))")
    @Mapping(target = "sector",      expression = "java(buildSector(entity.getSector()))")
    @Mapping(target = "programming", expression = "java(buildProgramming(entity.getProgramming()))")
    GetTreeDomain toDomain(TreeEntity entity);

    default GetFamilyDomain buildFamily(FamilyEntity f) {
        if (ObjectHelper.isNull(f)) return null;
        return new GetFamilyDomain(f.getId(), f.getCommonName(), f.getScientificName());
    }

    default GetSectorDomain buildSector(SectorEntity s) {
        if (ObjectHelper.isNull(s)) return null;
        return new GetSectorDomain(s.getId(), s.getName());
    }

    default GetProgrammingDomain buildProgramming(ProgrammingEntity p) {
        if (ObjectHelper.isNull(p)) return null;
        return new GetProgrammingDomain(p.getId(), p.getInitialDate(), p.getFrequencyMonths(), p.getAmount());
    }
}
