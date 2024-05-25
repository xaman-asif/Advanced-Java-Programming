package org.advancedJavaProgramming.chapter7.builderpattern;

public class Processor {
  private final int cores;
  private final int speed;
  private final int type;

  public Processor(int cores, int speed, int type) {
    this.cores = cores;
    this.speed = speed;
    this.type = type;
  }

  public int getCores() {
    return cores;
  }

  public int getSpeed() {
    return speed;
  }

  public int getType() {
    return type;
  }

  public enum Type {
    i386, x64, x64_64
  }
}
