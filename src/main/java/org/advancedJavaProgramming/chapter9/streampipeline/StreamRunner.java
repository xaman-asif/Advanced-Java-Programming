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
  public static void collectionStream() {
    List<String> list = new ArrayList<>();
    Stream<String> stringStream = list.stream();

    Set<Integer> set = new HashSet<>();
    Stream<Integer> integerStream = set.stream();

    //we can declare on ad-hoc basis
    Stream<Integer> integerStream1 = Stream.of(1, 2, 3, 4, 5);

    //we can declare from an array
    String[] cities = {"Dhaka", "London", "Dubai", "Tokyo"};
    Stream<String> stream = Stream.of(cities);

    //to avoid null pointer exception we can declare empty string
    Stream<String> emotyStream = Stream.empty();
  }

  private static void iterateStream() {
    //Stream.iterate(T first, BinaryOperator<T> f)
    Stream<Integer> sequence = Stream.iterate(1, val -> val * 2);
    sequence.limit(10).forEach(val -> System.out.println(val + ", "));

    Stream.iterate(1, val -> ++val).limit(10).forEach(val -> System.out.println(val));
  }

  private static void iterateStreamWPredicate() {
    //Stream.iterate(T first, BinaryOperator<T> f)
    Stream<Integer> sequence =
        Stream.iterate(1, val -> val < 100, val -> val * 2);
    sequence.forEach(val -> System.out.println(val));
  }

  private static void generateStream() {
    Stream<UUID> uuidStream = Stream.generate(() -> UUID.randomUUID());
  }

  private static void rangeIntStream() {
    IntStream.range(0, 10)
        .forEach(val -> System.out.println(val + ", "));

    IntStream.rangeClosed(0, 10)
        .forEach(val -> System.out.println(val + ", "));
  }

  private static void bufferedReader() {
    try {
      URL url = new URL("http://google.com/");
      URLConnection conn = url.openConnection();

      BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

      Stream<String> lines = reader.lines();

      lines.limit(10).forEach(val -> System.out.println(val));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void bitsetStream() {
    BitSet bitSet = new BitSet(10);

    bitSet.set(4);

    IntStream stream = bitSet.stream();
  }

  private static void filterStream() {
    Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    Stream<Integer> evenNumberStream = numbers.filter(n -> n % 2 == 0);
  }

  private static void sortedStream() {
    List<Person> personList =
        getPersons();

    personList.stream().sorted((p1, p2) -> compareByAgeAndThenName(p1, p2))
        .forEach(p1 -> printPerson(p1));

    personList.stream().sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getName).reversed())
        .forEach(System.out::println);
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

  private static void sortedStreamWNullsLast() {
    getPersons().stream().sorted(Comparator.nullsLast(Comparator.comparing(Person::getAge))
            .thenComparing(Comparator.nullsLast(Comparator.comparing(Person::getName))))
        .forEach(person -> printPerson(person));
  }

  private static void peekStream() {
    List<Person> listPerson = getPersons().stream()
        .peek(person -> System.out.println("before filter: " + person.getAge() + " : " + person.getName()))
        .filter(person -> 15 < person.getAge())
        .peek(person -> System.out.println("after filter: " + person.getAge() + " : " + person.getName()))
        .sorted((Comparator.comparing(Person::getName))).toList();
  }

  private static void limitStream() {
    isPrime(29);
  }

  private static boolean isPrime(int number) {
    if (number < 2) {
      return false;
    }

    return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
  }

  private static void skipStream() {
    IntStream intStream = IntStream.range(0, 20);

    intStream.skip(5).filter(value -> isPrime(value)).forEach(value -> System.out.println(value));
  }

  private static void takeWhileStream() {
    List<Integer> integerList = List.of(1, 2, 3, 4, 5, 66, 77, 88, 99, 00);

    integerList.stream().peek(val -> System.out.println("before: " + val)).takeWhile(val -> val < 15)
        .forEach(num -> System.out.println("after: " + num));
  }

  private static void dropWhileStream() {
    List<Integer> integerList = List.of(1, 2, 3, 4, 5, 66, 77, 88, 99, 00);

    integerList.stream().peek(val -> System.out.println("before: " + val)).dropWhile(val -> val < 15)
        .forEach(num -> System.out.println("after: " + num));
  }

  public static void main(String[] args) {
    collectionStream();
    iterateStream();
    iterateStreamWPredicate();
    generateStream();
    rangeIntStream();
    bufferedReader();
    bitsetStream();
    filterStream();
    mapStream();
    sortedStream();
    sortedStreamWNullsLast();
    peekStream();
    limitStream();
    skipStream();
    takeWhileStream();
    dropWhileStream();
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

  private static void mapStream() {
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

    personStream.filter(StreamRunner::isOlderThan15).map(Person::getName)
        .forEach(System.out::println);
  }

  private static boolean isOlderThan15(Person person) {
    return 15 < person.getAge();
  }
}
