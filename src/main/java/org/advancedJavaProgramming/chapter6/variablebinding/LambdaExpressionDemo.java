package org.advancedJavaProgramming.chapter6.variablebinding;

import org.advancedJavaProgramming.chapter3.methodreference.Calculator;

public class LambdaExpressionDemo {
  public static void main(String[] args) {
    Calculator calculator = new Calculator();

    double PI = Math.PI;
    double degree = 90.0;
    double radians = calculator.calculate(degree, a -> a * PI / 180);
  }
}
