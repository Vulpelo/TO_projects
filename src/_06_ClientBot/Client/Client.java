package _06_ClientBot.Client;

import _06_ClientBot.Bot.State.Idle;
import _06_ClientBot.Bot.State.Listen;
import _06_ClientBot.Bot.State.Screenshot;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client implements Runnable {
    private ClientThread client;

    private String hostName;
    private int port;

    private OutputStream out;
    private InputStream in;

    public Client(String hostName, int port) {
        this.hostName = hostName;
        this.port = port;
    }

    void readCommand(String command) {
        switch (command.toLowerCase()) {
            case "listen":
                client.newState(new Listen(out));
                break;
            case "ss":
                client.newState(new Screenshot(out));
                break;
            case "idle":
                client.newState(new Idle());
                break;
        }
    }

    @Override
    public void run() {
        String inputLine;
        try {
            Scanner sc = new Scanner(System.in);

            // creating client
            Socket clientSocket = new Socket(hostName, port);

            out = clientSocket.getOutputStream();
            in = clientSocket.getInputStream();

            // creating client 'brain'
            client = new ClientThread(out);
            client.start();

            byte[] bytes = recive();
            // listening from server, getting data from server
            while ((bytes) != null) {
                String str = new String(bytes, StandardCharsets.UTF_8);
                System.out.println("Got Command: " + str);

                // end client if exit
                if (str.equalsIgnoreCase("exit")) {
                    break;
                }
                readCommand(str);

                bytes = recive();
            }

            sc.close();
            client.end();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    private byte[] recive() {
        try {
            // getting size
            byte[] sizeAr = new byte[4];
            in.read(sizeAr);
            int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();

            // getting data
            byte[] data = new byte[size];
            in.read(data);

            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
