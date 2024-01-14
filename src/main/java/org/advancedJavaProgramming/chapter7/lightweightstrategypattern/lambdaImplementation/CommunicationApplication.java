package org.advancedJavaProgramming.chapter7.lightweightstrategypattern.lambdaImplementation;

import org.advancedJavaProgramming.chapter7.lightweightstrategypattern.preJava8Implementation.CommunicationService;

public class CommunicationApplication {
  public static void main(String[] args) {
    var communicationService = new CommunicationService();

    communicationService.setCommunicable(
        ((destination, message) -> "Communicating via Email -> sending message to " + "destination: [" + destination
                                   + "], message:["
                                   + message + " ]"));
    communicationService.sendMessage("hello@email.com", "Hello World");

    communicationService.setCommunicable(
        ((destination, message) -> "Communicating via Email -> sending message to " + "destination: [" + destination
                                   + "], message:["
                                   + message + " ]"));
    communicationService.sendMessage("0167890xxxx", "Hello World");
  }
}
