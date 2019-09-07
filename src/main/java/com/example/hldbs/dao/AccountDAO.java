package com.example.hldbs.dao;

import com.example.hldbs.utils.Utility;
import com.example.hldbs.webentity.PropertiesRequest;
import com.example.hldbs.webentity.Property;
import org.springframework.stereotype.Component;

import java.util.List;

public class AccountDAO {

    public boolean isUserEligibleForPreApprovedLoan(String customerId) {
        if (Utility.isNullOrEmpty(customerId)) return false;
        //TODO
        return true;
    }

    public Double getEMIforAmount(Double amount, int tenure) {
        //TODO
        return 100000d;
    }

    public List<Property> getProperties(PropertiesRequest prop) {
        return null;
    }
}