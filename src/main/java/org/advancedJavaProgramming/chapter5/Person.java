package org.advancedJavaProgramming.chapter5;

import java.util.Optional;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person {
  private String name;
  private int age;
  private String password;
  private String sex;
  private Optional<Smartphone> smartphone;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public Optional<String> getName() {
    return Optional.ofNullable(name);
  }

  public Optional<Integer> getAge() {
    return Optional.ofNullable(age);
  }

  public Optional<String> getPassword() {
    return Optional.ofNullable(password);
  }
}