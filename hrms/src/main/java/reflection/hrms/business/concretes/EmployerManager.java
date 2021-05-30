package reflection.hrms.business.concretes;

import reflection.hrms.business.abstracts.EmployerService;
import reflection.hrms.business.constants.Message;
import reflection.hrms.core.utilities.results.ErrorResult;
import reflection.hrms.core.utilities.results.Result;
import reflection.hrms.entities.concretes.dtos.RegisterEmployerDto;

public class EmployerManager implements EmployerService{

	@Override
	public Result add(RegisterEmployerDto employerDto) {
		
		
		if(checkForNullValue(employerDto)) {
			return new ErrorResult(Message.nullField);
		}
		
		return null;
	}
	
	public boolean checkForNullValue(RegisterEmployerDto employerDto) {
		if(employerDto.getCompanyName() == null ||
				employerDto.getEmail() == null ||
				employerDto.getPassword() == null ||
				employerDto.getPasswordRepeat() == null ||
				employerDto.getPhoneNumber() == null ||
				employerDto.getWebSite() == null 
				) {
			return false;
		}
		return true;
	}
	
	
}

