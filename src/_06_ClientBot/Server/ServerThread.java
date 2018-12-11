// design pattern: Observer
package _06_ClientBot.Server;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class ServerThread extends Thread implements Observer {
    private Socket socket;

    InputStream in;
    OutputStream out;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void update(byte[] message) {
        send(message);
    }

    @Override
    public void run() {

        try {
            // for sending data to client
            out = socket.getOutputStream();

            // for getting data from client
            in = socket.getInputStream();

            // sending data to client. SizeOfData + Data
            byte[] bytes = {'H', 'e', 'l', 'l', 'o'};
            send(bytes);

            bytes = recive();

            // waiting for data from client, and every time do some action
            while (bytes != null) {
                String inputLine = new String(bytes, StandardCharsets.UTF_8);

                // ending thread, connection with client
                if (inputLine.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println(socket.toString() + ": " + inputLine);
                bytes = recive();
            }

            in.close();
            out.close();
            socket.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void send(byte[] message) {
        try {
            byte[] size = ByteBuffer.allocate(4).putInt(message.length).array();
            out.write(size);
            out.write(message);
        } catch (IOException e) {
            e.printStackTrace();
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
