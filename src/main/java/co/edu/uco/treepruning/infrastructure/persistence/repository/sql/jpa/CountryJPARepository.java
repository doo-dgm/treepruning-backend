package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.CountryJPAEntity;

public interface CountryJPARepository extends JpaRepository<CountryJPAEntity, UUID>{

}
