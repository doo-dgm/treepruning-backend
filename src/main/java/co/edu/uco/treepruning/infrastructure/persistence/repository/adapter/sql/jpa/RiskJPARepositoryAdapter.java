package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.infrastructure.persistence.repository.RiskRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.RiskEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.RiskEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.RiskJPARepository;

@Repository
public class RiskJPARepositoryAdapter implements RiskRepository {

    private final RiskJPARepository repository;
    private final RiskEntityMapper mapper;

    public RiskJPARepositoryAdapter(RiskJPARepository repository,
            RiskEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<RiskEntity> findAll() {
        return mapper.toEntityList(repository.findAll());
    }
}
