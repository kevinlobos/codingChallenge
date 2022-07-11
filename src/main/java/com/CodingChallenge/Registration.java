package com.CodingChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;

public class Registration {
    private final String username, password, ip;
    
    public Registration(String username, String password, String ip){
        this.username = username;
        this.password = password;
        this.ip = ip;
    }

    public String[] getGeoLocation(){
        // use ip to determine the geolocation, return string array with country code and city
        String[] retVal = {"",""};
        StringBuffer result = new StringBuffer();
        String line;
        try{
            URL url = new URL("http://ip-api.com/json/"+ip);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);

            while((line = reader.readLine())!=null){
                result.append(line);
            }
            reader.close();

            JSONObject obj = new JSONObject(result.toString());
            String countryCode = obj.get("countryCode").toString();
            String city = obj.get("city").toString();
            retVal[0]=countryCode;
            retVal[1] = city;
        }catch(MalformedURLException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return retVal;
    }

    public boolean isEmpty(){
        // check if username or password is empty
        if(username.isEmpty() || password.isEmpty() || username  == "" || password == "")return true;
        return false;
    }

    public boolean isValidPassword(){
        // Use regex to check is password is valid
        // at least 8 characters
        // at least 1 number
        // at least 1 capital letter
        // at least one special character -- _#$%
        String regex = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$%_])[a-zA-Z\\d#$%_]{8,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public Map<String,String> registerUser(){
        String status="", message="";
        // Return JSON Object with status and message
        if(isEmpty()){
            // Return status "failed" with message "All fields must be filled out"
            status="failed";
            message+="**All fields must be filled out ";
        }
        if(!isValidPassword()){
            // Return status "failed" with message "Password does not meet criteria"
            status="failed";
            message+="**Password does not meet criteria ";
        }
        if(getGeoLocation()[0].equals("CA") == false){
            // Return status "failed" with message "Must be in Canada to be eligable for registration"
            status="failed";
            message+="**Must be in Canada to be eligable for registration ";
        }
        if(message == ""){
            // Return status "success" with message "Account has been created for user ${name} from ${city}"
            status="sucessful";
            message="Account has been created for user "+ username+ " from " + getGeoLocation()[1];
        }
        JSONObject obj = new JSONObject();
        obj.append("status", status);
        obj.append("message", message);

        Map<String,String> json = new HashMap<>();
        json.put("status", status);
        json.put("message",message);
        
        return json;

    }
}
