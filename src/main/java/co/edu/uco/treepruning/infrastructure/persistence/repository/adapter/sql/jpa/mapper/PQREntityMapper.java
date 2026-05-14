package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PQREntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.PQRJPAEntity;

@Mapper(componentModel = "spring", uses = {
    StatusEntityMapper.class,
    RiskEntityMapper.class,
    SectorEntityMapper.class,
    PersonEntityMapper.class
})
public interface PQREntityMapper {

    PQRJPAEntity toJPA(PQREntity entity);
    PQREntity toEntity(PQRJPAEntity jpaEntity);
    List<PQREntity> toEntityList(List<PQRJPAEntity> jpaEntities);
}
