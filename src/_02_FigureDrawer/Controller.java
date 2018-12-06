package _02_FigureDrawer;


import javafx.scene.Group;
import _02_FigureDrawer.FileReading.TXTReader;
import _02_FigureDrawer.shape.Shape;

import java.util.List;

public class Controller {
    Group renderGroup;

    public Controller(Group renderGroup)
    {
        this.renderGroup = renderGroup;
    }

    public void buttonClicked(){
        TXTReader reader = new TXTReader();

        List<Shape> shapes =  reader.readFile_Shapes("./src/_02_FigureDrawer/example.txt");

        if (renderGroup.getChildren().size() > 0){
            renderGroup.getChildren().remove(0, renderGroup.getChildren().size()-1);
        }

        for (Shape s: shapes) {
            s.render(renderGroup);
        }
    }

}
