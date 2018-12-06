package _02_FigureDrawer.shape.shape1D;

import _02_FigureDrawer.shape.Point;

public class Line extends Shape1D {

    Point a;
    Point b;

    @Override
    public float length() {
        float x = b.getX() - a.getX();
        float y = b.getY() - a.getY();
        return (float) Math.sqrt(x*x + y*y);
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public void setB(Point b) {
        this.b = b;
    }

    @Override
    public void render(javafx.scene.Group group) {
        javafx.scene.shape.Line line = new javafx.scene.shape.Line();

        line.setStartX(a.getX());
        line.setStartY(a.getY());

        line.setEndX(b.getX());
        line.setEndY(b.getY());

        group.getChildren().add(line);
    }
}
