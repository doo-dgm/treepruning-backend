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

    public RiskJPARepositoryAdapter(RiskJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public List<RiskEntity> findAll() {
        return repository.findAll()
            .stream()
            .map(RiskEntityMapper.INSTANCE::toEntity)
            .toList();
    }
}
