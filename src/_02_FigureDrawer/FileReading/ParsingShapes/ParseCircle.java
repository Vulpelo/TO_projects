package sample.FileReading.ParsingShapes;

import sample.shape.Shape;
import sample.shape.shape2D.Circle;

import java.util.Scanner;

public class ParseCircle extends ParseShape {
    public ParseCircle(){
        name = "circle";
    }

    @Override
    public Shape parse(String line) {
        try (Scanner sc = new Scanner(line)){
            sc.useDelimiter(",");
            if (sc.hasNext()){
                String tmp = sc.next().toLowerCase();
                if (tmp.equals(name)){
                    Circle cir = new Circle();

                    ParsePoint pp = new ParsePoint();
                    cir.setRadious(sc.nextInt());
                    cir.setCenter(  pp.parse(sc.next()) );

                    return cir;
                }
            }
            return null;
        }
    }
}
