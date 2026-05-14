package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PersonEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.DocumentJPAEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.PersonJPAEntity;
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
public class PersonEntityMapperImpl implements PersonEntityMapper {

    @Autowired
    private DocumentEntityMapper documentEntityMapper;

    @Override
    public PersonJPAEntity toJPA(PersonEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID id = null;
        String firstName = null;
        String secondName = null;
        String firstLastName = null;
        String secondLastName = null;
        DocumentJPAEntity document = null;
        String documentNumber = null;
        LocalDate birthDate = null;
        String address = null;
        String email = null;
        boolean emailConfirmed = false;
        String phone = null;
        boolean phoneConfirmed = false;
        int age = 0;

        id = entity.getId();
        firstName = entity.getFirstName();
        secondName = entity.getSecondName();
        firstLastName = entity.getFirstLastName();
        secondLastName = entity.getSecondLastName();
        document = documentEntityMapper.toJPA( entity.getDocument() );
        documentNumber = entity.getDocumentNumber();
        birthDate = entity.getBirthDate();
        address = entity.getAddress();
        email = entity.getEmail();
        emailConfirmed = entity.isEmailConfirmed();
        phone = entity.getPhone();
        phoneConfirmed = entity.isPhoneConfirmed();
        age = entity.getAge();

        PersonJPAEntity personJPAEntity = new PersonJPAEntity( id, firstName, secondName, firstLastName, secondLastName, document, documentNumber, birthDate, address, email, emailConfirmed, phone, phoneConfirmed, age );

        return personJPAEntity;
    }

    @Override
    public PersonEntity toEntity(PersonJPAEntity jpaEntity) {
        if ( jpaEntity == null ) {
            return null;
        }

        PersonEntity personEntity = new PersonEntity();

        return personEntity;
    }

    @Override
    public List<PersonEntity> toEntityList(List<PersonJPAEntity> jpaEntities) {
        if ( jpaEntities == null ) {
            return null;
        }

        List<PersonEntity> list = new ArrayList<PersonEntity>( jpaEntities.size() );
        for ( PersonJPAEntity personJPAEntity : jpaEntities ) {
            list.add( toEntity( personJPAEntity ) );
        }

        return list;
    }
}
