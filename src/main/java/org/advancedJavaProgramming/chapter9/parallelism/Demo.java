package org.advancedJavaProgramming.chapter9.parallelism;

import java.math.BigDecimal;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Demo {
  public static void main(String[] args) {
    List<Transaction> transactionList = FakeTransactionGenerator.generate(1_000_000);


    calculateTime(() -> processInSequential(transactionList), "Sequential Calculation: ", 10);
    calculateTime(() -> processInParallel(transactionList), "Parallel Calculation: ", 10);
  }

  private static BigDecimal processInParallel(List<Transaction> transactionList) {
    return transactionList.parallelStream()
        .filter(transaction -> transaction.isCredit())
//        .peek(transaction -> System.out.println("Thread: " + Thread.currentThread().getName()))
        .map(transaction -> transaction.getAmount())
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  private static BigDecimal processInSequential(List<Transaction> transactionList) {
    return transactionList.stream()
        .filter(transaction -> transaction.isCredit())
//        .peek(transaction -> System.out.println("Thread: " + Thread.currentThread().getName()))
        .map(transaction -> transaction.getAmount())
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }


  public static void calculateTime(Supplier<BigDecimal> supplier, String name, int iteration) {
    System.out.println("Starting: " + name);

    LongSummaryStatistics statistics = IntStream.range(0, iteration).mapToLong(value -> {
      long start = System.nanoTime();

      supplier.get();

      long duration = (System.nanoTime() - start);

      long msecs = duration / 1000_000;

      System.out.println("iteration: " + value + ", execution time: " + msecs);

      return msecs;
    }).summaryStatistics();

    System.out.println("Time to complete in " + name + " is: " + statistics.getAverage() + " msecs");
    System.out.println("Maximum: " + statistics.getMax());
    System.out.println("Minimum: " + statistics.getMin());
  }
}
