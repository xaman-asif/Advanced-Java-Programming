package org.advancedJavaProgramming.chapter6.internalexternaliteration;

import java.util.List;

public class PersonProcessor {
  public void internalIteration(List<Person> personList) {
    for (Person person : personList) {
      if (person.getAge() >= 18) {
        sendEmail(person);
      }
    }
  }

  public void externalIteration(List<Person> personList) {
    personList.parallelStream().forEach(person -> {
      if (person.getAge() >= 18) {
        sendEmail(person);
      }
    });
  }

  private void sendEmail(Person person) {
    System.out.println("Sending email to: " + person.getName());
  }
}
