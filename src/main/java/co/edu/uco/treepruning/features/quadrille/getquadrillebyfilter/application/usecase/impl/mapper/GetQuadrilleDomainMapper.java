package co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.usecase.impl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.usecase.domain.GetManagerDomain;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.usecase.domain.GetPersonDomain;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.usecase.domain.GetQuadrilleDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ManagerEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PersonEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.QuadrilleEntity;

@Mapper(componentModel = "spring")
public interface GetQuadrilleDomainMapper {

    @Mapping(target = "manager", expression = "java(buildManager(entity.getManager()))")
    GetQuadrilleDomain toDomain(QuadrilleEntity entity);

    default GetManagerDomain buildManager(ManagerEntity manager) {
        if (ObjectHelper.isNull(manager)) return null;
        return new GetManagerDomain(manager.getId(), buildPerson(manager.getPerson()));
    }

    default GetPersonDomain buildPerson(PersonEntity person) {
        if (ObjectHelper.isNull(person)) return null;
        return new GetPersonDomain(person.getId(), person.getFirstName(), person.getSecondName(),
                person.getFirstLastName(), person.getSecondLastName(), person.getDocumentNumber(),
                person.getBirthDate(), person.getAddress(), person.getEmail(),
                person.getPhone(), person.getAge());
    }
}
