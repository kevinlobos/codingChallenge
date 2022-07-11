package com.CodingChallenge;

public class Registration {
    private final String username, password, ip;
    
    public Registration(String username, String password, String ip){
        this.username = username;
        this.password = password;
        this.ip = ip;
    }

    public String[] getGeoLocation(){
        // use ip to determine the geolocation, return string array with country code and city
        String[] retVal = {};
        return retVal;
    }

    public boolean isEmpty(){
        // check if username or password is empty
        return true;
    }

    public boolean isValidPassword(){
        // Use regex to check is password is valid
        // at least 8 characters
        // at least 1 number
        // at least 1 capital letter
        // at least one special character -- _#$%
        return true;
    }

    public Object registerUser(){
        String status="", message="";
        // Return JSON Object with status and message
        if(isEmpty()){
            // Return status "failed" with message "All fields must be filled out"
        }
        if(isValidPassword()){
            // Return status "failed" with message "Password does not meet criteria"
        }
        if(getGeoLocation()[0] != "CA"){
            // Return status "failed" with message "Must be in Canada to be eligable for registration"
        }
        if(message == ""){
            // Return status "success" with message "Account has been created for user ${name} from ${city}"
        }
        
        return new Object();

    }
}
