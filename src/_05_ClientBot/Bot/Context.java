// wzorzec projektowy: State/Stany
package _05_ClientBot.Bot;

import _05_ClientBot.Bot.State.State;

public class Context {
    private State state;

    public void doAction() {
        state.doAction();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

}
