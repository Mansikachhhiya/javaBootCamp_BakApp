package services;

import Account_type.Account_type;
import Model.Account;
import exception.InSufficientBalance;
import exception.miniBalanceExcepction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class accountModel implements BankAccount{
  private static Map<String, Account> accountInfo = new HashMap<>();
  static {
    Account MansiAccount = new Account();
    MansiAccount.setOwnerName("Mansi");
    MansiAccount.setBalance(BigDecimal.valueOf(10000));
    MansiAccount.setAccount_type(Account_type.CURRENT);
    accountInfo.put(MansiAccount.getOwnerName(),MansiAccount);
    Account UdayAccount = new Account();
    UdayAccount.setOwnerName("Uday");
    UdayAccount.setBalance(BigDecimal.valueOf(20000));
    UdayAccount.setAccount_type(Account_type.SAVING);
    accountInfo.put(UdayAccount.getOwnerName(),UdayAccount);
  }
  @Override
  public void createAccount(Account account) {
      accountInfo.put(account.getOwnerName(),account);
  }

  @Override
  public void deleteAccount(String ownerName) {
     accountInfo.remove(ownerName);
  }

  @Override
  public Collection<Account> getAccount() {
    return accountInfo.values();
  }

  @Override
  public void updateAccount(String ownerName, BigDecimal balance, Account_type account_type,Account account) {
     accountInfo.remove(ownerName);
     account.setOwnerName(ownerName);
     accountInfo.put(ownerName,account);
  }
  private String ownerName;
  private BigDecimal balance;
  private  Account_type account_type;

  private BigDecimal miniBalance = new BigDecimal(0);



  private BigDecimal overDraftLimit = new BigDecimal(0);
  protected accountModel(String ownerName, BigDecimal balance, Account_type account_type) throws miniBalanceExcepction {
    this.ownerName=ownerName;
    try{
      if(balance.compareTo(miniBalance)>=0){
        this.balance = balance;
      }
      else {
        throw new miniBalanceExcepction("Minimum Balance Required ");
      }
    } catch (miniBalanceExcepction e) {
      e.getMessage();
      throw new miniBalanceExcepction("Minimum Balance Required ");
    }
    this.account_type = account_type;

  }
  protected void  print_details(){
    System.out.println("owner Name: "+ownerName);
    System.out.println("Current Balance :"+balance);
    System.out.println("Account Type: "+account_type);
  }
  //Deposit Function
  @Override
  public BigDecimal deposit(BigDecimal amount){
    this.balance = this.balance.add(amount);

    return balance;
  }




  //Withdraw Function
  @Override
  public void withdraw(BigDecimal amount) throws InSufficientBalance {
    try {
      if (checkBalance(amount)) {
        this.balance = this.balance.subtract(amount);
      }else {
        throw new InSufficientBalance("Insufficient Balance in your Account");
      }
    }catch (InSufficientBalance e ){
      //System.out.println(e.getMessage());
      throw new InSufficientBalance("Insufficient Balance in your Account");
    }
  }

  // Get method for ownerName
  public String getOwnerName() {
    return ownerName;
  }
  public boolean checkBalance(BigDecimal amount) {
    if (this.account_type == Account_type.CURRENT) {
      BigDecimal overDraft = overDraftLimit .multiply(this.balance);
      BigDecimal Temp_balance = this.balance.add(overDraft);
      return Temp_balance.compareTo(amount)>=0;

    } else {
      return this.balance.compareTo(amount) >= 0;
    }
  }
  //set method for ownerName
  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }
  // get method for balance
  public BigDecimal getBalance() {
    return balance;
  }
  //set method for balance
  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }
  //get method for mini-balance
  public BigDecimal getMiniBalance() {
    return miniBalance;
  }
  // set method for mini-balance
  public void setMiniBalance(BigDecimal miniBalance) {
    this.miniBalance = miniBalance;
  }
  //get method for over-Draft-limit
  public BigDecimal getOverDraftLimit() {
    return overDraftLimit;
  }
  //set method for over-Draft-limit
  public void setOverDraftLimit(BigDecimal overDraftLimit) {
    this.overDraftLimit = overDraftLimit;
  }


}

