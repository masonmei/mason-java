package org.personal.mason.utils;

import java.util.UUID;

public class TokenGenerator {

	public static synchronized String generateToken() {
	    return UUID.randomUUID().toString();
    }

	public static void main(String[] args) {
	    String generateToken = TokenGenerator.generateToken();
	    System.out.println(generateToken);
    }
}
