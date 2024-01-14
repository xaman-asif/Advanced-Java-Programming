package org.advancedJavaProgramming.chapter7.lightweightstrategypattern.preJava8Implementation;

public class PhoneCall implements Communicable {
  @Override
  public String communicate(String destination, String message) {
    return "Communicating via PhoneCall -> sending message to " + "destination: [" + destination + "], message:["
           + message + " ]";
  }
}
