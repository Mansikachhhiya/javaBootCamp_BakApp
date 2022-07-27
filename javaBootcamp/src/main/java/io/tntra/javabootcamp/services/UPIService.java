package io.tntra.javabootcamp.services;

import io.tntra.javabootcamp.Account_type.Account_type;
import io.tntra.javabootcamp.exception.InSufficientBalance;
import io.tntra.javabootcamp.exception.ownerException;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class UPIService {
  @Autowired
  accountService accountService;
  private final int upi_id;
  private Account_type account_type;

  public UPIService(int upi_id,accountService accountService) {
    this.upi_id = upi_id;
    this.accountService = accountService;
  }
  void transfer(BigDecimal amount,String ownerName,UPIService destination)throws ownerException, InSufficientBalance{
    try{
     accountService.withdraw(amount,ownerName);
     receive(amount,ownerName,destination);

    }catch (InSufficientBalance e) {
      throw new InSufficientBalance("Insufficient Balance in your Account");
    }
  }
  public  BigDecimal receive(BigDecimal amount ,String ownerName, UPIService destination) throws ownerException {
    return destination.accountService.deposit(ownerName, amount);
  }

}
