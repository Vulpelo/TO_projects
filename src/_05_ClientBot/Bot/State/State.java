package _05_ClientBot.Bot.State;

import _05_ClientBot.Bot.Context;

public abstract class State {
    private Context context;

    public State(Context context) {
        this.context = context;
    }

    public void doAction() {};
}
