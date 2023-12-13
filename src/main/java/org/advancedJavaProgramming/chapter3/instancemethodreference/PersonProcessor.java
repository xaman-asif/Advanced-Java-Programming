package org.advancedJavaProgramming.chapter3.instancemethodreference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class PersonProcessor {
  public static void forEach(List<Person> persons, Consumer<Person> func) {
    for (Person person : persons) {
      func.accept(person);
    }
  }

  public static void main(String[] args) {
    List<Person> persons =
        Arrays.asList(new Person("John Doe", 65, "johndoe@gmail.com"), new Person("Jane Doe", 36, "janedoe@gmail.com"));

    forEach(persons, Person::sendEmail);
  }
}
