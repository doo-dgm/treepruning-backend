package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TreeEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.TreeJPAEntity;

@Mapper(componentModel = "spring", uses = {
    FamilyEntityMapper.class,
    SectorEntityMapper.class,
    ProgrammingEntityMapper.class
})
public interface TreeEntityMapper {

    TreeJPAEntity toJPA(TreeEntity entity);
    TreeEntity toEntity(TreeJPAEntity jpaEntity);
    List<TreeEntity> toEntityList(List<TreeJPAEntity> jpaEntities);
}
