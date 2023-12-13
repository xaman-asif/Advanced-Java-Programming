package org.advancedJavaProgramming.chapter3.instancemethodreference;

public class Person {
  private String name;
  private int age;
  private String email;

  public Person(String name, int age, String email) {
    this.name = name;
    this.age = age;
    this.email = email;
  }

  public void sendEmail() {
    System.out.println("sending mail to :" + email);
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getEmail() {
    return email;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
