package sample.shape;

public abstract class Shape implements IShape, Rendering {
    float lineThickness = 1.0f;

    public float getLineThickness(){
        return lineThickness;
    }

    public void setLineThickness(float nLineThickness) {
        lineThickness = nLineThickness;
    }
}
