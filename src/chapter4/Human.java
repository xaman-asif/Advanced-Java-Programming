package chapter4;

interface Conversable {
  default void hi() {
    System.out.println("hi from Conversable");
  }
}

interface ConversablePlus {
  default void hi() {
    System.out.println("hi from ConversablePlus");
  }
}

public class Human implements Conversable, ConversablePlus{
  public static void main(String[] args) {
    Human human = new Human();
    human.hi();

  }

  @Override
  public void hi() {
    Conversable.super.hi();
  }
}
