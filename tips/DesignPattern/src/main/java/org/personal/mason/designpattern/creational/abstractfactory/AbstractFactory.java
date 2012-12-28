package org.personal.mason.designpattern.creational.abstractfactory;
public class AbstractFactory {
public static void main(String[] args) {
	AFactory af = FactoryMaker.getFactory("a");
	AbstractProductA pa = af.createProductA();
	System.out.println(pa);
}
}

abstract class AbstractProductA{
public abstract void operationA1();
public abstract void operationA2();
}

abstract class AbstractProductB{
public abstract void operationB1();
public abstract void operationB2();
}

class ProductA1 extends AbstractProductA{
ProductA1(String arg){
	System.out.println("Hello "+arg);
}
public void operationA1() { };
public void operationA2() { };
}

class ProductA2 extends AbstractProductA{
ProductA2(String arg){
	System.out.println("Hello "+arg);
}
public void operationA1() { };
public void operationA2() { };
}

class ProductB1 extends AbstractProductB{
ProductB1(String arg){
	System.out.println("Hello "+arg);
}
public void operationB1() { };
public void operationB2() { };
}

class ProductB2 extends AbstractProductB{
ProductB2(String arg){
	System.out.println("Hello "+arg);
}
public void operationB1() { };
public void operationB2() { };
}

abstract class AFactory {
abstract AbstractProductA createProductA();
abstract AbstractProductB createProductB();
}

class ConcreteFactory1 extends AFactory{
AbstractProductA createProductA(){
	return new ProductA1("ProductA1");
}
AbstractProductB createProductB(){
	return new ProductB1("ProductB1");
}
}

class ConcreteFactory2 extends AFactory{
AbstractProductA createProductA(){
	return new ProductA2("ProductA2");
}
AbstractProductB createProductB(){
	return new ProductB2("ProductB2");
}
}

class FactoryMaker{
private static AFactory pf=null;
static AFactory getFactory(String choice){
	if(choice.equals("a")){
		pf=new ConcreteFactory1();
	}else if(choice.equals("b")){
		pf=new ConcreteFactory2();
	} return pf;
}
}
