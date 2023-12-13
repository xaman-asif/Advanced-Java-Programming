package org.advancedJavaProgramming.chapter4;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public interface Loggable {
  Logger getLogger();
  String getDelimiter();
  void log(Level level, String message);

  default void info(String message, Object... objects) {
    getLogger().log(new LogRecord(Level.SEVERE, formatMessage(message, objects)));
  }

  // if a default method has too many codes we can extract
  // them out to a private method
  default String formatMessage(String message, Object... args) {
    StringBuilder sbMessage = new StringBuilder(message);

    for (Object arg : args) {

    }

    return sbMessage.toString();
  }
}
