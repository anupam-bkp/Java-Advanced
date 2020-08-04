package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean validateUser(String userid, String password) {

        // in28minutes, dummy

        return userid.equalsIgnoreCase("anupam")

                && password.equalsIgnoreCase("123");

    }

}
