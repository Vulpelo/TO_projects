// design pattern: Observer
package _06_ClientBot.Server;

import _06_ClientBot.Client.Client;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread {
    private ArrayList<Observer> clients = new ArrayList<>();

    private int port;

    public Server(int port) {
        this.port = port;
    }

    // makes connection with new client
    public void register(Observer client) {
        clients.add(client);
    }

    // disconnects client from server
    public void unregister(Client client) {

    }

    // Server notifies All clients to do something
    public void notifyAllClients(byte[] message) {
        for (Observer s: clients) {
            s.update(message);
        }
    }

    // Server notifies specific client to do something
    public void notifyClient(String message, Client client) {

    }

    // Updates server data when client is notifying server
    public void update() {

    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        try {
            // Creating server
            serverSocket = new ServerSocket(port);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }

        while (true) {
            try {
                // awaiting for new client
                clientSocket = serverSocket.accept();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            // new thread for new client
            ServerThread t = new ServerThread(clientSocket);
            t.start();
            this.register(t);

            System.out.println("New Client");
        }
    }
}
