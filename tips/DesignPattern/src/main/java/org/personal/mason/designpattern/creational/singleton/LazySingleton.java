package org.personal.mason.designpattern.creational.singleton;

public class LazySingleton {
public static LazySingleton instance;

// Another instance member
private LazySingleton() {
	// instance member initialization
}

public synchronized static LazySingleton getInstance() {
	if (instance == null) {
		instance = new LazySingleton();
	}
	return instance;
}
}
