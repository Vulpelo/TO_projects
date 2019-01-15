package _08_ParticleSimulator.Memento.States;

import _08_ParticleSimulator.Entity.Particle;
import _08_ParticleSimulator.Math.Vector2;

public class ParticleState implements MementoState {
    private Vector2 position;

    @Override
    public Object getSave() {
        Particle p = new Particle();
        p.setPosition(new Vector2(position));
        return p;
    }

    @Override
    public void setSave(Object object) {
        Particle particle = object instanceof Particle ? ((Particle) object) : null;

        if (particle != null) {
            this.position = new Vector2(particle.getPosition());
        }
    }
}
