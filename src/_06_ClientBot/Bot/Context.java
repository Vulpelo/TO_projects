// wzorzec projektowy: State/Stany
package _06_ClientBot.Bot;

import _06_ClientBot.Bot.State.State;

public class Context {
    private State state;

    public void doAction() {
        State tmp = state.doAction();
        if (tmp != null) {
            state = tmp;
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

}
