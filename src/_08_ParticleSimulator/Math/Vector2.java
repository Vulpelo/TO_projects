package _08_ParticleSimulator.Math;

public class Vector2 {
    private float x;
    private float y;

    public Vector2(Vector2 vec) {
        this.x = vec.getX();
        this.y = vec.getY();
    }

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

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
}
