package org.advancedJavaProgramming.chapter7.fluentprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Sandwich {
  private final List<String> vegetables = new ArrayList<>();
  private String bread;
  private String meat;
  private String cheese;

  private Sandwich() {

  }

  public static Sandwich make(Consumer<Sandwich> sandwichConsumer) {
    System.out.println("Making a sandwich");

    Sandwich sandwich = new Sandwich();
    sandwichConsumer.accept(sandwich); //this does operation on the sandwich variable declared above

    return sandwich;
  }

  public Sandwich make() {
    System.out.println("Making a sandwich");
    return this;
  }

  public Sandwich setBread(String bread) {
    this.bread = bread;
    return this;
  }

  public Sandwich setMeat(String meat) {
    this.meat = meat;
    return this;
  }

  public Sandwich setCheese(String cheese) {
    this.cheese = cheese;
    return this;
  }

  public Sandwich addVegetables(String vegetable) {
    this.vegetables.add(vegetable);
    return this;
  }
}
