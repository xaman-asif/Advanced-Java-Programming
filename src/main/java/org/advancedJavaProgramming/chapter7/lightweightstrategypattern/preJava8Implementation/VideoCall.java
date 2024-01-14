package org.advancedJavaProgramming.chapter7.lightweightstrategypattern.preJava8Implementation;

public class VideoCall implements Communicable {

  @Override
  public String communicate(String destination, String message) {
    return "Communicating via VideoCall -> sending message to " + "destination: [" + destination + "], message:["
           + message + " ]";
  }
}
