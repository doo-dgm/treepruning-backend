package co.edu.uco.treepruning.features.person.updateperson.application.inputport.dto;

import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import java.time.LocalDate;
import java.util.UUID;

public final class UpdatePersonDTO {

    private UUID id;
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private UUID document;
    private String documentNumber;
    private LocalDate birthDate;
    private String address;
    private String email;
    private String phone;

    public UpdatePersonDTO(UUID id, String firstName, String secondName, String firstLastName, String secondLastName, UUID document, String documentNumber, LocalDate birthDate, String address, String email, String phone) {
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
        setPhone(phone);
    }

    public UpdatePersonDTO() {
        setId(UUIDHelper.getDefault());
        setFirstName(TextHelper.getDefault());
        setSecondName(TextHelper.getDefault());
        setFirstLastName(TextHelper.getDefault());
        setSecondLastName(TextHelper.getDefault());
        setDocument(UUIDHelper.getDefault());
        setDocumentNumber(TextHelper.getDefault());
        setBirthDate(DateHelper.getDefault());
        setAddress(TextHelper.getDefault());
        setEmail(TextHelper.getDefault());
        setPhone(TextHelper.getDefault());
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
    public UUID getDocument() {
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
    public String getPhone() {
        return phone;
    }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    private void setFirstName(final String firstName) {
        this.firstName = TextHelper.getDefaultWithTrim(firstName);
    }
    private void setSecondName(final String secondName) {
        this.secondName = TextHelper.getDefaultWithTrim(secondName);
    }
    private void setFirstLastName(final String firstLastName) {
        this.firstLastName = TextHelper.getDefaultWithTrim(firstLastName);
    }
    private void setSecondLastName(final String secondLastName) {
        this.secondLastName = TextHelper.getDefaultWithTrim(secondLastName);
    }
    private void setDocument(final UUID document) {
        this.document = UUIDHelper.getDefault(document);
    }
    private void setDocumentNumber(final String documentNumber) {
        this.documentNumber = TextHelper.getDefaultWithTrim(documentNumber);
    }
    private void setBirthDate(final LocalDate birthDate) {
        this.birthDate = DateHelper.getDefault(birthDate);
    }
    private void setAddress(final String address) {
        this.address = TextHelper.getDefaultWithTrim(address);
    }
    private void setEmail(final String email) {
        this.email = TextHelper.getDefaultWithTrim(email);
    }
    private void setPhone(final String phone) {
        this.phone = TextHelper.getDefaultWithTrim(phone);
    }
}
