package _06_ClientBot.Bot.State;


import java.util.concurrent.TimeUnit;

public class Idle extends State {
    public Idle() {
    }

    @Override
    public State doAction() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
