package org.personal.mason.pb.server.service.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.personal.mason.pb.server.service.IAccountManager;
import org.personal.mason.pb.server.service.IRelationManager;
import org.personal.mason.pb.server.service.IServiceProxy;

public class ServiceProxy implements IServiceProxy {

private IAccountManager mProxiedAccountManager;
private IRelationManager mProxiedRelationManager;

private Object AMLOCKER = new Object();
private Object RMLOCKER = new Object();

@Override
public IAccountManager getProxiedAccountManager() {
	if (mProxiedAccountManager == null) {
		synchronized (AMLOCKER) {
			if (mProxiedAccountManager == null) {
				IAccountManager manager = new AccountManager();
				TransactionHandler handler = new TransactionHandler(manager);
				mProxiedAccountManager = (IAccountManager) Proxy
				        .newProxyInstance(manager.getClass().getClassLoader(), manager.getClass().getInterfaces(), handler);
			}
		}
	}
	return mProxiedAccountManager;
}

@Override
public IRelationManager getProxiedRelationManager() {
	if (mProxiedRelationManager == null) {
		synchronized (RMLOCKER) {
			if (mProxiedRelationManager == null) {
				IRelationManager manager = new RelationManager();
				TransactionHandler handler = new TransactionHandler(manager);
				mProxiedRelationManager = (IRelationManager) Proxy
				        .newProxyInstance(manager.getClass().getClassLoader(), manager.getClass().getInterfaces(), handler);
			}
		}
	}
	return mProxiedRelationManager;
}

private Object mProxiedService;
private InvocationHandler handler;
private Object TLOCKER = new Object();

@SuppressWarnings("unchecked")
@Override
public <T> T getProxiedService(T instance) {
	if (mProxiedService == null) {
		synchronized (TLOCKER) {
			if (mProxiedService == null) {
				mProxiedService = Proxy.newProxyInstance(instance.getClass().getClassLoader(), instance.getClass().getInterfaces(), handler);
			}
		}
	}
	return (T) mProxiedService;
}

public InvocationHandler getHandler() {
	return handler;
}

public void setHandler(InvocationHandler handler) {
	this.handler = handler;
}

}
