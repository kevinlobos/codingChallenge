package com.CodingChallenge;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest
class ControllerTest {
    // Valid username, password and IP -- Cranbrook, Canada	
    private final Registration user1 = new Registration("username1", "Testing123#", "23.16.0.0");

    // Valid username, password and IP -- Vancouver, Canada 23.83.208.0	
    private final Registration user2 = new Registration("username1", "Testing123#", "23.83.208.0");
    
    //Valid username password and IP -- Alberta, Canada 23.29.192.0
    private final Registration user3 = new Registration("username1", "Testing123#", "23.29.192.0");

    // Valid username and password, invalid IP -- Fremont California 23.83.224.0
    private final Registration user4 = new Registration("username1", "Testing123#", "23.83.224.0");

    // Valid password and IP, invalid username -- ""
    private final Registration user5 = new Registration("", "Testing123#", "23.16.0.0");

    // Valid username and IP, invalid password -- password
    private final Registration user6 = new Registration("username1", "password#", "23.16.0.0");

    // Valid username and IP, invalid password -- password123
    private final Registration user7 = new Registration("username1", "password123", "23.16.0.0");

    // Valid username and IP, invalid password -- Password123
    private final Registration user8 = new Registration("username1", "Password123", "23.16.0.0");

    // Valid username and IP, invalid password -- password123#
    private final Registration user9 = new Registration("username1", "password123#", "23.16.0.0");

    // valid username and IP, invalid password -- Password#
    private final Registration user10 = new Registration("username1", "Password#", "23.16.0.0");

    // invalid username, password, and IP
    private final Registration user11 = new Registration("", "password", "23.83.224.0");


    @Autowired
    private MockMvc mvc;

    @Test
    void test() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.post("/register");
        MvcResult result = mvc.perform(request).andReturn();
    }
}
