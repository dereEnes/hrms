package reflection.hrms.entities.concretes.dtos;

import java.util.Date;

public class JobAdvertisementDto {

	
	private int employerId;
	
	
	private int jobTitleId;
	
	
	private String description;
	
	
	private short provinceId;
	
	
	private short maxSalary;
	
	
	private short minSalary;
	
	
	private short countOfPerson;
	
	
	private Date deadline;
	
	
	private boolean isActive;

	
	private Date dateOfAdvertisement;


	public JobAdvertisementDto() {
		super();
	}


	public JobAdvertisementDto(int employerId, int jobTitleId, String description, short provinceId, short maxSalary,
			short minSalary, short countOfPerson, Date deadline, boolean isActive, Date dateOfAdvertisement) {
		super();
		this.employerId = employerId;
		this.jobTitleId = jobTitleId;
		this.description = description;
		this.provinceId = provinceId;
		this.maxSalary = maxSalary;
		this.minSalary = minSalary;
		this.countOfPerson = countOfPerson;
		this.deadline = deadline;
		this.isActive = isActive;
		this.dateOfAdvertisement = dateOfAdvertisement;
	}


	public int getEmployerId() {
		return employerId;
	}


	public void setEmployerId(int employerId) {
		this.employerId = employerId;
	}


	public int getJobTitleId() {
		return jobTitleId;
	}


	public void setJobTitleId(int jobTitleId) {
		this.jobTitleId = jobTitleId;
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
