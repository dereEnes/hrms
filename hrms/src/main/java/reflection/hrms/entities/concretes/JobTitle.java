package reflection.hrms.entities.concretes;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="job_positions")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
public class JobTitle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_title_id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@OneToMany(mappedBy = "jobTitle")
	private List<JobAdvertisement> jobAdvertisements;
	
	public JobTitle() {
		
	}
	
	
	public JobTitle(int id, String title) {
		this.id = id;
		this.title = title;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
