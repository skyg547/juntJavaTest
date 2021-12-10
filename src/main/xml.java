package main;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class xml {

    public static void main(String[] args) {
        try{
            
    
        
            URL url = new URL("http://www.google.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            if (responseCode == 200) {
                System.out.println("Success");
            } else {
                System.out.println("Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    
}
