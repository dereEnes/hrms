package reflection.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reflection.hrms.business.abstracts.EmployerService;
import reflection.hrms.business.abstracts.UserService;
import reflection.hrms.business.constants.Message;
import reflection.hrms.core.utilities.regexes.Email;
import reflection.hrms.core.utilities.results.DataResult;
import reflection.hrms.core.utilities.results.ErrorResult;
import reflection.hrms.core.utilities.results.Result;
import reflection.hrms.core.utilities.results.SuccessDataResult;
import reflection.hrms.core.utilities.results.SuccessResult;
import reflection.hrms.dataAccess.abstracts.EmployerDao;
import reflection.hrms.dataAccess.abstracts.UserDao;
import reflection.hrms.entities.concretes.Employer;
import reflection.hrms.entities.concretes.User;
import reflection.hrms.entities.concretes.dtos.RegisterEmployerDto;

@Service
public class EmployerManager implements EmployerService{

	private UserService userService;
	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(UserService userService, EmployerDao employerDao) {
		super();
		this.userService = userService;
		this.employerDao = employerDao;
	}

	@Override
	public Result add(RegisterEmployerDto employerDto) {
		
		if(!employerDto.getPassword().equals(employerDto.getPasswordRepeat())) {
			return new ErrorResult(Message.passwordsAreNotSame);
		}
		
		if(!checkForNullValue(employerDto)) {
			return new ErrorResult(Message.nullField);
		}
		
		if(this.userService.getUserByEmail(employerDto.getEmail()).getData() != null) {
			return new ErrorResult(Message.emailAddresAlreadyUsed);
		}
		
		if(Email.isEmailCorrect(employerDto.getWebSite(), employerDto.getEmail()) != true) {
			return new ErrorResult(Message.emailDomainError);
		}
		
		User user = new User(0, employerDto.getEmail(), employerDto.getPassword());
		this.userService.add(user);
		
		int id = this.userService.getUserByEmail(user.getEmail()).getData().getId();
		Employer employer = new Employer(id, employerDto.getCompanyName(), employerDto.getWebSite(), employerDto.getPhoneNumber(), false, false);
		this.employerDao.save(employer);
		
		
		return new SuccessResult(Message.employerAdded);
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

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),Message.employersListed);
	}

	@Override
	public DataResult<Employer> getById(int id) {
		return new SuccessDataResult<Employer>(this.employerDao.getOne(id));
	}
	
	
}

