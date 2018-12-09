// design pattern: Observer
package _06_ClientBot.Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread implements Observer {
    private Socket socket;
    BufferedReader in;
    PrintWriter out;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void update(String message) {
        out.println(message);
    }

    @Override
    public void run() {

        try {
            // for sending data to client
            out = new PrintWriter(socket.getOutputStream(), true);

            // for getting data from client
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String inputLine, outputLine;

            // sending data to client
            outputLine = "Hello";
            out.println(outputLine);

            // waiting for data from client, and every time do some action
            while ((inputLine = in.readLine()) != null) {

                // ending thread, connection with client
                if (inputLine.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println(socket.toString() + ": " + inputLine);
            }

            in.close();
            out.close();
            socket.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
