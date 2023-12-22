package org.advancedJavaProgramming.chapter5;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.Data;

@Data
public class PersonRunner {
  public static void main(String[] args) {
    Optional<Smartphone> smartPhone = Optional.ofNullable(new Smartphone());
    smartPhone.ifPresent(System.out::println);

    Optional.ofNullable(findPersonByName("James"))
        .filter(person -> "male".equals(person.getSex()))
        .ifPresent(person -> doSomething(person));
  }

  private static void listOfCountries() {
    List<String> countryNames = List.of("Bangladesh", "India", "Pakistan", "South Sudan", "French");

    Stream<Optional<Country>> optionalStream = countryNames.stream().map(name -> findStatisticalCapacityScore(name));

    Stream<Optional<Country>> filterOptionalStream = optionalStream.filter(optional -> optional.isPresent());

    List<Country> countries = filterOptionalStream.map(optional -> optional.get()).collect(Collectors.toList());
  }

  private static void listOfCountries2() {
    List<String> countryNames = List.of("Bangladesh", "India", "Pakistan", "South Sudan", "French");

    List<Country> countries = countryNames.stream()
        .map(name -> findStatisticalCapacityScore(name))
        .filter(optional -> optional.isPresent())
        .map(optional -> optional.get())
        .collect(Collectors.toList());
  }

  private static void listOfCountries3() {
    List<String> countryNames = List.of("Bangladesh", "India", "Pakistan", "South Sudan", "French");

    List<Country> countries = countryNames
        .stream()
        .map(PersonRunner::findStatisticalCapacityScore)
        .flatMap(Optional::stream)
        .collect(Collectors.toList());
  }

  private static Optional<Country> findStatisticalCapacityScore(String name) {

    return Optional.empty();
  }

  public static Optional<String> getWalletAccountNumber(Person person) {
    return Optional.ofNullable(person)
        .flatMap(Person::getSmartphone)
        .flatMap(Smartphone::getWallet)
        .flatMap(EWallet::getAccountNumber);
  }


  public static Person findPersonByName(String name) {

    return new Person();
  }

  public static void doSomething(Person person) {

  }
}