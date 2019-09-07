package com.example.hldbs.services;

import com.example.hldbs.dao.AccountDAO;
import com.example.hldbs.webentity.PropertiesRequest;
import com.example.hldbs.webentity.Property;

import java.util.List;

public class AccountService {

    public boolean isUserEligibleForPreApprovedLoan(String customerId) {
        return new AccountDAO().isUserEligibleForPreApprovedLoan(customerId);
    }

    public Double getEmiForAmount(Double amount, int tenure) {
        return new AccountDAO().getEMIforAmount(amount, tenure);
    }

    public List<Property> getProperties(PropertiesRequest prop) {
        return new AccountDAO().getProperties(prop);
    }
}
