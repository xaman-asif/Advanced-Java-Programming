package org.advancedJavaProgramming.chapter9.streampipeline;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamRunner {
  public static void streamExample1() {
    List<String> list = new ArrayList<>();
    Stream<String> stringStream = list.stream();

    Set<Integer> set = new HashSet<>();
    Stream<Integer> integerStream = set.stream();

    Stream<Integer> integerStream1 = Stream.of(1, 2, 3, 4, 5);

    String[] cities = {"Dhaka", "London", "Dubai", "Tokyo"};
    Stream<String> stream = Stream.of(cities);

    Stream<String> emotyStream = Stream.empty();
  }

  private static void streamExample2() {
    //Stream.iterate(T first, BinaryOperator<T> f)
    Stream<Integer> sequence = Stream.iterate(1, val -> val * 2);
    sequence.limit(10).forEach(val -> System.out.println(val + ", "));

    Stream.iterate(1, val -> ++val).limit(10).forEach(val -> System.out.println(val));
  }

  private static void streamExample3() {
    //Stream.iterate(T first, BinaryOperator<T> f)
    Stream<Integer> sequence =
        Stream.iterate(1, val -> val < 100, val -> val * 2);
    sequence.forEach(val -> System.out.println(val));
  }

  private static void streamExample4() {
    Stream<UUID> uuidStream = Stream.generate(() -> UUID.randomUUID());
  }

  private static void streamExample5() {
    IntStream.range(0, 10)
        .forEach(val -> System.out.println(val + ", "));

    IntStream.rangeClosed(0, 10)
        .forEach(val -> System.out.println(val + ", "));
  }

  private static void streamExample6() {
    try {
      URL url = new URL("http://localhost:4200/");
      URLConnection conn = url.openConnection();

      BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

      Stream<String> lines = reader.lines();

      lines.limit(10).forEach(val -> System.out.println(val));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void streamExample7() {
    BitSet bitSet = new BitSet(10);

    bitSet.set(4);

    IntStream stream = bitSet.stream();
  }

  private static void streamExample8() {
    Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    Stream<Integer> evenNumberStream = numbers.filter(n -> n % 2 == 0);
  }

  private static void streamExample10() {
    List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);

    numbers.stream().distinct().forEach(System.out::println);
  }

  private static void streamExample12() {
    getPersons().stream().sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getName).reversed())
        .forEach(System.out::println);
  }

  private static void streamExample11() {
    List<Person> personList =
        getPersons();

    personList.stream().sorted((p1, p2) -> compareByAgeAndThenName(p1, p2))
        .forEach(p1 -> printPerson(p1));
  }

  private static int compareByAgeAndThenName(Person p1, Person p2) {
    if (p1.getAge() > p2.getAge()) {
      return 1;
    } else if (p1.getAge() < p2.getAge()) {
      return -1;
    } else {
      return p1.getName().compareTo(p2.getName());
    }
  }

  private static void printPerson(Person person) {
    System.out.println(person.getAge() + " " + person.getName());
  }

  private static void streamExample13() {
    getPersons().stream().sorted(Comparator.nullsLast(Comparator.comparing(Person::getAge))
            .thenComparing(Comparator.nullsLast(Comparator.comparing(Person::getName))))
        .forEach(person -> printPerson(person));
  }

  private static void streamExample14() {
    List<Person> listPerson = getPersons().stream()
        .peek(person -> System.out.println("before filter: " + person.getAge() + " : " + person.getName()))
        .filter(person -> 15 < person.getAge())
        .peek(person -> System.out.println("after filter: " + person.getAge() + " : " + person.getName()))
        .sorted((Comparator.comparing(Person::getName))).toList();
  }

  private static void streamExample15() {
    isPrime(29);
  }

  private static boolean isPrime(int number) {
    if (number < 2) {
      return false;
    }

    return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
  }

  private static void streamExample16() {
    IntStream intStream = IntStream.range(0, 20);

    intStream.skip(5).filter(value -> isPrime(value)).forEach(value -> System.out.println(value));
  }

  private static void streamExample17() {
    List<Integer> integerList = List.of(1, 2, 3, 4, 5, 66, 77, 88, 99, 00);

    integerList.stream().peek(val -> System.out.println("before: " + val)).filter(val -> val < 15)
        .forEach(num -> System.out.println("after: " + num));
  }

  private static void streamExample18() {
    List<Integer> integerList = List.of(1, 2, 3, 4, 5, 66, 77, 88, 99, 00);

    integerList.stream().peek(val -> System.out.println("before: " + val)).takeWhile(val -> val < 15)
        .forEach(num -> System.out.println("after: " + num));
  }

  private static void streamExample19() {
    List<Integer> integerList = List.of(1, 2, 3, 4, 5, 66, 77, 88, 99, 00);

    integerList.stream().peek(val -> System.out.println("before: " + val)).dropWhile(val -> val < 15)
        .forEach(num -> System.out.println("after: " + num));
  }

  public static void main(String[] args) {
    //    streamExample1();
    //    streamExample2();
    //    streamExample3();
    //    streamExample4();
    //    streamExample5();
    //    streamExample6();
    //    streamExample7();
    //    streamExample8();
    //    streamExample9();
    //    streamExample10();
    //    streamExample11();
    //    streamExample12();
    //    streamExample13();
    //    streamExample14();
    //    streamExample15();
    //    streamExample16();
    //    streamExample17();
    //    streamExample18();
    streamExample19();
  }

  private static List<Person> getPersons() {
    return Arrays.asList(
        new Person(15, "Sayeem", Sex.MALE),
        new Person(12, "Tamanna", Sex.FEMALE),
        new Person(23, "Eram", Sex.MALE),
        new Person(20, "Rifat", Sex.MALE),
        new Person(8, "Saif", Sex.MALE),
        new Person(8, "Omio", Sex.FEMALE)
    );
  }

  private void streamExample9() {
    Stream<Person> personStream = Stream.of(
        new Person(15, "Sayeem", Sex.MALE),
        new Person(12, "Tamanna", Sex.MALE),
        new Person(23, "Eram", Sex.MALE),
        new Person(20, "Rifat", Sex.MALE),
        new Person(8, "Saif", Sex.MALE)
    );

    //    Stream<Person> personOlderThan15 = personStream.filter(person -> 15 < person.getAge());
    //
    //    Stream<String> nameStream = personOlderThan15.map(person -> person.getName());
    //
    //    nameStream.forEach(name -> System.out.println(name));

    personStream.filter(this::isOlderThan15).map(Person::getName)
        .forEach(System.out::println);
  }

  private boolean isOlderThan15(Person person) {
    return 15 < person.getAge();
  }
}
