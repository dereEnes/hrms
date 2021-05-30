package reflection.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reflection.hrms.business.abstracts.UserService;
import reflection.hrms.business.constants.Message;
import reflection.hrms.core.utilities.results.DataResult;
import reflection.hrms.core.utilities.results.Result;
import reflection.hrms.core.utilities.results.SuccessDataResult;
import reflection.hrms.core.utilities.results.SuccessResult;
import reflection.hrms.dataAccess.abstracts.UserDao;
import reflection.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult(Message.userAdded);
		
	}

	@Override
	public DataResult<User> getUserByEmail(String email) {
		User user = this.userDao.findByEmailIs(email);
		return new SuccessDataResult<User>(user);
	}

}
