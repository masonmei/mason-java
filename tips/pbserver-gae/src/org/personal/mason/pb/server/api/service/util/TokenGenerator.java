package org.personal.mason.pb.server.api.service.util;

import java.util.UUID;

import org.personal.mason.pb.server.api.model.PBAccount;

public class TokenGenerator {

	public static synchronized String generateToken(PBAccount account) {
	    return UUID.randomUUID().toString();
    }

	public static void main(String[] args) {
	    String generateToken = TokenGenerator.generateToken(new PBAccount());
	    System.out.println(generateToken);
    }
}
