package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PruningEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.PruningJPAEntity;

@Mapper(uses = {
    StatusEntityMapper.class,
    TreeEntityMapper.class,
    QuadrilleEntityMapper.class,
    TypeEntityMapper.class,
    PQREntityMapper.class
})
public interface PruningEntityMapper {

    PruningEntityMapper INSTANCE =
            Mappers.getMapper(PruningEntityMapper.class);

    PruningJPAEntity toJPA(PruningEntity entity);
    PruningEntity toEntity(PruningJPAEntity jpaEntity);
}
