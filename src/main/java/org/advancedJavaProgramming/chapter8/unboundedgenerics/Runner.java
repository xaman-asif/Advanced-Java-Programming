package org.advancedJavaProgramming.chapter8.unboundedgenerics;

import java.time.LocalDate;
import java.util.List;

public class Runner {
  public static void process(List<?> list) {
    System.out.println(list);
  }

  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);

    List<Double> doubles = List.of(3.4, 4.6, 7.5);

    process(numbers);

    process(doubles);

    List<?> list = List.of("this", "is", "a", LocalDate.now());

//    list.add("something") we can't do this if we declear like that

    for (Object o : list) {
      System.out.println(o);
    }

    int size = list.size();
    list.forEach(o -> {
      
    });
  }
}
