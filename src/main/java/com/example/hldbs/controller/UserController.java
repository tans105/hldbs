package com.example.hldbs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.hldbs.dao.AccountDAO;


@RestController
public class MainController {
        
    @Autowired
    public AccountDAO accountDao;

    @GetMapping("/getApprovedLoanIndicator")
    public boolean getApprovedLoanIndicator(@RequestParam(customerId = "customerId", required = true, defaultValue = "") String customerId) 
    {
        boolean isCustomerEligibleForLoan = false;

        isCustomerEligibleForLoan = accountDao.isUserEligibleForPreApprovedLoan(customerId);
        
        return isCustomerEligibleForLoan;
    }

    @GetMapping("/getAccountDetails")
    public String getAccountDetails(@RequestParam(customerId = "customerId", required = true, defaultValue = "") String customerId) 
    {
        AccountVO customerAccountDetails = new AccountVO();

        customerAccountDetails = accountDao.getAccountDetails(customerId);
        
        return customerAccountDetails;
    }
}
