package org.advancedJavaProgramming.chapter7.lightweightstrategypattern.lambdaImplementation;

@FunctionalInterface
public interface Communicable {
  String communicate(String destination, String message);
}
