package chapter3.methodreference;

import chapter2.Student;
import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();

    list.sort((a, b) -> a.compareToIgnoreCase(b));

    list.sort(String::compareToIgnoreCase);

    Function<Student, String> function = s -> s.getName();

    System.out.println(function.apply(new Student("John Doe", 24, Student.Gender.MALE)));

    Function<String, Integer> mapper = Integer::parseInt;

//    Function<Integer, Integer> adder = (x, y) -> Integer.sum(x, y);
    BiFunction<Integer, Integer, Integer> sum = Integer::sum;

  }
}
