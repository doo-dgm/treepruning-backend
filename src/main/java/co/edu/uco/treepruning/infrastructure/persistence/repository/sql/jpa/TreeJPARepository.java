package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.TreeJPAEntity;

public interface TreeJPARepository extends JpaRepository<TreeJPAEntity, UUID> {
}
