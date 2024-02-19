package org.advancedJavaProgramming.chapter7.decoratorpattern.preJava8Implementation;

import org.advancedJavaProgramming.chapter7.decoratorpattern.Coffee;

public class SaltedCaramelFudge extends CoffeeDecorator {
  public SaltedCaramelFudge(Coffee coffee) {
    super(coffee);
  }

  @Override
  public String getIngredient() {
    return super.getIngredient() + " + Salted caramel fudge";
  }
}
