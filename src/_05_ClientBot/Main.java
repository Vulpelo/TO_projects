package _05_ClientBot;

import _05_ClientBot.Bot.Context;
import _05_ClientBot.Bot.State.Listen;

public class Main {
    public static void main(String []args) throws Exception {
        Context c = new Context();
        Listen l = new Listen(c);

        c.setState(l);
    }
}
