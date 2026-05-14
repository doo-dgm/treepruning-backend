package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PruningEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.PruningJPAEntity;

@Mapper(componentModel = "spring", uses = {
    StatusEntityMapper.class,
    TreeEntityMapper.class,
    QuadrilleEntityMapper.class,
    TypeEntityMapper.class,
    PQREntityMapper.class
})
public interface PruningEntityMapper {

    PruningJPAEntity toJPA(PruningEntity entity);
    PruningEntity toEntity(PruningJPAEntity jpaEntity);
    List<PruningEntity> toEntityList(List<PruningJPAEntity> jpaEntities);
}
