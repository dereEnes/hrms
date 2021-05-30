package reflection.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import reflection.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{

}
