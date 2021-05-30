package reflection.hrms.entities.concretes.dtos;


public class RegisterEmployerDto {

	private String email;

	private String password;

	private String passwordRepeat;
	
	private String companyName;

	private String webSite;

	private String phoneNumber;

	public RegisterEmployerDto() {
		super();
	}

	public RegisterEmployerDto(String email, String password, String passwordRepeat, String companyName, String webSite,
			String phoneNumber) {
		super();
		this.email = email;
		this.password = password;
		this.passwordRepeat = passwordRepeat;
		this.companyName = companyName;
		this.webSite = webSite;
		this.phoneNumber = phoneNumber;
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

	public String getPasswordRepeat() {
		return passwordRepeat;
	}

	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
