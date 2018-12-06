package _02_FigureDrawer.shape.shape2D;

import javafx.scene.Group;
import _02_FigureDrawer.shape.Point;

public class Rectangle extends Shape2D  {

    Point a;
    Point b;

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    @Override
    public float area() {
        return Math.abs(b.getX()-a.getX()) * (b.getY() - a.getY());
    }

    @Override
    public float circumference() {
        return Math.abs(b.getX()-a.getX()) * 2 + Math.abs(b.getY() - a.getY()) * 2;
    }

    @Override
    public void render(Group group) {
        javafx.scene.shape.Rectangle rect = new javafx.scene.shape.Rectangle();

        rect.setX(a.getX());
        rect.setY(a.getY());

        rect.setWidth( Math.abs(b.getX() - a.getX()) );
        rect.setHeight( Math.abs(b.getY() - a.getY()) );

        group.getChildren().add(rect);
    }
}
