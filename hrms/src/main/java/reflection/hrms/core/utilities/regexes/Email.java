package reflection.hrms.core.utilities.regexes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

	public static boolean isEmailCorrect(String webSite, String email) {
		
		int start = email.indexOf("@");
		Pattern pattern = Pattern.compile(email.substring(start+1));
		Matcher matcher = pattern.matcher(webSite);
		return matcher.find();

	}
}
