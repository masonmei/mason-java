package org.personal.mason.pb.server.dao;

import java.util.HashMap;
import java.util.Map;

import org.personal.mason.pb.server.domain.BaseEntity;

public class DAOFactory {
private static Map<Class<?>, IDAO<?>> daoMap = new HashMap<Class<?>, IDAO<?>>();
private static Object LOCKER = new Object();

@SuppressWarnings("unchecked")
public static <T extends BaseEntity> IDAO<T> getDAO(Class<T> clz) {
	IDAO<?> idao = daoMap.get(clz);
	if (idao == null) {
		synchronized (LOCKER) {
			idao = new DAO<T>();
			daoMap.put(clz, idao);
		}
	}
	return (IDAO<T>) idao;
}
}
