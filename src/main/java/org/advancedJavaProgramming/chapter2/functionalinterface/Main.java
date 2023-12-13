package org.advancedJavaProgramming.chapter2.functionalinterface;

public class Main {
  public static void main(String[] args) {
    Converter upperCaseConverter = (String s) -> s.toUpperCase();

    Converter titleCaseConverter = (String s) -> {
      StringBuilder sb = new StringBuilder();
      boolean nextTitleCase = true;

      for (char c : s.toCharArray()) {
        if (Character.isSpaceChar(c)) {
          nextTitleCase = true;
        } else if (nextTitleCase) {
          c = Character.toUpperCase(c);
          nextTitleCase = false;
        }

        sb.append(c);
      }

      return sb.toString();
    };

    String helloWorld = upperCaseConverter.apply("Hello World");
    String descOfBangladesh = titleCaseConverter.apply("it's a shit country");
    System.out.println(helloWorld);
    System.out.println(descOfBangladesh);
  }
}
