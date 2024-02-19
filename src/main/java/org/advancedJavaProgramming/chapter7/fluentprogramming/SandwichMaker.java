package org.advancedJavaProgramming.chapter7.fluentprogramming;

public class SandwichMaker {
  public static void main(String[] args) {

//    Sandwich sandwich = new Sandwich()
//        .setBread("White")
//        .setCheese("Cheddar")
//        .addVegetables("Tomato")
//        .addVegetables("Cucumber")
//        .make();

    Sandwich.make(sandwich ->
        sandwich.setBread("White")
            .setMeat("Beef")
            .setCheese("Cheddar")
            .addVegetables("Tomato")
            .addVegetables("Cucumber"));

    //Human.eat(sandwich);
  }
}
