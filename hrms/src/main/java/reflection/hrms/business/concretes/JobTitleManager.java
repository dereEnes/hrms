package reflection.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import reflection.hrms.business.abstracts.JobTitleService;
import reflection.hrms.business.constants.Message;
import reflection.hrms.core.utilities.results.DataResult;
import reflection.hrms.core.utilities.results.ErrorResult;
import reflection.hrms.core.utilities.results.Result;
import reflection.hrms.core.utilities.results.SuccessDataResult;
import reflection.hrms.core.utilities.results.SuccessResult;
import reflection.hrms.dataAccess.abstracts.JobTitleDao;
import reflection.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{

	private JobTitleDao jobTitleDao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll());
	}

	@Override
	public DataResult<JobTitle> getById(int id) {
		JobTitle temp = this.jobTitleDao.getOne(id); 
		return new SuccessDataResult<JobTitle>(temp);
	}

	@Override
	public Result add(JobTitle jobTitle) {
		if(checkJobTitleAlreadyInsert(jobTitle) == false) {
			return new ErrorResult(Message.jobTittleAlreadyInserted);
		}
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult(Message.jobTitleAdded);
	}

	@Override
	public Result delete(JobTitle jobTitle) {
		return new SuccessResult(Message.jobTitleDeleted);
	}

	@Override
	public Result update(JobTitle jobTitle) {
		return new SuccessResult(Message.jobTitleUpdated);
	}

	@Override
	public DataResult<JobTitle> getByTitle(String title) {
		return new SuccessDataResult<JobTitle>(this.jobTitleDao.findByTitleIs(title));
	}
	
	public boolean checkJobTitleAlreadyInsert(JobTitle jobTitle) {
		if(this.jobTitleDao.findByTitleIs(jobTitle.getTitle()) == null) {
			return true;
		}
		return false;
	}

}
