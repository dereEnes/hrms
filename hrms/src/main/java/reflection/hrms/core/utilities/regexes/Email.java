package reflection.hrms.core.utilities.regexes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

	public static boolean isEmailCorrect(String webSite, String email) {
		int start = webSite.indexOf("@");
		Pattern pattern = Pattern.compile(webSite.substring(start));
		Matcher matcher = pattern.matcher(email);
		return matcher.find();
	}
}
