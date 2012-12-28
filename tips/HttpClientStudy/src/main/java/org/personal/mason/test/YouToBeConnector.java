package org.personal.mason.test;

import java.io.IOException;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.Arrays;

import org.apache.commons.io.IOUtils;

public class YouToBeConnector {

public static void main(String[] args) throws IOException {
	
//	String tmp = "this is a test";
	
//	byte[] ba = new byte[1000];
	
//	Arrays.copy
	
	
	String urlString = "http://innovate.prod.quest.corp";
//
//
//
//	String proxyHost = "10.30.178.59";
//	int proxyPort = 80;
//
//	InetSocketAddress inetsa = new InetSocketAddress(proxyHost, proxyPort);
//	Proxy proxy = new Proxy(Type.HTTP, inetsa);
//
	URL url = new URL(urlString);
//
	Authenticator.setDefault(new MyAuthenticator());
//
	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	
	conn.connect();
	int responseCode = conn.getResponseCode();
	System.out.println(responseCode);
	
	System.out.println(IOUtils.toString(conn.getInputStream()));
	System.out.println(IOUtils.toString(conn.getErrorStream()));
}

}

class MyAuthenticator extends Authenticator {
private int count = 1;
private int count2 = 1;
@Override
protected PasswordAuthentication getPasswordAuthentication() {
	if (getRequestorType() == RequestorType.PROXY) {
		String proxyUser = "";
		if(count2 < 9){
			proxyUser = "paul" + count2++;
		}else{
			proxyUser = "paul";
		}
		
		return new PasswordAuthentication(proxyUser, "123456".toCharArray());
//		return null;
	} else {
//		if(count < 9){
//			
//			return new PasswordAuthentication("paul" + count++, "123456".toCharArray());
//		}
		return new PasswordAuthentication("prod\\mmei", "2year@quest".toCharArray());
	}
}
}