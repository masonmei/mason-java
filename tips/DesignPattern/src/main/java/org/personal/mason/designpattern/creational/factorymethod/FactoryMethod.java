package org.personal.mason.designpattern.creational.factorymethod;
public class FactoryMethod {
public static void main(String[] args) {
	Creator creator = new ConcreteCreator();
	creator.operation();
}
}

interface Product {
String prodName();
}

class ConcreteProduct implements Product {
public String prodName() {
	return getClass().getSimpleName();
}
}

abstract class Creator {
public void operation() {
	System.out.println("Do what u like!");
}

protected abstract Product factoryMethod();
}

class ConcreteCreator extends Creator {
@Override
protected Product factoryMethod() {
	return new ConcreteProduct();
}
}