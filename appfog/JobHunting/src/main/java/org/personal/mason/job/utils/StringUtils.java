package org.personal.mason.job.utils;

import java.util.Random;

public class StringUtils {

private static final Random RANDOM = new Random();

public static String getValidationCode() {
	return "1234567890qazwsxedcrfvtgbyhnujmikolpQWERTYUIOPASDFGHJKKLZXCVBNM";
}

public static String getRandomString(int length) {
	String source = getValidationCode();
	StringBuilder builder = new StringBuilder();
	for (int i = 0; i < length; i++) {
		builder.append(source.charAt(RANDOM.nextInt(source.length())));
	}
	return builder.toString();
}
}
