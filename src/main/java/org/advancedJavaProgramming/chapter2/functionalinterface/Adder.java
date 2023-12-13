//package chapter2.functionalinterface;
//
//import java.util.Collections;
//
///*
// * a functional interface must contain only one method
// * which is a SAM - Single Abstract Method
// */
//@FunctionalInterface
//public interface Adder {
//  int add(int a, int b);
//}
//
///*
// * Extended methods can't be a functional interface
// */
//@FunctionalInterface
//public interface Calculator extends Adder {
//  int sub(int a, int b);
//}
//
///*
// * Though a functional interface can have below type of method
// * *Default Method
// * *Static Method
// * *Methods were inherited from Object class
// */
//@FunctionalInterface
//public interface Comparator<T> {
//  int compare(T o1, T o2);
//  boolean equals(Object obj);
//
//  default Comparator<T> reversed() {
//    return Collections.reverseOrder(this);
//  }
//
//  public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
//    return Collections.reverseOrder();
//  }
//}
