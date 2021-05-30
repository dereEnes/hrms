package reflection.hrms.business.abstracts;

import reflection.hrms.core.utilities.results.Result;
import reflection.hrms.entities.concretes.dtos.RegisterEmployerDto;

public interface EmployerService {

	Result add(RegisterEmployerDto employerDto);
}
