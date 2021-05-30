package reflection.hrms.business.abstracts;

import java.util.List;

import reflection.hrms.core.utilities.results.DataResult;
import reflection.hrms.core.utilities.results.Result;
import reflection.hrms.entities.concretes.Candidate;
import reflection.hrms.entities.concretes.dtos.RegisterCandidateDto;


public interface CandidateService {

	DataResult<List<Candidate>> getAll();
	Result add(RegisterCandidateDto candidateDto);
}
