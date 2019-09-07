package com.example.hldbs.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/users")
    public String welcomeUser(@RequestParam(name = "name", required = false, defaultValue = "Java Fan") String name) {
        return "Tanmay";
    }
}
