package org.advancedJavaProgramming.chapter8.upperboundedwildcard;

import java.util.List;

public class Runner {
  public static double sumAll(List<? extends Number> numbers) {
    double sum = 0;

    for (Number number : numbers) {
      sum += number.doubleValue();
    }

    return sum;
  }

  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);

    List<Double> doubles = List.of(3.4, 4.6, 7.5);

    sumAll(numbers);
    sumAll(doubles);
  }
}
