package _08_ParticleSimulator.Systems;

import _08_ParticleSimulator.Entity.Particle;
import _08_ParticleSimulator.Math.Vector2;
import _08_ParticleSimulator.ESCSystem;
import javafx.scene.Group;

import java.util.Random;

public class Motion implements ESCSystem {
    private Particle particle;
    private Vector2 movement;
    private Group renderGroup;

    public Motion(Particle particle, Group renderGroup) {
        this.particle = particle;
        this.renderGroup = renderGroup;

        Random random = new Random();

        int tab[] = {-1,1};
        movement = new Vector2(
                (random.nextFloat()*200 + 100) * tab[random.nextInt(2)],
                (random.nextFloat()*200 + 100) * tab[random.nextInt(2)]
                );
    }

    public Particle getParticle() {
        return particle;
    }

    @Override
    public void eventTick(float deltaTime) {
        collisionCheck();

        Vector2 pos = particle.getPosition();
        pos.setX( pos.getX() + movement.getX() * deltaTime );
        pos.setY( pos.getY() + movement.getY() * deltaTime );

        particle.setPosition(pos);

        particle.render(renderGroup);
    }

    public void collisionCheck() {
        Vector2 pos = particle.getPosition();
        if (pos.getX() <= 0 || pos.getX() >= 200) {
            movement.setX(-movement.getX());
        }
        if (pos.getY() <= 0 || pos.getY()>=200) {
            movement.setY(-movement.getY());
        }

    }
}
