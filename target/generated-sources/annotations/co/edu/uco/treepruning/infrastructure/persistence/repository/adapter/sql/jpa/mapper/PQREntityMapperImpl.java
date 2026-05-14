package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PQREntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.PQRJPAEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.PersonJPAEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.RiskJPAEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.SectorJPAEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.StatusJPAEntity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-14T12:41:16-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 26.0.1 (Oracle Corporation)"
)
@Component
public class PQREntityMapperImpl implements PQREntityMapper {

    @Autowired
    private StatusEntityMapper statusEntityMapper;
    @Autowired
    private RiskEntityMapper riskEntityMapper;
    @Autowired
    private SectorEntityMapper sectorEntityMapper;
    @Autowired
    private PersonEntityMapper personEntityMapper;

    @Override
    public PQRJPAEntity toJPA(PQREntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID id = null;
        LocalDate date = null;
        StatusJPAEntity status = null;
        RiskJPAEntity risk = null;
        SectorJPAEntity sector = null;
        PersonJPAEntity person = null;
        String photographicRecordPath = null;

        id = entity.getId();
        date = entity.getDate();
        status = statusEntityMapper.toJPA( entity.getStatus() );
        risk = riskEntityMapper.toJPA( entity.getRisk() );
        sector = sectorEntityMapper.toJPA( entity.getSector() );
        person = personEntityMapper.toJPA( entity.getPerson() );
        photographicRecordPath = entity.getPhotographicRecordPath();

        PQRJPAEntity pQRJPAEntity = new PQRJPAEntity( id, date, status, risk, sector, person, photographicRecordPath );

        return pQRJPAEntity;
    }

    @Override
    public PQREntity toEntity(PQRJPAEntity jpaEntity) {
        if ( jpaEntity == null ) {
            return null;
        }

        PQREntity pQREntity = new PQREntity();

        return pQREntity;
    }

    @Override
    public List<PQREntity> toEntityList(List<PQRJPAEntity> jpaEntities) {
        if ( jpaEntities == null ) {
            return null;
        }

        List<PQREntity> list = new ArrayList<PQREntity>( jpaEntities.size() );
        for ( PQRJPAEntity pQRJPAEntity : jpaEntities ) {
            list.add( toEntity( pQRJPAEntity ) );
        }

        return list;
    }
}
