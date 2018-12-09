package _05_ClientBot.Server;

import java.util.Scanner;

public class MainServer {
    public static void main(String []args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String c;

        Server server = new Server(4444);
        server.start();

        // getting input from user ass commands to server
        while (true) {
            c = sc.nextLine();
            server.notifyAllClients(c);
        }
    }
}
