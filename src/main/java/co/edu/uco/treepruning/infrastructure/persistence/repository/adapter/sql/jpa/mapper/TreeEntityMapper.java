package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TreeEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.TreeJPAEntity;

@Mapper(uses = {
    FamilyEntityMapper.class,
    SectorEntityMapper.class,
    ProgrammingEntityMapper.class
}
)
public interface TreeEntityMapper {

    TreeEntityMapper INSTANCE =
            Mappers.getMapper(TreeEntityMapper.class);

    TreeJPAEntity toJPA(TreeEntity entity);
    TreeEntity toEntity(TreeJPAEntity jpaEntity);
}