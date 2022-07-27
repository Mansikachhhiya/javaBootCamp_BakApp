package io.tntra.javabootcamp.services;

import io.tntra.javabootcamp.Model.Account;
import io.tntra.javabootcamp.exception.InSufficientBalance;
import io.tntra.javabootcamp.exception.miniBalanceExcepction;
import io.tntra.javabootcamp.exception.ownerException;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

public interface BankAccount {



  Account getAccount(String ownerName) throws ownerException;



  void updateAccount(String ownerName, Account account) throws ownerException;



  void createAccount(Account account) throws miniBalanceExcepction;

  void deleteAccount(String ownerName) throws ownerException;



  Collection<Account> get_Account() ;



  BigDecimal get_Balance(String ownerName) throws ownerException;



  //Withdraw Function

  BigDecimal deposit(String ownerName,BigDecimal amount) throws ownerException;


  //Withdraw Function
  BigDecimal withdraw(BigDecimal amount, String ownerName) throws ownerException,InSufficientBalance;


}
