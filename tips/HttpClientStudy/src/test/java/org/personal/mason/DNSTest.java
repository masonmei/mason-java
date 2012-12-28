package org.personal.mason;

import org.xbill.DNS.Lookup;
import org.xbill.DNS.Resolver;
import org.xbill.DNS.SimpleResolver;

public class DNSTest {
public static void main(String[] args) {
	String hostName = "www.baidu.com";
	Lookup lookup = null;
	try {
		lookup = new Lookup(hostName);
	    Resolver resolver = new SimpleResolver();
	    resolver.setTimeout(5);
	    lookup.setResolver(resolver);
	    lookup.setCache(null);
	    long startTime = System.nanoTime();
	    lookup.run();
	    double estimatedTime = System.nanoTime() - startTime;
		double time = 0d;
		if(estimatedTime > 0){
			time = estimatedTime/1000000;
		}
	    if(lookup != null && lookup.getResult() == Lookup.SUCCESSFUL){
//	    	urlTopology.setDnsLookUpTime(time);
	    	System.out.println(time);
	    }
	} catch (Exception e) {
	}
	
}
}
