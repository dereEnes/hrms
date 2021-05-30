package reflection.hrms.entities.concretes.dtos;

import java.time.LocalDate;

public class RegisterCandidateDto {

	private String email;
	
	private String password;
	
	private String passwordRepeat;
	
	public String getPasswordRepeat() {
		return passwordRepeat;
	}

	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}

	private String firstName;
	
	private String lastName;
	
	private String nationalIdentity;
	
	private LocalDate dateOfBirth;

	public RegisterCandidateDto() {
		super();
	}

	public RegisterCandidateDto(String email, String password, String passwordRepeat, String firstName, String lastName,
			String nationalIdentity, LocalDate dateOfBirth) {
		this.email = email;
		this.password = password;
		this.password = passwordRepeat;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalIdentity = nationalIdentity;
		this.dateOfBirth = dateOfBirth;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNationalIdentity() {
		return nationalIdentity;
	}

	public void setNationalIdentity(String nationalIdentity) {
		this.nationalIdentity = nationalIdentity;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
}
