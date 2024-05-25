package org.advancedJavaProgramming.chapter8.generictype;

public class Holder<T> {
  private T object;

  public T getObject() {
    return object;
  }

  public Holder setObject(T object) {
    this.object = object;
    return this;
  }
}