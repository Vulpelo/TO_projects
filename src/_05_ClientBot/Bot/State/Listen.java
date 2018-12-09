package _05_ClientBot.Bot.State;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Listen extends State {


    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private String line = "";

    PrintWriter out;

    public Listen(PrintWriter pW) {
        out = pW;
    }

    @Override
    public void doAction() {
        Scanner sc = new Scanner(System.in);

        try {
            String fromServer, fromUser;

            fromUser = sc.nextLine();
            if (fromUser != null) {
                System.out.println("Client: " + fromUser);

                //sending data to server
                out.println(fromUser);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
