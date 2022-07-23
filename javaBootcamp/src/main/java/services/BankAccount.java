package services;

import Account_type.Account_type;
import Model.Account;
import exception.InSufficientBalance;

import java.math.BigDecimal;
import java.util.Collection;

public interface BankAccount {
  public abstract void createAccount(Account account);
  public abstract void updateAccount(String ownerName, BigDecimal balance, Account_type account_type,Account account);
  public abstract void deleteAccount(String ownerName);
  public abstract Collection<Account> getAccount();
  public abstract void withdraw(BigDecimal amount) throws InSufficientBalance;
  public abstract BigDecimal deposit(BigDecimal amount);
  public abstract boolean checkBalance(BigDecimal amount);
}
