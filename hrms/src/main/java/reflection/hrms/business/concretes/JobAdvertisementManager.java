package reflection.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import reflection.hrms.business.abstracts.EmployerService;
import reflection.hrms.business.abstracts.JobAdversisementService;
import reflection.hrms.business.abstracts.JobTitleService;
import reflection.hrms.business.constants.Message;
import reflection.hrms.core.utilities.results.DataResult;
import reflection.hrms.core.utilities.results.Result;
import reflection.hrms.core.utilities.results.SuccessDataResult;
import reflection.hrms.core.utilities.results.SuccessResult;
import reflection.hrms.dataAccess.abstracts.JobAdvertisementDao;
import reflection.hrms.entities.concretes.JobAdvertisement;
import reflection.hrms.entities.concretes.JobTitle;
import reflection.hrms.entities.concretes.dtos.JobAdvertisementDto;
import reflection.hrms.entities.concretes.dtos.JobAdvertsSmall;

@Service
public class JobAdvertisementManager implements JobAdversisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	private JobTitleService jobTitleService;
	private EmployerService employerService;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, JobTitleService jobTitleService,EmployerService employerService) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.jobTitleService = jobTitleService;
		this.employerService = employerService;
	}

	@Override
	public Result add(JobAdvertisementDto advertisementDto) {
	
		//public JobAdvertisement(int id, int employerId, JobTitle jobTitle, String description, short provinceId,
			//	short maxSalary, short minSalary, short countOfPerson, Date deadline, boolean isActive, Date dateOfAdvertisement) {
		JobTitle jobTitle =  this.jobTitleService.getById(advertisementDto.getJobTitleId()).getData();
		
		JobAdvertisement advertisement = new JobAdvertisement(
				0,
				this.employerService.getById(advertisementDto.getEmployerId()).getData(),
				jobTitle,
				advertisementDto.getDescription(),
				advertisementDto.getProvinceId(),
				advertisementDto.getMaxSalary(),
				advertisementDto.getMinSalary(),
				advertisementDto.getCountOfPerson(),
				advertisementDto.getDeadline(),
				advertisementDto.isActive(),
				advertisementDto.getDateOfAdvertisement()
				);
		 this.jobAdvertisementDao.save(advertisement);
		 return new SuccessResult(Message.jobAdvertisementAdded);
	}

	@Override
	public Result update(JobAdvertisement advertisement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(JobAdvertisement advertisement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findAll(),Message.jobAdvertisementsListed);
	}

	@Override
	public DataResult<List<JobAdvertsSmall>> getByIsActiveIsTrue(int page, int size) {
		Pageable pageable = PageRequest.of(page-1, size);
		return new SuccessDataResult<List<JobAdvertsSmall>>
		(this.jobAdvertisementDao.getByIsActiveIsTrue(pageable),(page+". sayfa "));
		
	}

	@Override
	public DataResult<List<JobAdvertsSmall>> getByEmployerIdIs(int id ,int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return new SuccessDataResult<List<JobAdvertsSmall>>
		(this.jobAdvertisementDao.getByIsActiveIsTrueAndEmployerIdIs(id,pageable));
	}

	@Override
	public DataResult<List<JobAdvertsSmall>> getByIsActiveTrueAndAsc(int page, int size) {
		Sort sort =Sort.by(Sort.Direction.ASC,"date_of_advertisement");
		Pageable pageable = PageRequest.of(page-1, size);
		return new SuccessDataResult<List<JobAdvertsSmall>>
		(this.jobAdvertisementDao.getByIsActiveIsTrue(pageable,sort));
	}

	@Override
	public Result disableAdvertisement(int id) {
		JobAdvertisement advert = this.jobAdvertisementDao.getOne(id);
		advert.setActive(false);
		this.jobAdvertisementDao.save(advert);
		return new SuccessResult(Message.jobAdvertisementUpdated);
		
	}

	
}
