package io.tntra.javabootcamp.Controller;

import io.tntra.javabootcamp.Model.Account;
import io.tntra.javabootcamp.services.accountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class HDFC_BankController {
  @Autowired
  io.tntra.javabootcamp.services.accountService accountService;
  @GetMapping("/account")
  public ResponseEntity<Object> getAccount(){
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
}
