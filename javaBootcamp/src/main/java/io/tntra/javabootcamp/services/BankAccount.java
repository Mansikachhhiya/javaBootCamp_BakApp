package io.tntra.javabootcamp.services;

import io.tntra.javabootcamp.Model.Account;
import io.tntra.javabootcamp.exception.InSufficientBalance;
import io.tntra.javabootcamp.exception.miniBalanceExcepction;
import io.tntra.javabootcamp.exception.ownerException;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

public interface BankAccount {


//  Collection<Account> get_Account(Map<String, Account> accountInfo) throws ownerException;

  Account getAccount(String ownerName) throws ownerException;

//  Account getAccount(String ownerName, Map<String, Account> accountInfo) throws ownerException;

  void updateAccount(String ownerName, Account account) throws ownerException;

//  void createAccount(Account account, Map<String, Account> accountInfo);

  void createAccount(Account account) throws miniBalanceExcepction;

  void deleteAccount(String ownerName) throws ownerException;

//  void deleteAccount(String ownerName, Map<String, Account> accountInfo) throws ownerException;

  Collection<Account> get_Account() ;

//  void updateAccount(String ownerName, Account account, Map<String, Account> accountInfo) throws ownerException;

  BigDecimal get_Balance(String ownerName) throws ownerException;

//  BigDecimal get_Balance(String ownerName, Map<String, Account> accountInfo) throws ownerException;

  //Withdraw Function
//  void withdraw(BigDecimal amount) throws InSufficientBalance;
  BigDecimal deposit(String ownerName,BigDecimal amount) throws ownerException;

  //Deposit function
//  BigDecimal deposit(String ownerName, BigDecimal amount, Map<String, Account> accountInfo) throws ownerException;

  //Withdraw Function
  BigDecimal withdraw(BigDecimal amount, String ownerName) throws ownerException,InSufficientBalance;

//  void withdraw(BigDecimal amount, String ownerName, Map<String, Account> accountInfo) throws ownerException, InSufficientBalance;

  //  BigDecimal get_Balance();
//  public abstract void withdraw(BigDecimal amount) throws InSufficientBalance;
//  public abstract BigDecimal deposit(BigDecimal amount);

}
