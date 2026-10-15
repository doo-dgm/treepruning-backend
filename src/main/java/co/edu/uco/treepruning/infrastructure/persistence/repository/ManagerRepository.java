package co.edu.uco.treepruning.infrastructure.persistence.repository;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ManagerEntity;

public interface ManagerRepository {
    void create(ManagerEntity entity);
    void update(UUID id, ManagerEntity entity);
    void delete(UUID id);
    List<ManagerEntity> findAll();
    ManagerEntity findById(UUID id);
    List<ManagerEntity> findByFilter(UUID id);
}
