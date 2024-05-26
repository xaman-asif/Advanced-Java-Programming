package org.advancedJavaProgramming.chapter8.genericinheritancesubtyping;

import java.math.BigInteger;
import java.util.List;
import org.advancedJavaProgramming.chapter8.generictype.Holder;

public class Runner {
  public static void main(String[] args) {
    Object someObject = new Object();

    Integer someInteger = Integer.valueOf(10);

    someObject = someInteger;

    Holder<Number> numberHolder = new Holder<>();

    numberHolder.setObject(BigInteger.ONE);

    numberHolder.setObject(5);

    Holder<Holder<Number>> holderHolder = new Holder<>();
    holderHolder.setObject(numberHolder);

    Holder<Integer> integerHolder = new Holder<>();

    //holderHolder.setObject(integerHolder);
    // This operation is not possible because even though integer is a subtype of number but Holder<Integer> is not a
    // subtype of Holder<Number>

    List<String> lists = List.of("Hello World");

    List<Object> objects = List.of(new Object());
  }
}
