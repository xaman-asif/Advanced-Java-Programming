package org.advancedJavaProgramming.chapter9.streampipeline;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

enum Sex {
  MALE, FEMALE
}

@Getter
@Setter
@AllArgsConstructor
public class Person {
  private int age;
  private String name;
  private Sex sex;
}
