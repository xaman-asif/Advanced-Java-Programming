package chapter3.methodreference;

import java.util.function.Function;

public class Calculator {
  public double calculate(Double a, Function<Double, Double> func) {
    return func.apply(a);
  }

  public static void main(String[] args) {
    Calculator calculator = new Calculator();

    calculator.calculate(90.0, Math::sin);
    calculator.calculate(90.0, Math::cos);
    calculator.calculate(90.0, Math::exp);
  }
}
