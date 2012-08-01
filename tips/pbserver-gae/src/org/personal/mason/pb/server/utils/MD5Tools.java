package org.personal.mason.pb.server.utils;

import org.apache.commons.codec.digest.DigestUtils;


public class MD5Tools {

public static String secretPassword(String password){
	return DigestUtils.md5Hex(password);
}

}
