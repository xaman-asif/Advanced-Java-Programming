package chapter3.instancemethodreference;

import java.util.function.Function;

public class MethodRefDemo {
  public static void checker(String str, Function<String, Boolean> func) {
    Boolean ret = func.apply(str);
    System.out.println(ret);
  }

  public static void main(String[] args) {
    String hello = "hello$world";
    StringUtils utils = new StringUtils();

    checker(hello, utils::isNotEmpty);
    checker(hello, utils::isEmpty);
    checker(hello, utils::hasSpecialCharacter);
  }
}
