package io.tntra.javabootcamp.services;

import io.tntra.javabootcamp.Account_type.Account_type;
import io.tntra.javabootcamp.Model.Account;
import io.tntra.javabootcamp.exception.InSufficientBalance;
import io.tntra.javabootcamp.exception.miniBalanceExcepction;
import io.tntra.javabootcamp.exception.ownerException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public abstract class accountService  implements BankAccount {
  private static final Map<String, Account> accountInfo = new HashMap<>();

  @Override
  public void createAccount(Account account) {

    accountInfo.put(account.getOwnerName(), account);
  }

  @Override
  public void deleteAccount(String ownerName) throws ownerException {
    if (checkOwner(ownerName)) {
      accountInfo.remove(ownerName);
    }
  }

  @Override
  public Collection<Account> get_Account() throws ownerException {

    return accountInfo.values();
  }

  @Override
  public Account getAccount(String ownerName) throws ownerException {
    return accountInfo.get(ownerName);

  }

  @Override
  public void updateAccount(String ownerName, Account account) throws ownerException {
    if (checkOwner(ownerName)) {
      accountInfo.remove(ownerName);
      account.setOwnerName(ownerName);
      accountInfo.put(ownerName, account);
    }
  }

  @Override
  public BigDecimal get_Balance(String ownerName) throws ownerException {
    if (checkOwner(ownerName)) {
      return accountInfo.get(ownerName).getBalance();
    }
    return null;
  }

  //Deposit function
  public BigDecimal deposit(String ownerName, BigDecimal amount) throws ownerException {
    if (checkOwner(ownerName)) {
      BigDecimal currentBalance = get_Balance(ownerName);
      BigDecimal newBalance = currentBalance.add(amount);
      accountInfo.get(ownerName).setBalance(newBalance);
      return newBalance;
    }
    return null;
  }

  @Override
  public void withdraw(BigDecimal amount, String ownerName) throws ownerException, InSufficientBalance {
    try {
      if (checkBalance(amount,ownerName)) {
        BigDecimal currentBalance = get_Balance(ownerName);
        BigDecimal balance = currentBalance.subtract(amount);
        accountInfo.get(ownerName).setBalance(balance);
      }else {
        throw new InSufficientBalance("Insufficient Balance in your Account");
      }
    }catch (InSufficientBalance e ){
      //System.out.println(e.getMessage());
      throw new InSufficientBalance("Insufficient Balance in your Account");
    }
  }


//  public void withdraw(String ownerName, BigDecimal amount) throws ownerException,InSufficientBalance {
//    try {
//      if (checkBalance(amount)) {
//        BigDecimal currentBalance = get_Balance(ownerName);
//        BigDecimal balance = currentBalance.subtract(amount);
//        accountInfo.get(ownerName).setBalance(balance);
//      }else {
//        throw new InSufficientBalance("Insufficient Balance in your Account");
//      }
//    }catch (InSufficientBalance e ){
//      //System.out.println(e.getMessage());
//      throw new InSufficientBalance("Insufficient Balance in your Account");
//    }
//  }
  public boolean checkOwner(String ownerName) {
    return accountInfo.containsKey(ownerName);
  }

  public boolean checkBalance(BigDecimal amount, String ownerName) throws ownerException{
      BigDecimal currentBalance = get_Balance(ownerName);

    if (checkOwner(ownerName) && accountInfo.get(ownerName).getAccount_type() == Account_type.CURRENT) {
      BigDecimal overDraftLimit = accountInfo.get(ownerName).getOverDraftLimit();
      overDraftLimit = accountInfo.get(ownerName).setOverDraftLimit(BigDecimal.valueOf(0.40));
      BigDecimal newoverDraftLimit = overDraftLimit.multiply(accountInfo.get(ownerName).getBalance());

      BigDecimal newBalance = currentBalance.add(overDraftLimit);
      return newBalance.compareTo(amount) >= 0;
    }
    return currentBalance.compareTo(amount)>=0;
  }
}
