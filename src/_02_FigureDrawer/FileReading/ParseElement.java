package sample.FileReading;

import sample.FileReading.ParsingShapes.ParseCircle;
import sample.FileReading.ParsingShapes.ParseLine;
import sample.FileReading.ParsingShapes.ParseRectangle;
import sample.FileReading.ParsingShapes.ParseShape;
import sample.shape.Shape;

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
