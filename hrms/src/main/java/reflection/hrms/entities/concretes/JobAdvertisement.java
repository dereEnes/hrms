package reflection.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="job_advertisements")
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	//@Column(name="employer_id")
	//private int employerId;
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	//@Column(name="job_position_id")
	//private short jobPositionId;
	@ManyToOne()
	@JoinColumn(name="job_title_id")
	private JobTitle jobTitle;
	
	@Column(name="description")
	private String description;
	
	@Column(name="province_id")
	private short provinceId;
	
	@Column(name="max_salary")
	private short maxSalary;

	@Column(name="min_salary")
	private short minSalary;
	
	@Column(name="count_of_person")
	private short countOfPerson;
	
	@Column(name="deadline")
	private Date deadline;
	
	@Column(name="is_active")
	private boolean isActive;

	@Column(name="date_of_advertisement")
	private Date dateOfAdvertisement;
	
	public JobAdvertisement() {
		super();
	}

	public JobAdvertisement(int id, Employer employer, JobTitle jobTitle, String description, short provinceId,
			short maxSalary, short minSalary, short countOfPerson, Date deadline, boolean isActive, Date dateOfAdvertisement) {
		super();
		this.id = id;
		this.employer = employer;
		this.jobTitle = jobTitle;
		this.description = description;
		this.provinceId = provinceId;
		this.maxSalary = maxSalary;
		this.minSalary = minSalary;
		this.countOfPerson = countOfPerson;
		this.deadline = deadline;
		this.isActive = isActive;
		this.dateOfAdvertisement = dateOfAdvertisement;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public JobTitle getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public short getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(short provinceId) {
		this.provinceId = provinceId;
	}

	public short getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(short maxSalary) {
		this.maxSalary = maxSalary;
	}

	public short getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(short minSalary) {
		this.minSalary = minSalary;
	}

	public short getCountOfPerson() {
		return countOfPerson;
	}

	public void setCountOfPerson(short countOfPerson) {
		this.countOfPerson = countOfPerson;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getDateOfAdvertisement() {
		return dateOfAdvertisement;
	}

	public void setDateOfAdvertisement(Date dateOfAdvertisement) {
		this.dateOfAdvertisement = dateOfAdvertisement;
	}
	
	
	
}
