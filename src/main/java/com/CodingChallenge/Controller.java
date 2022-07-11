package com.CodingChallenge;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    @PostMapping("/register")
    public Object greeting(@RequestParam(value="username") String username, @RequestParam(value="password") String password, @RequestParam(value="ip") String ip){
        return new Registration(username, password, ip).registerUser();
    }
}
