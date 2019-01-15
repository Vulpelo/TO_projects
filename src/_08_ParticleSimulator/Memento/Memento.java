package _08_ParticleSimulator.Memento;

import _08_ParticleSimulator.Memento.States.MementoState;

public class Memento {

    MementoState state;

    public Memento(MementoState state) {
        this.state = state;
    }

    public MementoState getState() {
        return state;
    }

    public void setState(MementoState state) {
        this.state = state;
    }
}
