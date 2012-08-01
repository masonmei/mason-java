package org.personal.mason.pb.server.service;

public interface IServiceProxy{
public IAccountManager getProxiedAccountManager();

public IRelationManager getProxiedRelationManager();

public <T> T getProxiedService(T instance);
}
