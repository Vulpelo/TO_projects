package _03_VectorCreator.Algebra;

public class Vector2D implements IAlgebra {
    protected double x;
    protected double y;

    public Vector2D () {
        x=0;
        y=0;
    }

    public Vector2D (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public double abs() {
        return Math.sqrt(x*x + y*y);
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

}
