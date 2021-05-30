package reflection.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import reflection.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{

	Candidate findByNationalIdentityIs(String nationalIdentity);
}
