package reflection.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employers")
public class Employer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="users_id")
	private int id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_site")
	private String webSite;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="is_activated")
	private boolean isActivated;
	
	@Column(name="is_email_verified")
	private boolean isEmailVerified;

	public Employer() {
		super();
	}

	public Employer(int id, String companyName, String webSite, String phoneNumber, boolean isActivated,
			boolean isEmailVerified) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.webSite = webSite;
		this.phoneNumber = phoneNumber;
		this.isActivated = isActivated;
		this.isEmailVerified = isEmailVerified;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public boolean getIsActivated() {
		return isActivated;
	}

	public void setIsActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	public boolean getIsEmailVerified() {
		return isEmailVerified;
	}

	public void setIsEmailVerified(boolean isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}
}
