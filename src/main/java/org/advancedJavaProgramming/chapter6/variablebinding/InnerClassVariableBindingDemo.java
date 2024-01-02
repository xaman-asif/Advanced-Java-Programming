package org.advancedJavaProgramming.chapter6.variablebinding;

import java.util.function.Function;
import org.advancedJavaProgramming.chapter3.methodreference.Calculator;

public class InnerClassVariableBindingDemo {
  public static void main(String[] args) {
    Calculator calculator = new Calculator();

    final double PI = Math.PI;
    double degree = 90.0;

    double radians = calculator.calculate(degree, new Function<Double, Double>() {
      @Override
      public Double apply(Double a) {
        return a * PI / 180;
      }
    });
  }
}
