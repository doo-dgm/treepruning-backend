package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PruningEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.PQRJPAEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.PruningJPAEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.QuadrilleJPAEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.StatusJPAEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.TreeJPAEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.TypeJPAEntity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-16T00:07:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 26.0.1 (Oracle Corporation)"
)
@Component
public class PruningEntityMapperImpl implements PruningEntityMapper {

    @Autowired
    private StatusEntityMapper statusEntityMapper;
    @Autowired
    private TreeEntityMapper treeEntityMapper;
    @Autowired
    private QuadrilleEntityMapper quadrilleEntityMapper;
    @Autowired
    private TypeEntityMapper typeEntityMapper;
    @Autowired
    private PQREntityMapper pQREntityMapper;

    @Override
    public PruningJPAEntity toJPA(PruningEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID id = null;
        StatusJPAEntity status = null;
        LocalDate plannedDate = null;
        LocalDate executedDate = null;
        TreeJPAEntity tree = null;
        QuadrilleJPAEntity quadrille = null;
        TypeJPAEntity type = null;
        PQRJPAEntity pqr = null;
        String photographicRecordPath = null;
        String observations = null;

        id = entity.getId();
        status = statusEntityMapper.toJPA( entity.getStatus() );
        plannedDate = entity.getPlannedDate();
        executedDate = entity.getExecutedDate();
        tree = treeEntityMapper.toJPA( entity.getTree() );
        quadrille = quadrilleEntityMapper.toJPA( entity.getQuadrille() );
        type = typeEntityMapper.toJPA( entity.getType() );
        pqr = pQREntityMapper.toJPA( entity.getPqr() );
        photographicRecordPath = entity.getPhotographicRecordPath();
        observations = entity.getObservations();

        PruningJPAEntity pruningJPAEntity = new PruningJPAEntity( id, status, plannedDate, executedDate, tree, quadrille, type, pqr, photographicRecordPath, observations );

        return pruningJPAEntity;
    }

    @Override
    public PruningEntity toEntity(PruningJPAEntity jpaEntity) {
        if ( jpaEntity == null ) {
            return null;
        }

        PruningEntity pruningEntity = new PruningEntity();

        return pruningEntity;
    }

    @Override
    public List<PruningEntity> toEntityList(List<PruningJPAEntity> jpaEntities) {
        if ( jpaEntities == null ) {
            return null;
        }

        List<PruningEntity> list = new ArrayList<PruningEntity>( jpaEntities.size() );
        for ( PruningJPAEntity pruningJPAEntity : jpaEntities ) {
            list.add( toEntity( pruningJPAEntity ) );
        }

        return list;
    }
}
