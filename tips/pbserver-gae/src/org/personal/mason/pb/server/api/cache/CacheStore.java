package org.personal.mason.pb.server.api.cache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;

import com.google.appengine.api.memcache.AsyncMemcacheService;
import com.google.appengine.api.memcache.ErrorHandlers;
import com.google.appengine.api.memcache.Expiration;
import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;

public class CacheStore {
	private static MemcacheService syncCache = MemcacheServiceFactory
			.getMemcacheService();
	private static AsyncMemcacheService asyncCache = MemcacheServiceFactory
			.getAsyncMemcacheService();

	static {
		syncCache.setErrorHandler(ErrorHandlers
				.getConsistentLogAndContinue(Level.INFO));
		asyncCache.setErrorHandler(ErrorHandlers
				.getConsistentLogAndContinue(Level.INFO));
	}

	@SuppressWarnings("unchecked")
	public static <T> T syncGet(Class<T> clazz, String key) {
		Object object = syncCache.get(key);
		if (object == null)
			return null;
		if (object.getClass() == clazz) {
			return (T) object;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static <T> T asyncGet(Class<T> clazz, String key) {
		Future<Object> future = asyncCache.get(key);
		Object object = null;
		try {
			object = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (object == null)
			return null;
		if (object.getClass() == clazz) {
			return (T) object;
		}
		return null;
	}

	public static void syncPut(String key, Object value) {
		syncCache.put(key, value);
	}

	public static void syncPut(String key, Object value, Integer expired) {
		syncCache.put(key, value, Expiration.byDeltaSeconds(expired));
	}

	public static void asyncPut(String key, Object value) {
		Future<Void> put = asyncCache.put(key, value);
		try {
			put.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void asyncPut(String key, Object value, Integer expired) {
		Future<Void> put = asyncCache.put(key, value, Expiration.byDeltaSeconds(expired));
		try {
			put.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void syncRemove(String key){
		syncCache.delete(key);
	}
	
	public static void asyncRemove(String key){
		asyncCache.delete(key);
	}
}
