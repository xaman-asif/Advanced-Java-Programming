package org.advancedJavaProgramming.chapter9.parallelism;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FakeTransactionGenerator {
  public static List<Transaction> generate(int size) {
    Random random = new Random();

    return IntStream.range(0, size).mapToObj(value -> {
      String uuid = UUID.randomUUID().toString();
      boolean isCredit = random.nextBoolean();
      BigDecimal amount = getRandomAmount(BigDecimal.TEN, BigDecimal.valueOf(1000_000));

      return new Transaction(uuid, isCredit, amount);
    }).collect(Collectors.toList());
  }

  private static BigDecimal getRandomAmount(BigDecimal min, BigDecimal max) {
    BigDecimal randomBigDecimal = min.add(BigDecimal.valueOf(Math.random()).multiply(max.subtract(min)));

    return randomBigDecimal.setScale(2, RoundingMode.UP);
  }
}
