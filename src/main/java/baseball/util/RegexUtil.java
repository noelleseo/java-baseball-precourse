package baseball.util;

import java.util.regex.Pattern;

public class RegexUtil {
	public boolean match(String regex, String str) {
		Pattern p = Pattern.compile(regex);
		return p.matches(regex, str);
	}
}
