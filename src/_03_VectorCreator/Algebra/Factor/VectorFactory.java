package Algebra.Factor;

import Algebra.IAlgebra;
import Algebra.Vector2D;

public class VectorFactory implements IAlgebra {

    private Vector2D vector;

    /** Creates vector2d based on it's length and angle. Angle 0 degrees points up. Angle is going clockwise. */
    public VectorFactory(double length, double angle) {
        double s = angle * Math.PI/180;
        vector = new Vector2D(length * Math.sin(s), length * Math.cos(s));
    }

    public VectorFactory(Vector2D v2D) {
        vector = new Vector2D(v2D.getX(), v2D.getY());
    }

    public Vector2D getVector() {
        return vector;
    }


    /** Returns angle between given vector2d and vector(0, 1) */
    public double getAngle() {
        return Math.acos( this.vector.getY() / this.vector.abs() );
    }

    @Override
    public double abs() {
        return 0;
    }


}
