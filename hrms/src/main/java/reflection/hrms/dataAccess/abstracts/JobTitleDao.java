package reflection.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import reflection.hrms.entities.concretes.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer>{

}
