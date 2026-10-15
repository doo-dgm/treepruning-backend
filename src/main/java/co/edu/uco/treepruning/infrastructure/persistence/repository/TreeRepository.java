package co.edu.uco.treepruning.infrastructure.persistence.repository;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TreeEntity;

public interface TreeRepository {
    void create(TreeEntity entity);
    void update(UUID id, TreeEntity entity);
    void delete(UUID id);
    List<TreeEntity> findAll();
    TreeEntity findById(UUID id);
    List<TreeEntity> findByFilter(UUID id, UUID familyId, UUID sectorId);
}
