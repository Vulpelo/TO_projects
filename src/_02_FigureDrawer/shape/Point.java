package _02_FigureDrawer.shape;

import javafx.scene.Group;
import _02_FigureDrawer.shape.Shape;

public class Point extends Shape {
    float x;
    float y;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public void render(Group group) {

    }
}
