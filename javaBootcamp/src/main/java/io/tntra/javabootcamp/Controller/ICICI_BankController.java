package io.tntra.javabootcamp.Controller;

import io.tntra.javabootcamp.Model.Account;
import io.tntra.javabootcamp.exception.InSufficientBalance;
import io.tntra.javabootcamp.exception.ownerException;
import io.tntra.javabootcamp.services.ICICI_BankService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;


@RestController
public class ICICI_BankController {

  ICICI_BankService icici_bankService;

  public ICICI_BankController(ICICI_BankService icici_bankService) {
    this.icici_bankService = icici_bankService;
  }


//  BigDecimal amount;

  @GetMapping("/ICICI/account/{ownerName}")
  public ResponseEntity<Object> getAccount(@PathVariable("ownerName") String ownerName) throws ownerException {
    try {
      return new ResponseEntity<>(icici_bankService.getAccount(ownerName), HttpStatus.OK);
    } catch (ownerException e) {
      throw new ownerException("Invalid owner Name");
    }
  }

  @GetMapping("/ICICI/getAccount")
  public ResponseEntity<Object> get_Account(String ownerName) throws ownerException {
    try {
      return new ResponseEntity<>(icici_bankService.get_Account(), HttpStatus.OK);
    } catch (ownerException e) {
      throw new ownerException("Invalid owner Name");
    }
  }

  @RequestMapping(value = "/ICICI/account/{ownerName}", method = RequestMethod.PUT)
  public ResponseEntity<Object> updateAccount(@PathVariable("ownerName") String ownerName, @RequestBody Account account) throws ownerException {
    try {
      icici_bankService.updateAccount(ownerName, account);
      return new ResponseEntity<>("Account is updated successfully ", HttpStatus.OK);
    } catch (ownerException e) {
      throw new ownerException("Invalid owner Name");
    }

  }

  @RequestMapping(value = "/ICICI/account/{ownerName}", method = RequestMethod.DELETE)
  public ResponseEntity<Object> deleteAccount(@PathVariable("ownerName") String ownerName) throws ownerException {
    try {
      icici_bankService.deleteAccount(ownerName);
      return new ResponseEntity<>("Account is Delete successfully", HttpStatus.OK);
    } catch (ownerException e) {
      throw new ownerException("Invalid owner Name");
    }
  }

  @RequestMapping(value = "/ICICI/account", method = RequestMethod.POST)
  public ResponseEntity<Object> createAccount(@RequestBody Account account) throws ownerException {
    icici_bankService.createAccount(account);
    return new ResponseEntity<>("Account is created successfully", HttpStatus.CREATED);
  }

  @RequestMapping(value = "/ICICI/getAccountBalance/{ownerName}", method = RequestMethod.GET)
  public ResponseEntity<Object> get_Balance(@PathVariable("ownerName") String ownerName) throws ownerException {
    try {
      return new ResponseEntity<>(ownerName + " Account Balance:" + icici_bankService.get_Balance(ownerName), HttpStatus.OK);
    } catch (ownerException e) {
      throw new ownerException("Invalid owner Name");
    }
  }

  @RequestMapping(value = "/ICICI/deposit/{ownerName}/{amount}", method = RequestMethod.PATCH)
  public ResponseEntity<Object> deposit(@PathVariable("amount") BigDecimal amount, @PathVariable String ownerName) throws ownerException {
    try {
      icici_bankService.deposit(ownerName, amount);
      return new ResponseEntity<>("Deposit successfully", HttpStatus.OK);
    } catch (ownerException e) {
      throw new ownerException("Invalid owner Name");
    }
  }
  @RequestMapping(value = "/ICICI/withdraw/{ownerName}/{amount}", method = RequestMethod.PATCH)
  public ResponseEntity<Object> withdraw(@PathVariable("amount") BigDecimal amount, @PathVariable String ownerName) throws ownerException ,InSufficientBalance{
    try {
      icici_bankService.withdraw(amount, ownerName);
      return new ResponseEntity<>("Withdraw successfully", HttpStatus.OK);
    } catch (ownerException e) {
      throw new ownerException("Invalid owner Name");
    }
  }
}
