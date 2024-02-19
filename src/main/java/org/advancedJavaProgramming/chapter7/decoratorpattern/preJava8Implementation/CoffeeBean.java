package org.advancedJavaProgramming.chapter7.decoratorpattern.preJava8Implementation;

import org.advancedJavaProgramming.chapter7.decoratorpattern.Coffee;

//Concrete Class
public class CoffeeBean implements Coffee {
  @Override
  public String getIngredient() {
    return "Coffee bean";
  }
}
