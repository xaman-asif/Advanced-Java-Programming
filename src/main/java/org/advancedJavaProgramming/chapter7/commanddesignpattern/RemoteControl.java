package org.advancedJavaProgramming.chapter7.commanddesignpattern;

import java.util.ArrayList;
import java.util.List;

//Invoker Class
public class RemoteControl {
  private final List<Command> history = new ArrayList<>();

  public void press(Command command) {
    history.add(command);
    command.execute();
  }
}
