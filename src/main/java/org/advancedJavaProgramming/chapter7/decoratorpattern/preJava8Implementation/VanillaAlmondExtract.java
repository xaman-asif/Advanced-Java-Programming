package org.advancedJavaProgramming.chapter7.decoratorpattern.preJava8Implementation;

import org.advancedJavaProgramming.chapter7.decoratorpattern.Coffee;

public class VanillaAlmondExtract extends CoffeeDecorator {

  public VanillaAlmondExtract(Coffee coffee) {
    super(coffee);
  }

  @Override
  public String getIngredient() {
    return super.getIngredient() + " + Vanilla/almond extract";
  }
}
