package org.advancedJavaProgramming.chapter7.decoratorpattern.preJava8Implementation;

import org.advancedJavaProgramming.chapter7.decoratorpattern.Coffee;

public class SweetenedMilk extends CoffeeDecorator {

  public SweetenedMilk(Coffee coffee) {
    super(coffee);
  }

  @Override
  public String getIngredient() {
    return super.getIngredient() + " + Sweetened Milk";
  }
}
