package _08_ParticleSimulator;

import _08_ParticleSimulator.Entity.Particle;
import _08_ParticleSimulator.Math.Vector2;
import _08_ParticleSimulator.Memento.MementoCollection;
import _08_ParticleSimulator.Memento.States.MementoState;
import _08_ParticleSimulator.Systems.Motion;
import javafx.scene.Group;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controller {
    Group renderGroup;
    List<Motion> motions = new ArrayList<>();

    MementoCollection particleCollection = new MementoCollection();
    MementoCollection velocityCollection = new MementoCollection();

    Date time = new Date();
    long prevTime;
    float deltaTime = 0.f;

    public Controller(Group renderGroup)
    {
        this.renderGroup = renderGroup;
        prevTime = time.getTime();

        for (int i=0; i<10; i++) {
            Particle par = new Particle(new Vector2(100,100) );
            Motion mot = new Motion(par, renderGroup);

            motions.add(mot);
        }
    }

    public void eventTick() {
        deltaTime = 1.f/1000.f;//(float)(time.getTime() - prevTime) / 1000f;
        prevTime = time.getTime();

        // clear screen
        if (renderGroup.getChildren().size() > 0){
            renderGroup.getChildren().remove(0, renderGroup.getChildren().size()-1);
        }

        for (Motion m: motions) {
            m.eventTick(deltaTime);
        }
    }

    public void saveState() {
        for (Motion m: motions) {
            particleCollection.saveState(m.getParticle());
            velocityCollection.saveState(m.getVelocity());
        }
    }

    public void loadState() {
        List<MementoState> par_states = particleCollection.getStates();
        List<MementoState> vel_states = velocityCollection.getStates();


        for (int i=0; i<motions.size(); i++) {
            Particle p = par_states.get(i).getState() instanceof Particle ? ((Particle)par_states.get(i).getState()): null;
            Vector2 v = vel_states.get(i).getState() instanceof Vector2 ? ((Vector2)vel_states.get(i).getState()): null;

            if (p != null) {
                motions.get(i).getParticle().setPosition(p.getPosition());
            }
            if (v != null) {
                motions.get(i).getVelocity().setX(v.getX());
                motions.get(i).getVelocity().setY(v.getY());
            }
        }
    }
}
