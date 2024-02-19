package org.advancedJavaProgramming.chapter7.decoratorpattern;

//Coffee Interface
public interface Coffee {
  static Coffee withSaltedCaramelFudge(Coffee coffee) {
    return () -> coffee.getIngredient() + " + Salted caramel fudge";
  }

  static Coffee withSweetenedMilk(Coffee coffee) {
    return () -> coffee.getIngredient() + " + Sweetened Milk";
  }

  static Coffee withDarkCookieCrumb(Coffee coffee) {
    return () -> coffee.getIngredient() + " + Dark Cookie Crumb";
  }

  static Coffee withVanillAlmondExtract(Coffee coffee) {
    return () -> coffee.getIngredient() + " + Vanilla/almond extract";
  }

  String getIngredient();
}
