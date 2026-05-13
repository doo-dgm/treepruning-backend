package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PQREntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.PQRJPAEntity;

@Mapper(uses = {
    StatusEntityMapper.class,
    RiskEntityMapper.class,
    SectorEntityMapper.class,
    PersonEntityMapper.class
})
public interface PQREntityMapper {

    PQREntityMapper INSTANCE =
            Mappers.getMapper(PQREntityMapper.class);

    PQRJPAEntity toJPA(PQREntity entity);
    PQREntity toEntity(PQRJPAEntity jpaEntity);
}