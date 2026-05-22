package co.edu.uco.treepruning.features.person.getpersonbyfilter.application.usecase.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.usecase.domain.GetPersonDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PersonEntity;

@Mapper(componentModel = "spring")
public interface GetPersonDomainMapper {

    default GetPersonDomain toDomain(PersonEntity entity) {
        if (ObjectHelper.isNull(entity)) return null;
        return new GetPersonDomain(entity.getId(), entity.getFirstName(), entity.getSecondName(),
                entity.getFirstLastName(), entity.getSecondLastName(), entity.getDocumentNumber(),
                entity.getBirthDate(), entity.getAddress(), entity.getEmail(),
                entity.getPhone(), entity.getAge());
    }
}
