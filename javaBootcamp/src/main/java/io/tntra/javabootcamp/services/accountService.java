package io.tntra.javabootcamp.services;

import io.tntra.javabootcamp.Account_type.Account_type;
import io.tntra.javabootcamp.Model.Account;
import io.tntra.javabootcamp.exception.InSufficientBalance;
import io.tntra.javabootcamp.exception.miniBalanceExcepction;
import io.tntra.javabootcamp.exception.ownerException;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public abstract class accountService  implements BankAccount {

//  private static final Map<String, Account> ICICIInfo = new HashMap<>();
//  @Override
//  public void createAccount(Account account, Map<String, Account> accountInfo) {
//
//    accountInfo.put(account.getOwnerName(), account);
//  }
//
//  @Override
//  public void deleteAccount(String ownerName, Map<String, Account> accountInfo) throws ownerException {
//    if (checkOwner(ownerName,accountInfo)) {
//      accountInfo.remove(ownerName);
//    }
//  }
//
//  @Override
//  public Collection<Account> get_Account(Map<String, Account> accountInfo) throws ownerException {
//
//    return accountInfo.values();
//  }
//
//  @Override
//  public Account getAccount(String ownerName, Map<String, Account> accountInfo) throws ownerException {
//    return accountInfo.get(ownerName);
//
//  }
//
//  @Override
//  public void updateAccount(String ownerName, Account account, Map<String, Account> accountInfo) throws ownerException {
//    if (checkOwner(ownerName,accountInfo)) {
//      accountInfo.remove(ownerName);
//      account.setOwnerName(ownerName);
//      accountInfo.put(ownerName, account);
//    }
//  }
//
//  @Override
//  public BigDecimal get_Balance(String ownerName, Map<String, Account> accountInfo) throws ownerException {
//    if (checkOwner(ownerName,accountInfo)) {
//      return accountInfo.get(ownerName).getBalance();
//    }
//    return null;
//  }
//
//  //Deposit function
//  @Override
//  public BigDecimal deposit(String ownerName, BigDecimal amount, Map<String, Account> accountInfo) throws ownerException {
//    if (checkOwner(ownerName,accountInfo)) {
//      BigDecimal currentBalance = get_Balance(ownerName,accountInfo);
//      BigDecimal newBalance = currentBalance.add(amount);
//      accountInfo.get(ownerName).setBalance(newBalance);
//      return newBalance;
//    }
//    return null;
//  }
//
//  @Override
//  public void withdraw(BigDecimal amount, String ownerName, Map<String, Account> accountInfo) throws ownerException, InSufficientBalance {
//    try {
//      if (checkBalance(amount,ownerName,accountInfo)) {
//        BigDecimal currentBalance = get_Balance(ownerName,accountInfo);
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
//
//
////  public void withdraw(String ownerName, BigDecimal amount) throws ownerException,InSufficientBalance {
////    try {
////      if (checkBalance(amount)) {
////        BigDecimal currentBalance = get_Balance(ownerName);
////        BigDecimal balance = currentBalance.subtract(amount);
////        accountInfo.get(ownerName).setBalance(balance);
////      }else {
////        throw new InSufficientBalance("Insufficient Balance in your Account");
////      }
////    }catch (InSufficientBalance e ){
////      //System.out.println(e.getMessage());
////      throw new InSufficientBalance("Insufficient Balance in your Account");
////    }
////  }
//  public boolean checkOwner(String ownerName,Map<String, Account> accountInfo) {
//    return accountInfo.containsKey(ownerName);
//  }
//
//  public boolean checkBalance(BigDecimal amount, String ownerName,Map<String, Account> accountInfo) throws ownerException{
//      BigDecimal currentBalance = get_Balance(ownerName,accountInfo);
//
//    if (checkOwner(ownerName,accountInfo) && accountInfo.get(ownerName).getAccount_type() == Account_type.CURRENT) {
//      BigDecimal overDraftLimit = accountInfo.get(ownerName).getOverDraftLimit();
//      overDraftLimit = accountInfo.get(ownerName).setOverDraftLimit(BigDecimal.valueOf(0.40));
//      BigDecimal newoverDraftLimit = overDraftLimit.multiply(accountInfo.get(ownerName).getBalance());
//
//      BigDecimal newBalance = currentBalance.add(overDraftLimit);
//      return newBalance.compareTo(amount) >= 0;
//    }
//    return currentBalance.compareTo(amount)>=0;
//  }
 private final Map<String, Account> accountInfo = new HashMap<>();

  @Override
  public void createAccount(Account account) throws miniBalanceExcepction {

    accountInfo.put(account.getOwnerName(), account);
  }

  @Override
  public void deleteAccount(String ownerName) throws ownerException {
    if (checkOwner(ownerName)) {
      accountInfo.remove(ownerName);
    }
  }

  @Override
  public Collection<Account> get_Account() {

    return accountInfo.values();
  }

  @Override
  public Account getAccount(String ownerName) throws ownerException {
    if(checkOwner(ownerName)) {
      return accountInfo.get(ownerName);
    }
    throw new ownerException("The owner does not exit");
  }

  @Override
  public void updateAccount(String ownerName, Account account) throws ownerException {
    if (checkOwner(ownerName)) {
      accountInfo.remove(ownerName);
      account.setOwnerName(ownerName);
      accountInfo.put(ownerName, account);
    }
    throw new ownerException("The owner does not exit");
  }

  @Override
  public BigDecimal get_Balance(String ownerName) throws ownerException {
    if (checkOwner(ownerName)) {
      return accountInfo.get(ownerName).getBalance();
    }
    throw new ownerException("The owner does not exist");
  }

  //Deposit function
  public BigDecimal deposit(String ownerName, BigDecimal amount) throws ownerException {
    if (checkOwner(ownerName)) {
      BigDecimal currentBalance = get_Balance(ownerName);
      BigDecimal newBalance = currentBalance.add(amount);
      accountInfo.get(ownerName).setBalance(newBalance);
      return newBalance;
    }
    throw new ownerException("The owner does not exist");
  }

  @Override
  public BigDecimal withdraw(BigDecimal amount, String ownerName) throws ownerException, InSufficientBalance {
    if(checkOwner(ownerName)){
      if (checkBalance(amount,ownerName)) {
        BigDecimal currentBalance = get_Balance(ownerName);
        BigDecimal balance = currentBalance.subtract(amount);
        accountInfo.get(ownerName).setBalance(balance);
        return balance;
      }
        throw new InSufficientBalance("Insufficient Balance in your Account");
      }
   throw new ownerException("The owner does not exist");
  }

  public boolean checkOwner(String ownerName) {
    return accountInfo.containsKey(ownerName);
  }

  public boolean checkBalance(BigDecimal amount, String ownerName) throws ownerException{
    BigDecimal currentBalance = get_Balance(ownerName);

    if (checkOwner(ownerName) && accountInfo.get(ownerName).getAccount_type() == Account_type.CURRENT) {
      BigDecimal overDraftLimit = accountInfo.get(ownerName).setOverDraftLimit(BigDecimal.valueOf(0.40));
      BigDecimal newOverDraft = overDraftLimit.multiply(accountInfo.get(ownerName).getBalance());

      BigDecimal newBalance = currentBalance.add(newOverDraft);
      return newBalance.compareTo(amount) >= 0;
    }
    return currentBalance.compareTo(amount)>=0;
  }
}
