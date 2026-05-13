package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.QuadrilleEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.QuadrilleJPAEntity;

@Mapper(uses = ManagerEntityMapper.class)
public interface QuadrilleEntityMapper {

    QuadrilleEntityMapper INSTANCE =
            Mappers.getMapper(QuadrilleEntityMapper.class);

    QuadrilleJPAEntity toJPA(QuadrilleEntity entity);
    QuadrilleEntity toEntity(QuadrilleJPAEntity jpaEntity);
}