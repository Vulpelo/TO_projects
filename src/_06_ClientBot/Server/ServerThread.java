// design pattern: Observer
package _06_ClientBot.Server;

import _06_ClientBot.Reader.DataReader;
import _06_ClientBot.Reader.DataReaderBegin;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ServerThread extends Thread implements Observer {
    private Socket socket;
    private String c = "";
    private Server server;

    InputStream in;
    OutputStream out;

    public ServerThread(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
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

            {
                // sending data to client. SizeOfData + Data
                byte[] bytes = {'H', 'e', 'l', 'l', 'o'};
                send(bytes);
            }

            Object object = recive();
            // waiting for data from client, and every time do some action
            while (object != null) {
                handleObject(object);

                // ending thread, connection with client
                if (c.equalsIgnoreCase("exit")) {
                    break;
                }
                object = recive();
            }

            {
                byte[] tmp = {'e', 'x', 'i', 't'};
                send(tmp);
            }
            in.close();
            out.close();
            server.unregister(this);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void handleObject(Object object) {
        try {
            handle(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handle(Object object) throws Exception {
        if (object instanceof String) {
            c = (String)object;
            System.out.println(socket.toString() + ": " + c);
        }
        else if (object instanceof BufferedImage) {
            ImageIO.write((BufferedImage) object, "jpg", new File("C:\\Users\\Vulpelo\\Desktop\\ss.jpg"));
            c = "IMAGE";
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

    // getting data from client
    private Object recive() {
        try {
            // getting size
            byte[] sizeAr = new byte[4];
            in.read(sizeAr);
            int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();

            // getting type of data
            byte[] type = new byte[1];
            in.read(type);

            // getting data
            byte[] data = new byte[size];
            in.read(data);

            DataReader dataReader = new DataReaderBegin();
            return dataReader.processContent(type, data);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
