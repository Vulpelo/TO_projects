package _08_ParticleSimulator.Entity;

import _08_ParticleSimulator.Math.Vector2;
import _08_ParticleSimulator.Rendering;
import javafx.scene.Group;

public class Particle implements Rendering {
    private Vector2 position;

    public Particle() {
        position = new Vector2(100, 100);
    }

    public Particle(Vector2 position) {
        this.position = position;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    @Override
    public void render(Group group) {
        javafx.scene.shape.Circle circle = new javafx.scene.shape.Circle();
        circle.setCenterX(position.getX());
        circle.setCenterY(position.getY());
        circle.setRadius(1);
        group.getChildren().add(circle);
    }
}
