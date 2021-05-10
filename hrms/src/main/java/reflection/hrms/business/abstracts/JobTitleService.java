package reflection.hrms.business.abstracts;

import java.util.List;

import reflection.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	
	List<JobTitle> getAll();
	JobTitle getById();
	void add();
	void delete();
	void update();
	
}
