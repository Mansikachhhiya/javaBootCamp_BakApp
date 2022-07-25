package io.tntra.javabootcamp.Model;

import io.tntra.javabootcamp.Account_type.Account_type;

import java.math.BigDecimal;

public class Account {
  private String ownerName;
  private BigDecimal balance;
  private Account_type account_type;
  private BigDecimal miniBalance = new BigDecimal(0);
  private BigDecimal overDraftLimit = new BigDecimal(0);

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


}
