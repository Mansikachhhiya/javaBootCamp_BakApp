package io.tntra.javabootcamp.services;

import io.tntra.javabootcamp.Model.Account;
import io.tntra.javabootcamp.exception.InSufficientBalance;
import io.tntra.javabootcamp.exception.miniBalanceExcepction;
import io.tntra.javabootcamp.exception.ownerException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;

@Service
public class ICICI_BankService extends accountService implements BankAccount{
  @Override
  public void createAccount(Account account) throws miniBalanceExcepction {
    account.setMiniBalance(BigDecimal.valueOf(2000));
    if(account.getBalance().compareTo(account.getMiniBalance())>=0) {
      super.createAccount(account);
    }
    else {
      throw new miniBalanceExcepction("Minimum balance of \"+account.getMinBalance()+\" is required");
    }
  }

  @Override
  public void deleteAccount(String ownerName) throws ownerException {
    super.deleteAccount(ownerName);
  }

  @Override
  public Collection<Account> get_Account()  {
    return super.get_Account();
  }

  @Override
  public Account getAccount(String ownerName) throws ownerException {
    return super.getAccount(ownerName);
  }

  @Override
  public void updateAccount(String ownerName, Account account) throws ownerException {
    super.updateAccount(ownerName, account);
  }

  @Override
  public BigDecimal get_Balance(String ownerName) throws ownerException {
    return super.get_Balance(ownerName);
  }

  @Override
  public BigDecimal deposit(String ownerName, BigDecimal amount) throws ownerException {
    return super.deposit(ownerName, amount);
  }

  @Override
  public BigDecimal withdraw(BigDecimal amount, String ownerName) throws ownerException, InSufficientBalance {
    return super.withdraw(amount, ownerName);
  }

  @Override
  public boolean checkOwner(String ownerName) {
    return super.checkOwner(ownerName);
  }

  @Override
  public boolean checkBalance(BigDecimal amount, String ownerName) throws ownerException {
    return super.checkBalance(amount, ownerName);
  }
//  accountService accountService;
//  public ICICI_BankService(accountService accountService) {
//    this.accountService = accountService;
//  }
//private static final Map<String, Account> ICICIInfo = new HashMap<>();
//  @Override
//  public void createAccount(Account account,Map<String, Account> ICICIInfo) {
//
//    super.createAccount(account,ICICIInfo);
//  }
//
//  @Override
//  public void deleteAccount(String ownerName,Map<String, Account> ICICIInfo) throws ownerException {
//    super.deleteAccount(ownerName,ICICIInfo);
//  }
//
//  @Override
//  public Collection<Account> get_Account(Map<String, Account> ICICIInfo) throws ownerException {
//    return super.get_Account(ICICIInfo);
//  }
//
//  @Override
//  public Account getAccount(String ownerName,Map<String, Account> ICICIInfo) throws ownerException {
//    return super.getAccount(ownerName,ICICIInfo);
//  }
//
//  @Override
//  public void updateAccount(String ownerName, Account account,Map<String, Account> ICICIInfo) throws ownerException {
//    super.updateAccount(ownerName, account,ICICIInfo);
//  }
//
//  @Override
//  public BigDecimal get_Balance(String ownerName,Map<String, Account> ICICIInfo) throws ownerException {
//    return super.get_Balance(ownerName,ICICIInfo);
//  }
//
//  @Override
//  public BigDecimal deposit(String ownerName, BigDecimal amount,Map<String, Account> ICICIInfo) throws ownerException {
//    return super.deposit(ownerName, amount,ICICIInfo);
//  }
//
//  @Override
//  public void withdraw(BigDecimal amount, String ownerName,Map<String, Account> ICICIInfo) throws ownerException, InSufficientBalance {
//    super.withdraw(amount, ownerName,ICICIInfo);
//  }
//
//  @Override
//  public boolean checkOwner(String ownerName,Map<String, Account> ICICIInfo) {
//    return super.checkOwner(ownerName,ICICIInfo);
//  }
//
//  @Override
//  public boolean checkBalance(BigDecimal amount, String ownerName,Map<String, Account> ICICIInfo) throws ownerException {
//    return super.checkBalance(amount, ownerName,ICICIInfo);
//  }

}
