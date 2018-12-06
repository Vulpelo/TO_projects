package sample.FileReading.ParsingShapes;

import sample.shape.Shape;
import sample.shape.shape1D.Line;

import java.util.Scanner;

public class ParseLine extends ParseShape {
    public ParseLine(){
        name = "line";
    }

    @Override
    public Shape parse(String line) {

        try (Scanner sc = new Scanner(line)){
            sc.useDelimiter(",");
            if (sc.hasNext()){
                String tmp = sc.next().toLowerCase();
                if (tmp.equals(name)){
                    Line l = new Line();

                    ParsePoint pp = new ParsePoint();
                    l.setA(  pp.parse(sc.next()) );
                    l.setB(  pp.parse(sc.next()) );

                    return l;
                }
            }
            return null;
        }
    }
}
