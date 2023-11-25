package chapter2.targettypingcontext;

import java.io.FileFilter;
import java.util.Comparator;

public class AdderMain {
  public static void main(String[] args) {
    Adder adder = new Adder() {
      @Override
      public int add(int a, int b) {
        return a + b;
      }
    };

    Adder adder1 = (int a, int b) -> a + b;

    Comparator<String> comparator;
    comparator = (String s1, String s2) -> s1.compareToIgnoreCase(s2);

    getRunnable().run();
  }

  public static Runnable getRunnable() {
    return () -> {
      System.out.println("returning a");
      System.out.println("Runnable");
    };
  }

  FileFilter[] fileFilters = {
      file -> file.exists(),
      file -> file.canRead(),
      file -> file.canExecute(),
      file -> file.getName().endsWith(".sh")
  };
}
