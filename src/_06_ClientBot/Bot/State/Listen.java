package _06_ClientBot.Bot.State;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class Listen extends State {
//    private BufferedReader c = new BufferedReader(new InputStreamReader(System.in));

    private String line = "";

    OutputStream out;

    public Listen(OutputStream pW) {
        out = pW;
    }

    @Override
    public State doAction() {
        Scanner sc = new Scanner(System.in);

        try {
            String fromUser;

            fromUser = sc.nextLine();
            if (fromUser != null) {

                //sending data to server
                send(fromUser.getBytes());
            }
            out.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // sending data to server
    private void send(byte[] message) {
        try {
            byte[] size = ByteBuffer.allocate(4).putInt(message.length).array();
            byte type = 1;

            out.write(size);
            out.write(type);
            out.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
