package co.edu.uco.treepruning.infrastructure.persistence.repository;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ProgrammingEntity;

public interface ProgrammingRepository {
    void create(ProgrammingEntity entity);
    void update(UUID id, ProgrammingEntity entity);
    void delete(UUID id);
    List<ProgrammingEntity> findAll();
    ProgrammingEntity findById(UUID id);
    List<ProgrammingEntity> findByFilter(UUID id);
}
