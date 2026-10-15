package co.edu.uco.treepruning.infrastructure.persistence.repository;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.QuadrilleEntity;

public interface QuadrilleRepository {
    void create(QuadrilleEntity entity);
    void update(UUID id, QuadrilleEntity entity);
    void delete(UUID id);
    List<QuadrilleEntity> findAll();
    QuadrilleEntity findById(UUID id);
    List<QuadrilleEntity> findByFilter(UUID id, String quadrilleName, UUID managerId);
}
