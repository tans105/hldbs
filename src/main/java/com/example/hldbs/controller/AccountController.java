package com.example.hldbs.controller;

import com.example.hldbs.services.AccountService;
import com.example.hldbs.webentity.EMI;
import com.example.hldbs.webentity.PropertiesRequest;
import com.example.hldbs.webentity.Property;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
public class AccountController {

    @GetMapping("/getApprovedLoanAmount/{userId}")
    public boolean getApprovedLoanIndicator(@PathVariable(value = "userId") String customerId) {
        boolean isCustomerEligibleForLoan = false;
        AccountService service = new AccountService();
        isCustomerEligibleForLoan = service.isUserEligibleForPreApprovedLoan(customerId);

        return isCustomerEligibleForLoan;
    }

    @PostMapping(path = "/getEMI", headers = "Accept=application/json")
    public Double getEMIForTenure(@RequestBody EMI emi) {
        return new AccountService().getEmiForAmount(emi.getAmount(), emi.getTenure());
    }

    @GetMapping("/properties/filter")
    public List<Property> getProperties(@RequestParam Optional<String> id, @RequestParam Optional<String> location) {
        PropertiesRequest prop = new PropertiesRequest();

        id.ifPresent(prop::setId);
        location.ifPresent(prop::setLocation);

        AccountService service = new AccountService();
        return service.getProperties(prop);
    }

}
