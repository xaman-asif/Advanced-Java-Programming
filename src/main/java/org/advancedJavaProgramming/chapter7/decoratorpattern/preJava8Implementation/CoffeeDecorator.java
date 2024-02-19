package org.advancedJavaProgramming.chapter7.decoratorpattern.preJava8Implementation;

import org.advancedJavaProgramming.chapter7.decoratorpattern.Coffee;

//Decorator Class
public abstract class CoffeeDecorator implements Coffee {
  private final Coffee coffee;

  public CoffeeDecorator(Coffee coffee) {
    this.coffee = coffee;
  }

  @Override
  public String getIngredient() {
    return coffee.getIngredient();
  }
}
