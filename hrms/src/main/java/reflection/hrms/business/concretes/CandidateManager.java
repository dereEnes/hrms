package reflection.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reflection.hrms.business.abstracts.CandidateService;
import reflection.hrms.business.abstracts.UserService;
import reflection.hrms.business.constants.Message;
import reflection.hrms.core.utilities.adapters.MernisServiceAdapter;
import reflection.hrms.core.utilities.results.*;
import reflection.hrms.dataAccess.abstracts.CandidateDao;
import reflection.hrms.entities.concretes.Candidate;
import reflection.hrms.entities.concretes.User;
import reflection.hrms.entities.concretes.dtos.RegisterCandidateDto;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private UserService userService;
	private MernisServiceAdapter mernisServiceAdapter;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,UserService userService, MernisServiceAdapter mernisServiceAdapter) {
		super();
		this.candidateDao = candidateDao;
		this.userService = userService;
		this.mernisServiceAdapter = mernisServiceAdapter;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),Message.candidatesListed);
	}

	@Override
	public Result add(RegisterCandidateDto CandidateDto) {
		
		if(checkForNull(CandidateDto).isSuccess() == false) {
			return new ErrorResult();
		}
		
		addUser(CandidateDto);
		Candidate candidate = new Candidate(
				this.userService.getUserByEmail(CandidateDto.getEmail()).getData().getId(),
				CandidateDto.getFirstName(),
				CandidateDto.getLastName(),
				CandidateDto.getNationalIdentity(),
				CandidateDto.getDateOfBirth(),
				false);
		
		boolean isUserReal = this.mernisServiceAdapter.validate(candidate.getFirstName(), candidate.getLastName(), candidate.getNationalIdentity());
		if(isUserReal == false) {
			return new ErrorResult(Message.userIsNotValid);
		}
		
		Candidate deneme = this.candidateDao.findByNationalIdentityIs(candidate.getNationalIdentity());
		if(deneme == null) {
			return new ErrorResult(Message.nationalIdentityAlreadyExist);
		}
		
		if(this.userService.getUserByEmail(CandidateDto.getEmail()).isSuccess() == false) {
			return new ErrorResult(Message.emailAddresAlreadyUsed);
		}
		
		this.candidateDao.save(candidate);
		return new SuccessResult(Message.candidateAdded);
		
	}
	public void addUser(RegisterCandidateDto CandidateDto) {
		
		User user = new User(0,CandidateDto.getEmail(),CandidateDto.getPassword());
		this.userService.add(user);
	}
	
	public Result checkForNull(RegisterCandidateDto candidateDto) {
		if(candidateDto.getEmail() == null || 
				candidateDto.getFirstName() == null || 
				candidateDto.getLastName() == null ||
				candidateDto.getPassword() == null ||
				candidateDto.getPasswordRepeat() == null ||
				candidateDto.getDateOfBirth() == null ||
				candidateDto.getNationalIdentity() == null 
				) {
			return new ErrorResult(Message.nullField);
		}
		return new SuccessResult();
	}
	
	

}
