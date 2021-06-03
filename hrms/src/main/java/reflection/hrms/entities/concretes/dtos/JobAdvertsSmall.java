package reflection.hrms.entities.concretes.dtos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import reflection.hrms.entities.concretes.Employer;
import reflection.hrms.entities.concretes.JobTitle;

@Entity
@Table(name="job_advertisements")
public class JobAdvertsSmall {

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
	
	@Column(name="count_of_person")
	private short countOfPerson;
	
	@Column(name="deadline")
	private Date deadline;

	@Column(name="date_of_advertisement")
	private Date dateOfAdvertisement;
	

	public JobAdvertsSmall() {
		super();
	}

	public JobAdvertsSmall(int id, Employer employer, JobTitle jobTitle, short countOfPerson, Date deadline,
			Date dateOfAdvertisement) {
		super();
		this.id = id;
		this.employer = employer;
		this.jobTitle = jobTitle;
		this.countOfPerson = countOfPerson;
		this.deadline = deadline;
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

	public Date getDateOfAdvertisement() {
		return dateOfAdvertisement;
	}

	public void setDateOfAdvertisement(Date dateOfAdvertisement) {
		this.dateOfAdvertisement = dateOfAdvertisement;
	}
	
	
	
}
