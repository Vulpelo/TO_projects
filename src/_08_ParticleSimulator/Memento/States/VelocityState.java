package _08_ParticleSimulator.Memento.States;

import _08_ParticleSimulator.Entity.Particle;
import _08_ParticleSimulator.Math.Vector2;

public class VelocityState implements MementoState {
    private float x;
    private float y;

    @Override
    public Object getSave() {
        Vector2 p = new Vector2(x, y);
        return p;
    }

    @Override
    public void setSave(Object object) {
        Vector2 vec = object instanceof Vector2 ? ((Vector2) object) : null;

        if (vec != null) {
            this.x = vec.getX();
            this.y = vec.getY();
        }
    }
}
