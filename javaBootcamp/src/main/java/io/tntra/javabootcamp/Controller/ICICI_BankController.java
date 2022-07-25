package io.tntra.javabootcamp.Controller;

import io.tntra.javabootcamp.Model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.tntra.javabootcamp.services.accountService;

@RestController
public class ICICI_BankController {
  @Autowired
  accountService accountService;
  @GetMapping("/account/{ownerName}")
  public ResponseEntity<Object> getAccount(){
    return new ResponseEntity<>(accountService.getAccount(), HttpStatus.OK);
  }
  @GetMapping("/getaccount")
  public ResponseEntity<Object> get_Account(){
    return new ResponseEntity<>(accountService.getAccount(), HttpStatus.OK);
  }
  @RequestMapping(value = "/account/{ownerName}",method = RequestMethod.PUT)
  public ResponseEntity<Object> updateAccount(@PathVariable("ownerName") String ownerName, @RequestBody Account account){
  accountService.updateAccount(ownerName,account);
  return new ResponseEntity<>("Account is updated successfully ",HttpStatus.OK);
  }
  @RequestMapping(value = "/account/{ownerName}",method = RequestMethod.DELETE)
  public ResponseEntity<Object> deleteAccount(@PathVariable("ownerName") String ownerName){
    accountService.deleteAccount(ownerName);
    return new ResponseEntity<>("Account is Delete successfully",HttpStatus.OK);
  }
  @RequestMapping(value = "/account",method = RequestMethod.POST)
  public ResponseEntity<Object> createAccount(@RequestBody Account account){
    accountService.createAccount(account);
    return new ResponseEntity<>("Account is created successfully",HttpStatus.CREATED);
  }
  @RequestMapping(value = "/getAccountBalance/{ownerName}",method = RequestMethod.GET)
  public ResponseEntity<Object> get_Balance(@PathVariable("ownerName") String ownerName){
    return new ResponseEntity<>(ownerName+" Account Balance:"+accountService.get_Balance(ownerName), HttpStatus.OK);
  }
}
//public class ICICI_BankController extends accountModel implements BankAccount {
//
//
//  public ICICI_BankController(String ownerName, BigDecimal balance, Account_type account_type) throws miniBalanceExcepction, InSufficientBalance {
//
//    super(ownerName, balance,account_type);
//    super.setMiniBalance(BigDecimal.valueOf(5000));
//    super.setOverDraftLimit(BigDecimal.valueOf(.20));
//
//  }
//
//  @Override
//  public void print_details() {
//    System.out.println(getOwnerName()+" ICICI Bank Details");
//    super.print_details();
//  }
//
//
//  @Override
//  public void withdraw(BigDecimal amount) throws InSufficientBalance {
//    try {
//      super.withdraw(amount);
//      System.out.println("Withdraw from ICICI Bank");
//      System.out.println("Hello, "+getOwnerName()+"\nAfter Withdraw Total Amount  ICICI Bank : " + this.getBalance() + " Rs");
//    }catch (InSufficientBalance e){
//      //System.out.println(e.getMessage());
//      throw new InSufficientBalance("Insufficient Balance in your Account");
//    }
//  }
//
//  @Override
//  public BigDecimal deposit(BigDecimal amount) {
//    super.deposit(amount);
//    System.out.println("Deposit to ICICI Bank");
//    System.out.println("Hello, "+getOwnerName()+"\nAfter deposit Total Amount in Your ICICI Bank: "+this.getBalance()+" Rs");
//    return amount;
//  }
//
//}
//
