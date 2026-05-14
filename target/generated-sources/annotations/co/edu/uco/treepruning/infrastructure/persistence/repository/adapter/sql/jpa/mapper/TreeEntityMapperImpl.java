package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TreeEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.FamilyJPAEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.ProgrammingJPAEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.SectorJPAEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.TreeJPAEntity;
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
public class TreeEntityMapperImpl implements TreeEntityMapper {

    @Autowired
    private FamilyEntityMapper familyEntityMapper;
    @Autowired
    private SectorEntityMapper sectorEntityMapper;
    @Autowired
    private ProgrammingEntityMapper programmingEntityMapper;

    @Override
    public TreeJPAEntity toJPA(TreeEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID id = null;
        String longitude = null;
        String latitude = null;
        FamilyJPAEntity family = null;
        SectorJPAEntity sector = null;
        ProgrammingJPAEntity programming = null;

        id = entity.getId();
        longitude = entity.getLongitude();
        latitude = entity.getLatitude();
        family = familyEntityMapper.toJPA( entity.getFamily() );
        sector = sectorEntityMapper.toJPA( entity.getSector() );
        programming = programmingEntityMapper.toJPA( entity.getProgramming() );

        TreeJPAEntity treeJPAEntity = new TreeJPAEntity( id, longitude, latitude, family, sector, programming );

        return treeJPAEntity;
    }

    @Override
    public TreeEntity toEntity(TreeJPAEntity jpaEntity) {
        if ( jpaEntity == null ) {
            return null;
        }

        TreeEntity treeEntity = new TreeEntity();

        return treeEntity;
    }

    @Override
    public List<TreeEntity> toEntityList(List<TreeJPAEntity> jpaEntities) {
        if ( jpaEntities == null ) {
            return null;
        }

        List<TreeEntity> list = new ArrayList<TreeEntity>( jpaEntities.size() );
        for ( TreeJPAEntity treeJPAEntity : jpaEntities ) {
            list.add( toEntity( treeJPAEntity ) );
        }

        return list;
    }
}
