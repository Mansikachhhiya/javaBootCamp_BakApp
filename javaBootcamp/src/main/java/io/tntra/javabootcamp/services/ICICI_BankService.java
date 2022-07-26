package io.tntra.javabootcamp.services;

import io.tntra.javabootcamp.Account_type.Account_type;
import io.tntra.javabootcamp.Model.Account;
import io.tntra.javabootcamp.exception.InSufficientBalance;
import io.tntra.javabootcamp.exception.miniBalanceExcepction;
import io.tntra.javabootcamp.exception.ownerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;

@Service
public class ICICI_BankService extends accountService implements BankAccount{
//  accountService accountService;
//  public ICICI_BankService(accountService accountService) {
//    this.accountService = accountService;
//  }

  @Override
  public void createAccount(Account account) {
    super.createAccount(account);
  }

  @Override
  public void deleteAccount(String ownerName) throws ownerException {
    super.deleteAccount(ownerName);
  }

  @Override
  public Collection<Account> get_Account() throws ownerException {
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
  public void withdraw(BigDecimal amount, String ownerName) throws ownerException, InSufficientBalance {
    super.withdraw(amount, ownerName);
  }

  @Override
  public boolean checkOwner(String ownerName) {
    return super.checkOwner(ownerName);
  }

  @Override
  public boolean checkBalance(BigDecimal amount, String ownerName) throws ownerException {
    return super.checkBalance(amount, ownerName);
  }


}
