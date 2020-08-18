package com.example.demo.services;


import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean isValidUser(String name,String password){
        return (name.equals("subbu")&&password.equals("12345"));
    }
}
