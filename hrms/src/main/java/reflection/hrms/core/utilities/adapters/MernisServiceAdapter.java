package reflection.hrms.core.utilities.adapters;

import org.springframework.stereotype.Service;

import reflection.hrms.mernis.MernisService;

@Service
public class MernisServiceAdapter implements UserValidationService{

	@Override
	public boolean validate(String firstName, String lastName, String nationalIdentity) {
		
		MernisService mernis = new MernisService();
		return mernis.ValidatePerson(firstName, lastName, nationalIdentity);
	}

}
