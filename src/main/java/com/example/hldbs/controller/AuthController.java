package com.example.hldbs.controller;

import com.example.hldbs.services.AuthService;
import com.example.hldbs.utils.Utility;
import com.example.hldbs.webentity.GenericResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/user/{id}")
    public GenericResponse authenticate(@PathVariable(value= "id") String name) {
        AuthService service = new AuthService();
        GenericResponse response = new GenericResponse();
        if(!Utility.isNullOrEmpty(name) && service.isUserAuthentic(name)) {
            response.setMessage("Success");
            response.setSuccess(true);
        } else {
            response.setSuccess(false);
            response.setMessage("Failed");
        }
        return response;
    }
}
