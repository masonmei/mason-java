package org.personal.mason.designpattern.creational.builder;
public abstract class PizzaBuilder {
protected Pizza pizza;
public Pizza getPizza() {
	return pizza;
}
public void createNewPizzaProduct() {
	pizza = new Pizza();
}
public abstract void buildDough();
public abstract void buildSauce();
public abstract void buildTopping();
}

class Pizza {
private String dough = "";
private String sauce = "";
private String topping = "";
public void setDough(String dough)     { this.dough = dough; }
public void setSauce(String sauce)     { this.sauce = sauce; }
public void setTopping(String topping) { this.topping = topping; }
}

class HawaiianPizzaBuilder extends PizzaBuilder {
public void buildDough()   { pizza.setDough("cross"); }
public void buildSauce()   { pizza.setSauce("mild"); }
public void buildTopping() { pizza.setTopping("ham+pineapple"); }
}

class Waiter {
private PizzaBuilder pizzaBuilder;
public void setPizzaBuilder(PizzaBuilder pb) { pizzaBuilder = pb; }
public Pizza getPizza() { return pizzaBuilder.getPizza(); }
public void constructPizza() {
  pizzaBuilder.createNewPizzaProduct();
  pizzaBuilder.buildDough();
  pizzaBuilder.buildSauce();
  pizzaBuilder.buildTopping();
}
}

class Main{
public static void main(String[] args) {
	Waiter waiter = new Waiter();
	HawaiianPizzaBuilder builder = new HawaiianPizzaBuilder();//always provide by factory method
	waiter.setPizzaBuilder(builder);
	waiter.constructPizza();
	Pizza pizza = waiter.getPizza();
	System.out.println(pizza);
}
}