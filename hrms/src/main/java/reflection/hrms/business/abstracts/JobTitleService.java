package reflection.hrms.business.abstracts;

import java.util.List;

import reflection.hrms.core.utilities.results.DataResult;
import reflection.hrms.core.utilities.results.Result;
import reflection.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	
	DataResult<List<JobTitle>> getAll();
	DataResult<JobTitle> getById(int id);
	DataResult<JobTitle> getByTitle(String title);
	Result add(JobTitle jobTitle);
	Result delete(JobTitle jobTitle);
	Result update(JobTitle jobTitle);
	
}
