package chapter2.functionalinterface;

@FunctionalInterface
public interface Converter {
  String apply(String string);
}
