package co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.usecase.impl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.usecase.domain.GetManagerDomain;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.usecase.domain.GetPersonDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ManagerEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PersonEntity;

@Mapper(componentModel = "spring")
public interface GetManagerDomainMapper {

    @Mapping(target = "person", expression = "java(buildPerson(entity.getPerson()))")
    GetManagerDomain toDomain(ManagerEntity entity);

    default GetPersonDomain buildPerson(PersonEntity person) {
        if (ObjectHelper.isNull(person)) return null;
        return new GetPersonDomain(person.getId(), person.getFirstName(), person.getSecondName(),
                person.getFirstLastName(), person.getSecondLastName(), person.getDocumentNumber(),
                person.getBirthDate(), person.getAddress(), person.getEmail(),
                person.getPhone(), person.getAge());
    }
}
