package org.personal.mason.restful.rest.util;

import java.util.UUID;

import org.personal.mason.restful.domain.Account;

public class TokenGenerator {

	public static synchronized String generateToken(Account account) {
	    return UUID.randomUUID().toString();
    }

	public static void main(String[] args) {
	    String generateToken = TokenGenerator.generateToken(new Account());
	    System.out.println(generateToken);
    }
}
