package org.advancedJavaProgramming.chapter8.lowerboundwildcard;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Runner {
  public static void main(String[] args) {

    List<? super BigInteger> bigIntegers = new ArrayList<>();

    bigIntegers.add(BigInteger.ONE);
    bigIntegers.add(BigInteger.TWO);
    bigIntegers.add(BigInteger.TEN);

    List<Integer> integers = List.of(1, 2, 3, 4);

    integers.forEach(new Consumer<Integer>() {
      @Override
      public void accept(Integer integer) {
        System.out.println(integer);
      }
    });
  }
}
