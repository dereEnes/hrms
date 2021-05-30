package reflection.hrms.core.utilities.verifications;

public class EmailVerification implements VerificationService{

	@Override
	public void sendCode(String address) {
		System.out.println("Mail adresine doğrulama kodu gönderildi");
		
	}

}
