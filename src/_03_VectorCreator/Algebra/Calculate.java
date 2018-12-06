package _03_VectorCreator.Algebra;

public class Calculate extends Vector3D {
    public Calculate(int x, int y, int z) {
        vec = new Vector2D(x, y);
        this.z = z;
    }

    @Override
    public double scalarDot(Vector3D vector3d) {
        return vec.getX()*vector3d.vec.getX() + vec.getY()*vector3d.vec.getY() + z*vector3d.getZ() ;
    }

    // only for 3d vectors
    @Override
    public Vector3D vectorMultip(Vector3D vector3d) {
        double[] sum = new double[3];
        Vector3D v3d = new Vector3D();

        v3d.vec.setX( ( this.vec.getY() * vector3d.getZ() - this.z * vector3d.vec.getY() ) );
        v3d.vec.setY( ( this.getZ() * vector3d.vec.getX() - this.vec.getX() * vector3d.getZ() ) );
        v3d.setZ( ( this.vec.getX() * vector3d.vec.getY() - this.vec.getY() * vector3d.vec.getX() ) );

        return v3d;
    }
}
