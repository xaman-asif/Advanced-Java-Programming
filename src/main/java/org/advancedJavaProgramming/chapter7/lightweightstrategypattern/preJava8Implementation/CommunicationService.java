package org.advancedJavaProgramming.chapter7.lightweightstrategypattern.preJava8Implementation;

public class CommunicationService {
  private Communicable communicable;

  public void setCommunicable(Communicable communicable) {
    this.communicable = communicable;
  }

  public void sendMessage(String destination, String message) {
    var log = communicable.communicate(destination, message);

    System.out.println(log);
  }
}
