package org.advancedJavaProgramming.chapter5;

import java.util.Optional;

public class PersonOpt {
//  public Optional<SmartPhone> getSmartPhone() {
//    return smartPhone;
//  }

  public static void main(String[] args) {
    Optional<SmartPhone> smartPhone = Optional.ofNullable(new SmartPhone());
    smartPhone.ifPresent(s -> System.out.println(s));
  }
}

class SmartPhone {
  private Optional<EWallet> eWallet;

  public Optional<EWallet> geteWallet() {
    return eWallet;
  }
}

class EWallet {
  private Optional<String> accountNumber;

  public Optional<String> getAccountNumber() {
    return accountNumber;
  }
}
