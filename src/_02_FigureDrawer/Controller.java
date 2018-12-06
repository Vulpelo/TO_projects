package sample;

import javafx.scene.Group;
import sample.FileReading.TXTReader;
import sample.shape.Shape;

import java.util.List;

public class Controller {
    Group renderGroup;

    public Controller(Group renderGroup)
    {
        this.renderGroup = renderGroup;
    }

    public void buttonClicked(){
        TXTReader reader = new TXTReader();

        List<Shape> shapes =  reader.readFile_Shapes("example.txt");

        if (renderGroup.getChildren().size() > 0){
            renderGroup.getChildren().remove(0, renderGroup.getChildren().size()-1);
        }

        for (Shape s: shapes) {
            s.render(renderGroup);
        }
    }

}
