package _02_FigureDrawer.shape.shape2D;

import javafx.scene.Group;
import javafx.scene.paint.Paint;
import _02_FigureDrawer.shape.Point;


public class Circle extends Shape2D {

    private float radious;
    private Point center;

    public float getRadious() {
        return radious;
    }

    public void setRadious(float radious) {
        this.radious = radious;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    @Override
    public float circumference() {
        return (float) (2 * Math.PI * radious);
    }

    @Override
    public float area() {
        return (float) (Math.PI * radious * radious);
    }

    @Override
    public void render(Group group) {
        javafx.scene.shape.Circle circle = new javafx.scene.shape.Circle();
        circle.setCenterX(center.getX());
        circle.setCenterY(center.getY());
        circle.setRadius(radious);
        group.getChildren().add(circle);
    }
}
