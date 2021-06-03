package reflection.hrms.business.abstracts;

import java.util.List;

import reflection.hrms.core.utilities.results.DataResult;
import reflection.hrms.core.utilities.results.Result;
import reflection.hrms.entities.concretes.JobAdvertisement;
import reflection.hrms.entities.concretes.dtos.JobAdvertisementDto;
import reflection.hrms.entities.concretes.dtos.JobAdvertsSmall;

public interface JobAdversisementService {

	Result add(JobAdvertisementDto advertisementDto);
	Result update(JobAdvertisement advertisement);
	Result delete(JobAdvertisement advertisement);
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertsSmall>> getByIsActiveIsTrue(int page, int size);
	DataResult<List<JobAdvertsSmall>> getByEmployerIdIs(int id, int page, int size);
	DataResult<List<JobAdvertsSmall>> getByIsActiveTrueAndAsc(int page, int size);
	Result disableAdvertisement(int id);
}
