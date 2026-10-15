package co.edu.uco.treepruning.infrastructure.persistence.repository;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.FamilyEntity;

public interface FamilyRepository {
    void create(FamilyEntity entity);
    void update(UUID id, FamilyEntity entity);
    void delete(UUID id);
    List<FamilyEntity> findAll();
    FamilyEntity findById(UUID id);
    List<FamilyEntity> findByFilter(UUID id, String commonName, String scientificName);
}
