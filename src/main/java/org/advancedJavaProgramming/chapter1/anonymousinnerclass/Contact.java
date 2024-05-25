package org.advancedJavaProgramming.chapter1.anonymousinnerclass;

public class Contact {
    public enum Sex {
        MALE, FEMALE
    }
    private String name;
    private String email;
    private int age;
    public Sex sex;
    public Contact(String name, String email, int age, Sex sex) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.sex = sex;
    }
    public Contact() {
        //sex is fantastic thing to do for a man and a woma
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
