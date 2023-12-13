package org.advancedJavaProgramming.chapter2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionDemo {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Tahmid Rafi", 30, Student.Gender.MALE),
                new Student("Abu Bokor", 28, Student.Gender.MALE),
                new Student("Mirza Rehenuma", 27, Student.Gender.FEMALE),
                new Student("James Gosling", 60, Student.Gender.MALE)
        );

        Function <Student, String> nameFunc = (Student s) -> s.getName();

        Function <Student, String> ageFunc = (Student s) -> String.valueOf(s.getAge()).toString();

        Function <Student, String> genderFunc = (Student s) -> s.getGender().toString();

        StudentProcessor processor = new StudentProcessor();

        List<String> names = processor.process(students, nameFunc);

        List<String> ages = processor.process(students, ageFunc);

        List<String> genders = processor.process(students, genderFunc);

        Predicate<Student> olderThan50 = (Student s) -> s.getAge() > 50;

        Predicate<Student> femaleOnly = (Student s) -> s.getGender().toString().equals("Female");

        List<Student> studentsOlderThan50 = processor.filter(students, olderThan50);

        List<Student> femaleStudents = processor.filter(students, femaleOnly);

    }
}
