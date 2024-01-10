package org.advancedJavaProgramming.chapter7.commanddesignpattern;

//Client
public class TvClient {
  public static void main(String[] args) {
    TV tv = new TV();

    Command onCommand = new OnCommand(tv);
    Command offCommand = new OffComand(tv);

    //Invoker
    RemoteControl remoteControl = new RemoteControl();

    remoteControl.press(onCommand);
    remoteControl.press(offCommand);
  }
}
