/*package org.advancedJavaProgramming.chapter7.builderpattern;

public class Computer {
  private final Disk disk;
  private final Processor processor;

  public Computer(Disk disk, Processor processor) {
    this.disk = disk;
    this.processor = processor;
  }

  public static void main(String[] args) {
    ComputerBuilder.aComputer().withProcessor(processor()).withDisk(disk()).build();
  }

  public Disk getDisk() {
    return disk;
  }

  public Processor getProcessor() {
    return processor;
  }

  public static final class ComputerBuilder {
    private Disk disk;
    private Processor processor;

    private ComputerBuilder() {

    }

    public static ComputerBuilder aComputer() {
      return new ComputerBuilder();
    }

    public ComputerBuilder withDisk(Disk disk) {
      this.disk = disk;
      return this;
    }

    public ComputerBuilder withProcessor(Processor processor) {
      this.processor = processor;
      return this;
    }

    public Computer build() {
      Computer computer = new Computer(disk, processor);
      return computer;
    }
  }
}
*/