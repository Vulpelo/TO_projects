package _08_ParticleSimulator.Memento;

import _08_ParticleSimulator.Entity.Particle;
import _08_ParticleSimulator.Math.Vector2;
import _08_ParticleSimulator.Memento.States.MementoState;
import _08_ParticleSimulator.Memento.States.ParticleState;
import _08_ParticleSimulator.Memento.States.VelocityState;

import java.util.ArrayList;
import java.util.List;

public class MementoCollection {
    List<MementoState> states = new ArrayList<>();

    public boolean saveState(Object object) {
        if (object instanceof Particle) {
            MementoState st = new ParticleState();
            st.setState(object);
            add(st);
            return true;
        }
        if (object instanceof Vector2) {
            MementoState st = new VelocityState();
            st.setState(object);
            add(st);
            return true;
        }
        return false;
    }

    public void add(MementoState state) {
        states.add(state);
    }

    public List<MementoState> getStates() {
        return states;
    }
}
