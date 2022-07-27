package io.tntra.javabootcamp.Controller;

import io.tntra.javabootcamp.Model.Account;

import io.tntra.javabootcamp.exception.miniBalanceExcepction;
import io.tntra.javabootcamp.exception.ownerException;
import io.tntra.javabootcamp.services.HDFC_BankService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@RestController
public class HDFC_BankController {
  final
  HDFC_BankService hdfc_bankService;

  public HDFC_BankController(HDFC_BankService hdfc_bankService) {
    this.hdfc_bankService = hdfc_bankService;
  }


  @GetMapping("/HDFC/{ownerName}")
  public ResponseEntity<Object> getAccount(@PathVariable("ownerName") String ownerName) {
    try {
      return new ResponseEntity<>(hdfc_bankService.getAccount(ownerName), HttpStatus.OK);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return new ResponseEntity<>("Given account owner does not exist",HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/HDFC/getAccount")
  public ResponseEntity<Object> get_Account() {
      return new ResponseEntity<>(hdfc_bankService.get_Account(), HttpStatus.OK);

  }

  @RequestMapping(value = "/HDFC/account/{ownerName}", method = RequestMethod.PUT)
  public ResponseEntity<Object> updateAccount(@PathVariable("ownerName") String ownerName, @RequestBody Account account) {
    try {
      hdfc_bankService.updateAccount(ownerName, account);
      return new ResponseEntity<>("Account is updated successfully ", HttpStatus.OK);
    } catch (Exception e) {
    System.out.println(e.getMessage());
    return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
    }

  }

  @RequestMapping(value = "/HDFC/account/{ownerName}", method = RequestMethod.DELETE)
  public ResponseEntity<Object> deleteAccount(@PathVariable("ownerName") String ownerName){
    try {
      hdfc_bankService.deleteAccount(ownerName);
      return new ResponseEntity<>("Account is Delete successfully", HttpStatus.OK);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
    }
  }@RequestMapping(value = "/HDFC/account", method = RequestMethod.POST)
  public ResponseEntity<Object> createAccount(@RequestBody Account account) {
    try {
      hdfc_bankService.createAccount(account);
      return new ResponseEntity<>("Account is created in HDFC successfully", HttpStatus.CREATED);
    }catch (miniBalanceExcepction e){
      System.out.println(e.getMessage());
      return new ResponseEntity<>("Minimum balance for HDFC is 1000", HttpStatus.NOT_ACCEPTABLE);
    }
  }

  @RequestMapping(value = "/HDFC/Balance/{ownerName}", method = RequestMethod.GET)
  public ResponseEntity<Object> get_Balance(@PathVariable("ownerName") String ownerName) {
    try {
      return new ResponseEntity<>(ownerName + " Account Balance:" + hdfc_bankService.get_Balance(ownerName), HttpStatus.OK);
    } catch (ownerException e) {
      System.out.println(e.getMessage());
      return new ResponseEntity<>("Given account owner does not exist",HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(value = "/HDFC/deposit/{ownerName}/{amount}", method = RequestMethod.PATCH)
  public ResponseEntity<Object> deposit(@PathVariable("amount") BigDecimal amount, @PathVariable String ownerName)  {
    try {
      hdfc_bankService.deposit(ownerName, amount);
      return new ResponseEntity<>("Amount Deposit successfully from HDFC", HttpStatus.OK);
    } catch (ownerException e) {
      System.out.println(e.getMessage());
      return new ResponseEntity<>("Given account owner does not exist",HttpStatus.CONFLICT);
    }
  }
  @RequestMapping(value = "/HDFC/withdraw/{ownerName}/{amount}", method = RequestMethod.PATCH)
  public ResponseEntity<Object> withdraw(@PathVariable("amount") BigDecimal amount, @PathVariable String ownerName) {
    try {
      hdfc_bankService.withdraw(amount, ownerName);
      return new ResponseEntity<>("Withdraw successfully", HttpStatus.OK);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
    }
  }
}
