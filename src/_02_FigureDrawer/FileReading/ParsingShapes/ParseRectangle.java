package sample.FileReading.ParsingShapes;

import sample.shape.Shape;
import sample.shape.shape2D.Rectangle;

import java.util.Scanner;

public class ParseRectangle extends ParseShape {
    public ParseRectangle(){
        name = "rectangle";
    }

    @Override
    public Shape parse(String line) {
        try (Scanner sc = new Scanner(line)){
            sc.useDelimiter(",");
            if (sc.hasNext()){
                String tmp = sc.next().toLowerCase();
                if (tmp.equals(name)){
                    Rectangle rect = new Rectangle();

                    ParsePoint pp = new ParsePoint();
                    rect.setA(  pp.parse(sc.next()) );
                    rect.setB(  pp.parse(sc.next()) );

                    return rect;
                }
            }
            return null;
        }
    }
}
