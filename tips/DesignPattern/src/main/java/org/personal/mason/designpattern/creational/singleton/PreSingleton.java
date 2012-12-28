package org.personal.mason.designpattern.creational.singleton;

public class PreSingleton {
private static final PreSingleton instance = new PreSingleton();

private PreSingleton() {
}

public static PreSingleton getInstance() {
	return instance;
}
}
