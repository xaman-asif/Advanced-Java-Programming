package org.advancedJavaProgramming.chapter7.lightweightstrategypattern.preJava8Implementation;

public class Email implements Communicable {
  @Override
  public String communicate(String destination, String message) {
    return "Communicating via Email -> sending message to " + "destination: [" + destination + "], message:["
           + message + " ]";
  }
}
