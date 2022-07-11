package com.CodingChallenge;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    @PostMapping("/register")
    public Map<String,String> greeting(@RequestParam(value="username") String username, @RequestParam(value="password") String password, @RequestParam(value="ip") String ip){
        return new Registration(username, password, ip).registerUser();
    }
    @PostMapping("/locationTest")
    public String[] locationTest(@RequestParam(value="username") String username, @RequestParam(value="password") String password, @RequestParam(value="ip") String ip){
        return new Registration(username,password,ip).getGeoLocation();
    }
    @PostMapping("/passwordTest")
    public boolean passwordTest(@RequestParam(value="username") String username, @RequestParam(value="password") String password, @RequestParam(value="ip") String ip){
        return new Registration(username,password,ip).isValidPassword();
    }
}
