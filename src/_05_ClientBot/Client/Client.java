package _05_ClientBot.Client;

import _05_ClientBot.Bot.State.Idle;
import _05_ClientBot.Bot.State.Listen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {
    private ClientThread client;

    private String hostName;
    private int port;

    private PrintWriter out;
    private BufferedReader in;

    public Client(String hostName, int port) {
        this.hostName = hostName;
        this.port = port;
    }

    void readCommand(String command) {
        switch (command.toLowerCase()) {
            case "listen":
                client.newState(new Listen(out));
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

            out = new PrintWriter( clientSocket.getOutputStream(), true);
            in = new BufferedReader( new InputStreamReader( clientSocket.getInputStream() ) );

            // creating client 'brain'
            client = new ClientThread(out);
            client.start();

            // lisning from server, getting data from server
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Got Command: " + inputLine);

                // end client if exit
                if (inputLine.equalsIgnoreCase("exit")) {
                    break;
                }

                readCommand(inputLine);
            }

            sc.close();
            out.close();
            in.close();
            clientSocket.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
