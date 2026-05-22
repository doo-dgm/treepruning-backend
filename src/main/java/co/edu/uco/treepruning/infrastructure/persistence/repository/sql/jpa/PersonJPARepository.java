package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.PersonJPAEntity;

public interface PersonJPARepository extends JpaRepository<PersonJPAEntity, UUID> {

    @Query("SELECT p FROM PersonJPAEntity p WHERE " +
           "(:id IS NULL OR p.id = :id) AND " +
           "(:firstName IS NULL OR p.firstName ILIKE concat('%', CAST(:firstName AS String), '%')) AND " +
           "(:firstLastName IS NULL OR p.firstLastName ILIKE concat('%', CAST(:firstLastName AS String), '%'))")
    List<PersonJPAEntity> findByFilter(@Param("id") UUID id,
                                       @Param("firstName") String firstName,
                                       @Param("firstLastName") String firstLastName);
}
