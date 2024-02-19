package org.advancedJavaProgramming.chapter7.decoratorpattern.preJava8Implementation;

import org.advancedJavaProgramming.chapter7.decoratorpattern.Coffee;

public class DarkCookieCrumb extends CoffeeDecorator {
  public DarkCookieCrumb(Coffee coffee) {
    super(coffee);
  }

  @Override
  public String getIngredient() {
    return super.getIngredient() + " + Dark Cookie Crumb";
  }
}
