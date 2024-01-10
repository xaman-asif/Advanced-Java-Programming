package org.advancedJavaProgramming.chapter7.commanddesignpattern;

public class OffComand implements Command {
  private final TV tv;

  public OffComand(TV tv) {
    this.tv = tv;
  }


  @Override
  public void execute() {
    tv.switchOff();
  }
}
