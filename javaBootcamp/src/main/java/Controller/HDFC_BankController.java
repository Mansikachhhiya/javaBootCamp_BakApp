package Controller;

import Account_type.Account_type;
import services.BankAccount;
import services.accountModel;
import exception.InSufficientBalance;
import exception.miniBalanceExcepction;

import java.math.BigDecimal;

public class HDFC_BankController extends accountModel implements BankAccount {

  public HDFC_BankController(String ownerName, BigDecimal balance, Account_type account_type) throws miniBalanceExcepction {
    super(ownerName, balance,account_type);
    super.setMiniBalance(BigDecimal.valueOf(5000));
    super.setOverDraftLimit(BigDecimal.valueOf(0.40));
  }

  @Override
  public void print_details() {
    System.out.println(getOwnerName()+" HDFC Bank Details");
    super.print_details();
  }


  @Override
  public void withdraw(BigDecimal amount) throws InSufficientBalance {
    try {
      super.withdraw(amount);
      System.out.println("Withdraw from HDFC Bank");
      System.out.println("Hello, "+getOwnerName()+"\nAfter Withdraw Total Amount in Your HDFC Bank : " + this.getBalance() + " Rs");
    }catch (InSufficientBalance e){
      //System.out.println(e.getMessage());
      throw new InSufficientBalance("Insufficient Balance in your Account");
    }
  }

  @Override
  public BigDecimal deposit(BigDecimal amount) {
    super.deposit(amount);
    System.out.println("Deposit to HDFC Bank");
    System.out.println("Hello, "+getOwnerName()+"\nAfter deposit Total Amount in Your HDFC Bank : "+this.getBalance()+" Rs");
    return amount;
  }
}

