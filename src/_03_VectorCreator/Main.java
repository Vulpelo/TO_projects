import Algebra.Calculate;
import Algebra.Factor.VectorFactory;
import Algebra.IAlgebra;
import Algebra.Vector2D;
import Algebra.Vector3D;

public class Main {
    public static void main(String[] args){
        {
            /// Creating vector2d from angle and length
            VectorFactory vf = new VectorFactory(20, 30);
            System.out.println(vf.getVector());
        }
        {
            // vector3d abs
            IAlgebra ia = new Vector2D(10, 15);
            Vector3D v3 = new Vector3D(ia, 20);
            System.out.println(v3 + "; len:" + v3.abs());
        }
        {
            // operations on 3d vectors
            Calculate v3_1 = new Calculate(10, 25, 20);
            Vector3D v3_2 = new Vector3D(10, 5, 0);

            System.out.println(v3_1 + " dot " + v3_2 + " = " + v3_1.scalarDot(v3_2));
            System.out.println(v3_1 + " * " + v3_2 + " = " + v3_1.vectorMultip(v3_2));
        }
    }
}
