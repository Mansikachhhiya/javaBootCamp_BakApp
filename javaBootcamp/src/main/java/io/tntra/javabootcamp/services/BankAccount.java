package io.tntra.javabootcamp.services;

import io.tntra.javabootcamp.Model.Account;

import java.math.BigDecimal;
import java.util.Collection;

public interface BankAccount {
  public abstract void createAccount(Account account);
  public abstract void updateAccount(String ownerName,Account account);
  public abstract void deleteAccount(String ownerName);
  public abstract Collection<Account> getAccount();
  public abstract BigDecimal get_Balance(String ownerName);

//  BigDecimal get_Balance();
//  public abstract void withdraw(BigDecimal amount) throws InSufficientBalance;
//  public abstract BigDecimal deposit(BigDecimal amount);
//  public abstract boolean checkBalance(BigDecimal amount);
}
