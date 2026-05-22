package co.edu.uco.treepruning.features.person.getpersonbyfilter.application.usecase.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.inputport.dto.GetPersonDTO;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.usecase.GetPersonByFilterUseCase;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.usecase.domain.GetPersonDomain;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.usecase.impl.mapper.GetPersonDomainMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.PersonRepository;

@Service
public class GetPersonByFilterUseCaseImpl implements GetPersonByFilterUseCase {

    private final PersonRepository personRepository;
    private final GetPersonDomainMapper mapper;

    public GetPersonByFilterUseCaseImpl(PersonRepository personRepository,
            GetPersonDomainMapper mapper) {
        this.personRepository = personRepository;
        this.mapper = mapper;
    }

    @Override
    public List<GetPersonDomain> execute(GetPersonDTO filter) {
        return personRepository.findByFilter(filter.getId(), filter.getFirstName(), filter.getFirstLastName())
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}
