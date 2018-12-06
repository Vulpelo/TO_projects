package _02_FigureDrawer.FileReading;

import _02_FigureDrawer.FileReading.ParsingShapes.ParseCircle;
import _02_FigureDrawer.FileReading.ParsingShapes.ParseLine;
import _02_FigureDrawer.FileReading.ParsingShapes.ParseRectangle;
import _02_FigureDrawer.FileReading.ParsingShapes.ParseShape;
import _02_FigureDrawer.shape.Shape;

import java.util.ArrayList;
import java.util.List;

public class ParseElement {
    List<ParseShape> pshape;

    ParseElement(){
        pshape = new ArrayList<>();
        pshape.add(new ParseCircle());
        pshape.add(new ParseLine());
        pshape.add(new ParseRectangle());
    }

    Shape processElement(String line){
        Shape elem = null;
        for (ParseShape p: pshape) {
            elem = p.parse(line);
            if (elem != null){
                break;
            }
        }
        return elem;
    }
}
