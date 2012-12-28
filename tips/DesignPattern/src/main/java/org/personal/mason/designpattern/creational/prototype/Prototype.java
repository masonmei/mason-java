package org.personal.mason.designpattern.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public abstract class Prototype {
abstract Prototype clonePrototype();
String getIdentifier(){
	return getClass().getSimpleName();
}
}

class Prototype1 extends Prototype {
protected Prototype1() {
}
public Prototype clonePrototype() {
	return new Prototype1();
}
}

class Prototype2 extends Prototype {
protected Prototype2() {
}
public Prototype clonePrototype() {
	return new Prototype2();
}
}

class PrototypeFactory{

private static Map<String, Prototype> prototypes = new HashMap<String, Prototype>();
static {
	Prototype1 prototype1 = new Prototype1();
	prototypes.put(prototype1.getIdentifier(), prototype1);
	Prototype2 prototype2 = new Prototype2();
	prototypes.put(prototype2.getIdentifier(), prototype2);
}
public static Prototype makePrototype(String identified){
	return prototypes.get(identified).clonePrototype();
}
}