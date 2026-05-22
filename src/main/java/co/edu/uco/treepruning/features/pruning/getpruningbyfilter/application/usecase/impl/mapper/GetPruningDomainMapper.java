package co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.usecase.impl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.usecase.domain.GetFamilyDomain;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.usecase.domain.GetManagerDomain;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.usecase.domain.GetPersonDomain;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.usecase.domain.GetProgrammingDomain;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.usecase.domain.GetPruningDomain;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.usecase.domain.GetQuadrilleDomain;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.usecase.domain.GetSectorDomain;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.usecase.domain.GetStatusDomain;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.usecase.domain.GetTreeDomain;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.usecase.domain.GetTypeDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.FamilyEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ManagerEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PersonEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ProgrammingEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PruningEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.QuadrilleEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.SectorEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.StatusEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TreeEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TypeEntity;

@Mapper(componentModel = "spring")
public interface GetPruningDomainMapper {

    @Mapping(target = "status",    expression = "java(buildStatus(entity.getStatus()))")
    @Mapping(target = "tree",      expression = "java(buildTree(entity.getTree()))")
    @Mapping(target = "quadrille", expression = "java(buildQuadrille(entity.getQuadrille()))")
    @Mapping(target = "type",      expression = "java(buildType(entity.getType()))")
    @Mapping(source = "pqr.id",   target = "pqr")
    GetPruningDomain toDomain(PruningEntity entity);

    default GetStatusDomain buildStatus(StatusEntity s) {
        if (ObjectHelper.isNull(s)) return null;
        return new GetStatusDomain(s.getId(), s.getName());
    }

    default GetTreeDomain buildTree(TreeEntity t) {
        if (ObjectHelper.isNull(t)) return null;
        return new GetTreeDomain(t.getId(), t.getLongitude(), t.getLatitude(),
                buildTreeFamily(t.getFamily()), buildTreeSector(t.getSector()), buildTreeProgramming(t.getProgramming()));
    }

    default GetFamilyDomain buildTreeFamily(FamilyEntity f) {
        if (ObjectHelper.isNull(f)) return null;
        return new GetFamilyDomain(f.getId(), f.getCommonName(), f.getScientificName());
    }

    default GetSectorDomain buildTreeSector(SectorEntity s) {
        if (ObjectHelper.isNull(s)) return null;
        return new GetSectorDomain(s.getId(), s.getName());
    }

    default GetProgrammingDomain buildTreeProgramming(ProgrammingEntity p) {
        if (ObjectHelper.isNull(p)) return null;
        return new GetProgrammingDomain(p.getId(), p.getInitialDate(), p.getFrequencyMonths(), p.getAmount());
    }

    default GetQuadrilleDomain buildQuadrille(QuadrilleEntity q) {
        if (ObjectHelper.isNull(q)) return null;
        return new GetQuadrilleDomain(q.getId(), q.getQuadrilleName(), buildQuadrilleManager(q.getManager()));
    }

    default GetManagerDomain buildQuadrilleManager(ManagerEntity manager) {
        if (ObjectHelper.isNull(manager)) return null;
        return new GetManagerDomain(manager.getId(), buildQuadrillePerson(manager.getPerson()));
    }

    default GetPersonDomain buildQuadrillePerson(PersonEntity person) {
        if (ObjectHelper.isNull(person)) return null;
        return new GetPersonDomain(person.getId(), person.getFirstName(), person.getSecondName(),
                person.getFirstLastName(), person.getSecondLastName(), person.getDocumentNumber(),
                person.getBirthDate(), person.getAddress(), person.getEmail(),
                person.getPhone(), person.getAge());
    }

    default GetTypeDomain buildType(TypeEntity t) {
        if (ObjectHelper.isNull(t)) return null;
        return new GetTypeDomain(t.getId(), t.getName());
    }
}
