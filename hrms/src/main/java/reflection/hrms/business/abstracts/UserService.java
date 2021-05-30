package reflection.hrms.business.abstracts;

import reflection.hrms.core.utilities.results.DataResult;
import reflection.hrms.core.utilities.results.Result;
import reflection.hrms.entities.concretes.User;


public interface UserService {

	Result add(User user);
	DataResult<User> getUserByEmail(String email);
}
