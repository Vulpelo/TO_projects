package _03_VectorCreator.Algebra;

public class Vector3D implements IAlgebra {

    protected Vector2D vec;
    protected double z;

    public Vector3D() {
        vec = new Vector2D();
        z = 0;
    }

    public Vector3D(int x, int y, int z) {
        vec = new Vector2D(x, y);
        this.z = z;
    }

    public Vector3D(IAlgebra vec2D, double z)
    {
        vec = vec2D instanceof Vector2D ? ((Vector2D) vec2D) : new Vector2D();
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public double abs(){
        Vector2D vector2D = vec instanceof Vector2D ? ((Vector2D) vec) : null;
        if(vector2D == null)
            return 0;
        return Math.sqrt( vector2D.getX()*vector2D.getX() + vector2D.getY()*vector2D.getY() + z*z );
    }

    public double scalarDot(Vector3D vector3d) {
        return vec.getX()*vector3d.vec.getX() + vec.getY()*vector3d.vec.getY() + z*vector3d.getZ() ;
    }

    // only for 3d vectors
    public Vector3D vectorMultip(Vector3D vector3d) {
        double[] sum = new double[3];
        Vector3D v3d = new Vector3D();

        v3d.vec.setX( ( this.vec.getY() * vector3d.getZ() - this.z * vector3d.vec.getY() ) );
        v3d.vec.setY( ( this.getZ() * vector3d.vec.getX() - this.vec.getX() * vector3d.getZ() ) );
        v3d.setZ( ( this.vec.getX() * vector3d.vec.getY() - this.vec.getY() * vector3d.vec.getX() ) );

        return v3d;
    }

    @Override
    public String toString(){
        String s = "(" + vec.getX() + ", " + vec.getY() + ", " + z + ")";
        return s;
    }

}
