package reflection.hrms.business.abstracts;

import java.util.List;

import reflection.hrms.core.utilities.results.DataResult;
import reflection.hrms.core.utilities.results.Result;
import reflection.hrms.entities.concretes.Employer;
import reflection.hrms.entities.concretes.dtos.RegisterEmployerDto;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
	Result add(RegisterEmployerDto employerDto);
}
