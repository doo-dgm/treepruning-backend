package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ProgrammingEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.ProgrammingJPAEntity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-16T00:07:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 26.0.1 (Oracle Corporation)"
)
@Component
public class ProgrammingEntityMapperImpl implements ProgrammingEntityMapper {

    @Override
    public ProgrammingJPAEntity toJPA(ProgrammingEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID id = null;
        LocalDate initialDate = null;
        int frequencyMonths = 0;
        int amount = 0;

        id = entity.getId();
        initialDate = entity.getInitialDate();
        frequencyMonths = entity.getFrequencyMonths();
        amount = entity.getAmount();

        ProgrammingJPAEntity programmingJPAEntity = new ProgrammingJPAEntity( id, initialDate, frequencyMonths, amount );

        return programmingJPAEntity;
    }

    @Override
    public ProgrammingEntity toEntity(ProgrammingJPAEntity jpaEntity) {
        if ( jpaEntity == null ) {
            return null;
        }

        ProgrammingEntity programmingEntity = new ProgrammingEntity();

        return programmingEntity;
    }

    @Override
    public List<ProgrammingEntity> toEntityList(List<ProgrammingJPAEntity> jpaEntities) {
        if ( jpaEntities == null ) {
            return null;
        }

        List<ProgrammingEntity> list = new ArrayList<ProgrammingEntity>( jpaEntities.size() );
        for ( ProgrammingJPAEntity programmingJPAEntity : jpaEntities ) {
            list.add( toEntity( programmingJPAEntity ) );
        }

        return list;
    }
}
