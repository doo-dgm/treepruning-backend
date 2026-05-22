package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity;

import java.time.LocalDate;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public class PersonJPAEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String secondName;

    @Column(name = "surname")
    private String firstLastName;

    @Column(name = "second_surname")
    private String secondLastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id")
    private DocumentJPAEntity document;

    @Column(name = "document_number")
    private String documentNumber;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "email_confirmed")
    private boolean emailConfirmed;

    @Column(name = "phone")
    private String phone;

    @Column(name = "phone_confirmed")
    private boolean phoneConfirmed;

    @Column(name = "age")
    private int age;

    public PersonJPAEntity() {}

    public PersonJPAEntity(UUID id, String firstName,
            String secondName, String firstLastName,
            String secondLastName, DocumentJPAEntity document,
            String documentNumber, LocalDate birthDate,
            String address, String email, boolean emailConfirmed,
            String phone, boolean phoneConfirmed, int age) {
        setId(id);
        setFirstName(firstName);
        setSecondName(secondName);
        setFirstLastName(firstLastName);
        setSecondLastName(secondLastName);
        setDocument(document);
        setDocumentNumber(documentNumber);
        setBirthDate(birthDate);
        setAddress(address);
        setEmail(email);
        setEmailConfirmed(emailConfirmed);
        setPhone(phone);
        setPhoneConfirmed(phoneConfirmed);
        setAge(age);
    }

    public UUID getId() {
        return id;
        }
    public String getFirstName() { 
        return firstName;
        }
    public String getSecondName() {
        return secondName;
        }
    public String getFirstLastName() {
        return firstLastName; 
        }
    public String getSecondLastName() {
        return secondLastName;
        }
    public DocumentJPAEntity getDocument() {
        return document; 
        }
    public String getDocumentNumber() {
        return documentNumber; 
    }
    public LocalDate getBirthDate() { 
        return birthDate;
        }
    public String getAddress() {
        return address;
        }
    public String getEmail() {
        return email;
        }
    public boolean isEmailConfirmed() {
        return emailConfirmed;
        }
    public String getPhone() { 
        return phone;
        }
    public boolean isPhoneConfirmed() {
        return phoneConfirmed; 
        }
    public int getAge() { 
        return age;
        }

    public void setId(UUID id) {
        this.id = id;
        }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
        }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
        }
    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
        }
    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
        }
    public void setDocument(DocumentJPAEntity document) {
        this.document = document;
        }
    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber; 
        }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate; 
        }
    public void setAddress(String address) {
        this.address = address; 
        }
    public void setEmail(String email) { 
        this.email = email;
        }
    public void setEmailConfirmed(boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
        }
    public void setPhone(String phone) { 
        this.phone = phone; 
        }
    public void setPhoneConfirmed(boolean phoneConfirmed) {
        this.phoneConfirmed = phoneConfirmed;
        }
    public void setAge(int age) { 
        this.age = age; 
        }
}
