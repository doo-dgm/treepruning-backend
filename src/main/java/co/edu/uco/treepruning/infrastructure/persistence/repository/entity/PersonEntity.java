package co.edu.uco.treepruning.infrastructure.persistence.repository.entity;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.BooleanHelper;
import co.edu.uco.treepruning.crosscuting.helper.DateHelper;
import co.edu.uco.treepruning.crosscuting.helper.NumericHelper;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public class PersonEntity {

    private UUID id;
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private DocumentEntity document;
    private String documentNumber;
    private LocalDate birthDate;
    private String address;
    private String email;
    private boolean emailConfirmed;
    private String phone;
    private boolean phoneConfirmed;
    private int age;
    
    public PersonEntity() {
    	
    }
    
    public PersonEntity(UUID id) {
    			setId(id);
    			setFirstName(TextHelper.getDefault());
    			setSecondName(TextHelper.getDefault());
    			setFirstLastName(TextHelper.getDefault());
    			setSecondLastName(TextHelper.getDefault());
    			setDocument(new DocumentEntity());
    			setDocumentNumber(TextHelper.getDefault());
    			setBirthDate(DateHelper.getDateHelper().getDefault());
    			setAddress(TextHelper.getDefault());
    			setEmail(TextHelper.getDefault());
    			setEmailConfirmed(BooleanHelper.getDefault(false));
    			setPhone(TextHelper.getDefault());
    			setPhoneConfirmed(BooleanHelper.getDefault(false));
    			setAge(NumericHelper.getDefaultInt());    			
    }
    
	public PersonEntity(UUID id, String firstName, String secondName, String firstLastName, String secondLastName,
			DocumentEntity document, String documentNumber, LocalDate birthDate, String address, String email,
			boolean emailConfirmed, String phone, boolean phoneConfirmed, int age) {
		super();
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
	public DocumentEntity getDocument() {
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
	
	private void setId(UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}
	private void setFirstName(String firstName) {
		this.firstName = TextHelper.getDefaultWithTrim(firstName);
	}
	private void setSecondName(String secondName) {
		this.secondName = TextHelper.getDefaultWithTrim(secondName);
	}
	private void setFirstLastName(String firstLastName) {
		this.firstLastName = TextHelper.getDefaultWithTrim(firstLastName);
	}
	private void setSecondLastName(String secondLastName) {
		this.secondLastName = TextHelper.getDefaultWithTrim(secondLastName);
	}
	private void setDocument(DocumentEntity document) {
		this.document = ObjectHelper.getDefault(document, null);
	}
	private void setDocumentNumber(String documentNumber) {
		this.documentNumber = TextHelper.getDefaultWithTrim(documentNumber);
	}
	private void setBirthDate(LocalDate birthDate) {
		this.birthDate = DateHelper.getDateHelper().getDefault(birthDate);
	}
	private void setAddress(String address) {
		this.address = TextHelper.getDefaultWithTrim(address);
	}
	private void setEmail(String email) {
		this.email = TextHelper.getDefaultWithTrim(email);
	}
	private void setEmailConfirmed(boolean emailConfirmed) {
		this.emailConfirmed = BooleanHelper.getDefault(emailConfirmed);
	}
	private void setPhone(String phone) {
		this.phone = TextHelper.getDefaultWithTrim(phone);
	}
	private void setPhoneConfirmed(boolean phoneConfirmed) {
		this.phoneConfirmed = BooleanHelper.getDefault(phoneConfirmed);
	}
	private void setAge(int age) {
		this.age = NumericHelper.getDefaultInt(age);
	}
	
}
