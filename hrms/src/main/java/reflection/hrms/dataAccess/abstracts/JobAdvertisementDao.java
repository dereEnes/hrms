package reflection.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import reflection.hrms.core.utilities.results.DataResult;
import reflection.hrms.entities.concretes.JobAdvertisement;
import reflection.hrms.entities.concretes.dtos.JobAdvertsSmall;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	List<JobAdvertsSmall> getByIsActiveIsTrue(Pageable pageable);
	List<JobAdvertsSmall> getByIsActiveIsTrueAndEmployerIdIs(int id, Pageable pageable);
	List<JobAdvertsSmall> getByIsActiveIsTrue(Pageable pageable,Sort sort);
}
