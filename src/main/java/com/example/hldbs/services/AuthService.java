package com.example.hldbs.services;

import com.example.hldbs.dao.AuthDao;

public class AuthService {

    public boolean isUserAuthentic(String customerId) {
        AuthDao dao = new AuthDao();
        return dao.authenticateUser(customerId);
    }
}
