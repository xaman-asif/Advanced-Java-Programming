package org.advancedJavaProgramming.chapter9.parallelism;

import java.math.BigDecimal;
import lombok.Getter;

@Getter
public class Transaction {
  private final String transactionId;
  private final boolean credit;
  private final BigDecimal amount;

  public Transaction(String transactionId, boolean credit, BigDecimal amount) {
    this.transactionId = transactionId;
    this.credit = credit;
    this.amount = amount;
  }
}
