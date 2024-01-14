package org.advancedJavaProgramming.chapter7.lightweightstrategypattern.preJava8Implementation;

public class CommunicationApplication {
  public static void main(String[] args) {
    var email = new Email();
    var phoneCall = new PhoneCall();
    var videoCall = new VideoCall();

    var communicationService = new CommunicationService();

    communicationService.setCommunicable(email);
    communicationService.sendMessage("hello@email.com", "Hello World");

    communicationService.setCommunicable(phoneCall);
    communicationService.sendMessage("+88016718xxxx", "Hello World");

  }
}
