package _08_ParticleSimulator.Systems;

import _08_ParticleSimulator.Entity.Particle;
import _08_ParticleSimulator.Math.Vector2;
import _08_ParticleSimulator.ESCSystem;
import javafx.scene.Group;

import java.util.Random;

public class Motion implements ESCSystem {
    private Particle particle;
    private Vector2 velocity;
    private Group renderGroup;

    public Motion(Particle particle, Group renderGroup) {
        this.particle = particle;
        this.renderGroup = renderGroup;

        Random random = new Random();

        int tab[] = {-1,1};
        velocity = new Vector2(
                (random.nextFloat()*200 + 100) * tab[random.nextInt(2)],
                (random.nextFloat()*200 + 100) * tab[random.nextInt(2)]
                );
    }

    public Particle getParticle() {
        return particle;
    }

    public void setParticle(Particle particle) {
        this.particle = particle;
    }

    public void setParticlePosition(Vector2 position) {
        particle.setPosition(position);
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    @Override
    public void eventTick(float deltaTime) {
        collisionCheck();

        Vector2 pos = particle.getPosition();
        pos.setX( pos.getX() + velocity.getX() * deltaTime );
        pos.setY( pos.getY() + velocity.getY() * deltaTime );

        particle.setPosition(pos);

        particle.render(renderGroup);
    }

    private void collisionCheck() {
        Vector2 pos = particle.getPosition();
        if (pos.getX() <= 0 || pos.getX() >= 200) {
            velocity.setX(-velocity.getX());
        }
        if (pos.getY() <= 0 || pos.getY()>=200) {
            velocity.setY(-velocity.getY());
        }

    }
}
