package _05_ClientBot.Bot.State;

import _05_ClientBot.Bot.Context;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Listen extends State {


    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private String line = "";

    public Listen(Context context) {
        super(context);
    }

    @Override
    public void doAction() {
        try {
            line = in.readLine();
            System.out.println(line);
        }
        catch (Exception e) {

        }
    }
}
