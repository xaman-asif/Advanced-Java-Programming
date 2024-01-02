package org.advancedJavaProgramming.chapter6.scoping;

public class Main {
  public static void main(String[] args) {

  }

  public void method1() {
    String hello = "Hello World";

    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        String hello = "Hello world, I love Bangladesh!";

        System.out.println(hello);
      }
    };
  }

  public void method2() {
    String hello = "Hello, World!";

    Runnable runnable = () -> {
      // we can't declear hello again here, cause lambda expression doesn't scope
//      String hello = "Hello world, I love Bangladesh!";
      System.out.println(hello);
    };
  }
}
