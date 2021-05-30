package reflection.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import reflection.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{

	User findByEmailIs(String email);
}
