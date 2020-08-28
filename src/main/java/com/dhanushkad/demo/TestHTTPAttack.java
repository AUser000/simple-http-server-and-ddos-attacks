package com.dhanushkad.demo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TestHTTPAttack {
    public static void main(String args[]) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/hello");
        for(int i = 0; i < 50000; i++) {
            HttpURLConnection con = null;
            try {
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.getResponseCode();
                System.out.println(con.getResponseCode());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
