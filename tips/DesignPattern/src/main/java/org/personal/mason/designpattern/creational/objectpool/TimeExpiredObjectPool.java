package org.personal.mason.designpattern.creational.objectpool;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
public class TimeExpiredObjectPool<T> extends AbstractPool<T> {
private final int minPoolSize;
private final long maxAge;
private final AtomicLong lastCreate = new AtomicLong();
public TimeExpiredObjectPool(int minSize, long maxAge) {
	super();
	this.minPoolSize = minSize;
	this.maxAge = maxAge;
	for(int i=0 ; i < minPoolSize; i++) {
		getPool().add(getNewPoolObject());
	}
}
public final T acquire() {
	T pooled = getPool().poll();
	if(pooled == null) {
		// pool is empty so create a new object
		pooled = getNewPoolObject();
	}
	return pooled;
}
public final void release(T pooled) {
	if(!validate(pooled)) {
		return;
	}
	if(getPool().size() < minPoolSize || (System.currentTimeMillis() - lastCreate.get()) < maxAge) {
		super.release(pooled);
	}
}
private T getNewPoolObject() {
	final T pooled = create();
	lastCreate.set(System.currentTimeMillis());
	return pooled;
}
@Override
public T create() {
	//build the T instance.
	return null;
}
}

abstract class AbstractPool<T> implements Pool<T> {
private final Queue<T> mPool;
public AbstractPool() {
	mPool = new ConcurrentLinkedQueue<T>();
}
public abstract T create();
boolean validate(T t) {
	return t != null;
}
public T acquire() {
	T pooled = mPool.poll();
	if(pooled == null) {
		pooled = create();
	}
	return pooled;
}
public void release(T t) {
	if(validate(t)) {
		mPool.offer(t);
	}
}
protected final Queue<T> getPool() {
	return mPool;
}
}

interface Pool<T> {
T acquire();
void release(T t);
}