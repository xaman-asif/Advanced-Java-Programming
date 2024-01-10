package org.advancedJavaProgramming.chapter7.commanddesignpattern;

public class OnCommand implements Command {
  private final TV tv;

  public OnCommand(TV tv) {
    this.tv = tv;
  }

  @Override
  public void execute() {
    tv.switchOn();
  }
}
