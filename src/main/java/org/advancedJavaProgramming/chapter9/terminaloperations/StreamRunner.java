package org.advancedJavaProgramming.chapter9.terminaloperations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamRunner {
  public static void longCount() {
    List<Integer> listOfNumbers = List.of(1, 2, 3, 4, 5);

    long quantity = listOfNumbers.stream().count();

    System.out.println(quantity);
  }

  public static void wordCount() {
    try {
      List<String> lines = Files.readAllLines(Paths.get("./word.txt"));

      long wordCount = lines.stream()
          .map(line -> line.split("(?<=[,.]) | (?=[,.]) | \\s+")).flatMap(Stream::of).count();

      System.out.println(wordCount);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void forEachOrdered() {
    String[] numbers = {"one", "two", "three", "four"};

    Stream.of(numbers).parallel().forEach(number -> System.out.println(number + ": " + Thread.currentThread()));

    Stream.of(numbers).parallel().forEachOrdered(number -> System.out.println(number + ": " + Thread.currentThread()));
  }

  public static void toArray() {
    Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    Object[] integers = integerStream.toArray();

    for (Object integer : integers) {
      String hex = Integer.toHexString((Integer) integer);
      System.out.println(hex);
    }
  }

  public static void minMax() {
    List<Employee> employees = getEmployeeList();

    Optional<Employee> minId = employees.stream().min(Comparator.comparing(Employee::getId));
    Optional<Employee> maxId = employees.stream().max(Comparator.comparing(Employee::getId));

    minId.ifPresent(System.out::println);
    maxId.ifPresent(System.out::println);
  }

  private static List<Employee> getEmployeeList() {
    return List.of(
        new Employee(11, "James", 0),
        new Employee(22, "Roberto", 0),
        new Employee(12, "Bruno", 0),
        new Employee(2, "Andres", 0),
        new Employee(42, "Rodrigo", 0)
    );
  }

  public static void minMaxForPrimitives() {
    Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    IntStream intStream = integerStream.mapToInt(Integer::intValue);

    OptionalInt min = intStream.min();
    OptionalInt max = intStream.max();

    OptionalInt minn = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).mapToInt(Integer::intValue).min();
  }

  public static void anyMatch() {
    List<Employee> employees = getEmployeeList();

    boolean anyMatch = employees.stream().anyMatch(employee -> employee.getDepartment() == Employee.Department.IT);

    System.out.println(anyMatch);
  }

  public static void allMatch() {
    List<Employee> employees = getEmployeeList();

    boolean allMatch = employees.stream().allMatch(employee -> 18 < employee.getAge());

    System.out.println(allMatch);
  }

  public static void noneMatch() {
    List<Employee> employees = getEmployeeList();

    boolean noneMatch = employees.stream().noneMatch(employee -> 18 > employee.getAge());

    System.out.println(noneMatch);
  }

  public static void findAny() {
    List<Employee> employees = getEmployeeList();

    Optional<Employee> optionalEmployee =
        employees.stream().filter(e -> e.getDepartment() == Employee.Department.IT).findAny();
  }

  public static void findFirst() {
    List<Employee> employees = getEmployeeList();

    Optional<Employee> optionalEmployee =
        employees.stream().filter(e -> e.getDepartment() == Employee.Department.IT).findFirst();
  }

  public static void reduce() {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 89, 9);

    int sum = numbers.stream().reduce(0, Integer::sum);

    int product = numbers.stream().reduce(1, (a, b) -> a * b);

    int maxAge = getEmployeeList().stream().filter(e -> e.getDepartment() == Employee.Department.IT)
        .mapToInt(Employee::getAge).reduce(0, (e1, e2) -> e1 > e2 ? e1 : e2);
  }

  public static void collect() {
    Set<UUID> uuids = Stream.generate(UUID::randomUUID).limit(10).collect(Collectors.toSet());

    System.out.println(uuids);
  }

  public static void main(String[] args) {
//    longCount();
//    example2();
//    forEachOrdered();
//    toArray();
//    minMax();
//    anyMatch();
//    allMatch();
//    noneMatch();
//    findAny();
//    findFirst();
//    collect();
//    wordCount();
  }
}
