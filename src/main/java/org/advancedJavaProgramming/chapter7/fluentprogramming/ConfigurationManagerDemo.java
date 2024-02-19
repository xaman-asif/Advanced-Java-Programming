package org.advancedJavaProgramming.chapter7.fluentprogramming;

public class ConfigurationManagerDemo {
  public static void main(String[] args) {
    ConfigurationManager configManager = ConfigurationManager.make(configurationManager -> configurationManager
        .setUrl("production.mydatabase.com")
        .setUsername("bazlur")
        .setPassword("abc123")
        .addRole("Admin")
        .addRole("Developer"));
  }
}
