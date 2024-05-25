package org.advancedJavaProgramming.chapter8.generictype;

import java.util.Objects;
import java.util.function.IntFunction;

public class Runner {

  public static void main(String[] args) {
    Holder<String> stringHolder = new Holder<>();
    stringHolder.setObject("Hello World");

    Holder<Integer> integerHolder = new Holder<>();
    integerHolder.setObject(4);

    Integer holderObject = integerHolder.getObject();
    Integer sum = holderObject + 5;
  }

  public static <T> void setAll(T[] array, IntFunction<? extends T> generator) {
    Objects.requireNonNull(generator);

    for (int i = 0; i < array.length; i++) {
      array[i] = generator.apply(i);
    }
  }


}
