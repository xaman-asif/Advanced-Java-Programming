package org.advancedJavaProgramming.chapter5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.junit.Test;

public class Baeldung {

  @Test
  public void whenCreatesEmptyOptional_thenCorrect() {
    Optional<String> empty = Optional.empty();
    assertTrue(empty.isEmpty());
  }

  @Test
  public void givenNonNull_whenCreatesNonNullable_thenCorrect() {
    String name = "baeldung";
    Optional<String> opt = Optional.of(name);
    assertTrue(opt.isPresent());
  }

  @Test(expected = NullPointerException.class)
  public void givenNull_whenThrowsErrorOnCreate_thenCorrect() {
    String name = null;
    Optional.of(name);
  }

  @Test
  public void givenNull_whenCreatesNullable_thenCorrect() {
    String name = null;
    Optional<String> opt = Optional.ofNullable(name);
    assertFalse(opt.isPresent());
  }

  @Test
  public void givenOptional_whenIsPresentWorks_thenCorrect() {
    Optional<String> opt = Optional.of("Baeldung");
    assertTrue(opt.isPresent());

    opt = Optional.ofNullable(null);
    assertFalse(opt.isPresent());
  }

  @Test
  public void givenOptional_whenIfPresentWorks_thenCorrect() {
    Optional<String> opt = Optional.of("Baeldung");
    opt.ifPresent(name -> System.out.println(name));
  }

  @Test
  public void whenOrElseGetWorks_thenCorrect() {
    String nullName = null;
    String name = Optional.ofNullable(nullName).orElseGet(() -> "John");

    assertEquals("John", name);
  }

  @Test(expected = NoSuchElementException.class)
  public void whenOrElseThrowWorks_thenCorrect() {
    String nullName = null;
    String name = Optional.ofNullable(nullName).orElseThrow();
  }

  @Test
  public void givenOptional_whenGetsValue_thenCorrect() {
    Optional<String> opt = Optional.of("baeldung");
    String name = opt.get();
    assertEquals("baeldung", name);
  }

  @Test
  public void whenOptionalFilterWorks_thenCorrect() {
    Integer year = 2016;

    Optional<Integer> yearOptional = Optional.of(year);

    boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
    assertTrue(is2016);

    boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
    assertFalse(is2017);
  }

  public boolean priceInRange2(Modem modem) {
    return Optional.ofNullable(modem)
        .map(Modem::getPrice)
        .filter(p -> p >= 10)
        .filter(p -> p <= 15)
        .isPresent();
  }

  @Test
  public void givenOptional_whenMapWorks_thenCorrect() {
    List<String> companyNames = List.of("paypal", "oracle", "", "microsoft", "", "apple");

    Optional<List<String>> listOptional = Optional.of(companyNames);

    int size = listOptional.map(List::size).orElse(0);

    assertEquals(6, size);
  }

  @Test
  public void givenOptional_whenMapWorksWithFilter_thenCorrect() {
    String password = " password ";
    Optional<String> passOpt = Optional.of(password);

    boolean correctPassword = passOpt.map(String::trim)
        .filter(pass -> pass.equals("password"))
        .isPresent();
    assertTrue(correctPassword);
  }

  @Test
  public void givenOptional_whenFlatMapWorks_thenCorrect2() {
    Person person = new Person("john", 26);

    Optional<Person> personOptional = Optional.of(person);

    Optional<Optional<String>> nameOptionalWrapper
        = personOptional.map(Person::getName);
    Optional<String> nameOptional = nameOptionalWrapper.orElseThrow(IllegalArgumentException::new);
    String name1 = nameOptional.orElse("");
    assertEquals("john", name1);

    String name = personOptional.flatMap(Person::getName).orElse("");
    assertEquals("john", name);
  }

  private Optional<String> getEmpty() {
    return Optional.empty();
  }

  private Optional<String> getHello() {
    return Optional.of("hello");
  }

  private Optional<String> getBye() {
    return Optional.of("bye");
  }

  private Optional<String> createOptional(String input) {
    if (input == null || "".equals(input) || "empty".equals(input)) {
      return Optional.empty();
    }

    return Optional.of(input);
  }

  @Test
  public void givenThreeOptionals_whenChaining_thenFirstNonEmptyIsReturned() {
    Optional<String> found =
        Stream.of(getEmpty(), getHello(), getBye())
            .filter(Optional::isPresent)
            .map(Optional::get)
            .findFirst();

    assertEquals(getHello(), found);
  }

  @Test
  public void givenTwoOptionalsReturnedByOneArgMethod_whenChaining_thenFirstNonEmptyIsReturned() {
    Optional<String> found =
        Stream.<Supplier<Optional<String>>>of(
                () -> createOptional("empty"),
                () -> createOptional("hello")
            )
            .map(Supplier::get)
            .filter(Optional::isPresent)
            .map(Optional::get)
            .findFirst();
  }
}
