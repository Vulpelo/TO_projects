package _05_ClientBot.Client;

import _05_ClientBot.Bot.Context;
import _05_ClientBot.Bot.State.State;
import _05_ClientBot.Bot.State.Listen;
import _05_ClientBot.Bot.State.Idle;

import java.io.PrintWriter;

public class ClientThread extends Thread {
    private Context context = new Context();
    private PrintWriter out;

    public ClientThread(PrintWriter out) {
        context.setState(new Idle());
        this.out = out;
    }

    public void newState(_05_ClientBot.Bot.State.State state) {
        out.flush();
        context.setState(state);
    }

    @Override
    public void run() {
        while (true) {
            context.doAction();
        }
    }
}
