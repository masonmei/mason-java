package org.personal.mason.pb.server.service.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.logging.Level;

import org.personal.mason.pb.server.conf.EntityManagerHelper;

public class TransactionHandler implements InvocationHandler {

protected Object delegate;

public TransactionHandler(Object delegate) {
	super();
	this.delegate = delegate;
}

@Override
public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	EntityManagerHelper.log("calling method " + method + " begin", Level.INFO, null);
	Object result = null;
	try {
		EntityManagerHelper.beginTransaction();
		result = method.invoke(delegate, args);
		EntityManagerHelper.commit();
	} catch (Exception e) {
		EntityManagerHelper.rollback();
		EntityManagerHelper.log("exception occurred while calling method" + method + ".", Level.INFO, e);
	}
	EntityManagerHelper.log("calling method " + method + " end", Level.INFO, null);
	return result;
}

}
