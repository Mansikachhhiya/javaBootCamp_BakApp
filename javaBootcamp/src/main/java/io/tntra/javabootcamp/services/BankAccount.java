package io.tntra.javabootcamp.services;

import io.tntra.javabootcamp.Model.Account;
import io.tntra.javabootcamp.exception.InSufficientBalance;
import io.tntra.javabootcamp.exception.ownerException;

import java.math.BigDecimal;
import java.util.Collection;

public interface BankAccount {
   void createAccount(Account account);

  Account getAccount(String ownerName) throws ownerException;

 void updateAccount(String ownerName, Account account) throws ownerException;
  void deleteAccount(String ownerName) throws ownerException;
   Collection<Account> get_Account() throws ownerException;
   BigDecimal get_Balance(String ownerName) throws ownerException;

  //Withdraw Function
//  void withdraw(BigDecimal amount) throws InSufficientBalance;
  BigDecimal deposit(String ownerName,BigDecimal amount) throws ownerException;
  //Withdraw Function
  void withdraw(BigDecimal amount, String ownerName) throws ownerException,InSufficientBalance;

  //  BigDecimal get_Balance();
//  public abstract void withdraw(BigDecimal amount) throws InSufficientBalance;
//  public abstract BigDecimal deposit(BigDecimal amount);

}
