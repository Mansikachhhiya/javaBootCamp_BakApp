package io.tntra.javabootcamp.Model;

import io.tntra.javabootcamp.Account_type.Account_type;

import java.math.BigDecimal;

public class Account {
  private String ownerName;
  private BigDecimal balance;
  private Account_type account_type;
  private BigDecimal miniBalance;
  private BigDecimal overDraftLimit;

  public String getOwnerName() {
    return ownerName;
  }
  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }
  public BigDecimal getBalance() {
    return balance;
  }
  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }
  public Account_type getAccount_type() {
    return account_type;
  }
  public void setAccount_type(Account_type account_type) {
    this.account_type = account_type;
  }


  public BigDecimal getMiniBalance() {
    return miniBalance;
  }

  public void setMiniBalance(BigDecimal miniBalance) {
    this.miniBalance = miniBalance;
  }

  public BigDecimal getOverDraftLimit() {
    return overDraftLimit;
  }

  public BigDecimal setOverDraftLimit(BigDecimal overDraftLimit) {
    this.overDraftLimit = overDraftLimit;
    return overDraftLimit;
  }
}
