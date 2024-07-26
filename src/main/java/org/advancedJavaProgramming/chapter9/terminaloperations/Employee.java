package org.advancedJavaProgramming.chapter9.terminaloperations;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
  private static long idGen = 0;
  private final long id;
  private final String name;
  private final int age;
  private Department department;

  public Employee(long id, String name, int age) {
    this.id = ++idGen;
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }

  enum Department {
    IT, HR, FINANCE, MARKETING, DEVELOPMENT
  }
}
