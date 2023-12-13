package org.advancedJavaProgramming.chapter2.variablecapturing;

@FunctionalInterface
public interface MessageTranslator {
    String translate(String msg);
}
