package _06_ClientBot.Client;

import _06_ClientBot.Bot.Context;
import _06_ClientBot.Bot.State.Idle;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class ClientThread extends Thread {
    private Context context = new Context();
    private OutputStream out;

    public ClientThread(OutputStream out) {
        context.setState(new Idle());
        this.out = out;
    }

    public void newState(_06_ClientBot.Bot.State.State state) {
//        try {
//            out.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        context.setState(state);
    }

    @Override
    public void run() {
        while (true) {
            context.doAction();
        }
    }
}
