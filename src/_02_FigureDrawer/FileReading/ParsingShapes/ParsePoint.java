package _02_FigureDrawer.FileReading.ParsingShapes;

import _02_FigureDrawer.shape.Point;

import java.util.Scanner;

public class ParsePoint extends ParseShape {

    // zapis:
    // 12 ; 32
    public Point parse(String line) {
        try (Scanner sc = new Scanner(line)){
            sc.useDelimiter(";");
            if (sc.hasNext()){
                Point p = new Point();

                int nx = sc.nextInt();
                int ny = sc.nextInt();

                p.setX(nx);
                p.setY(ny);

                return p;
            }
        }
        return null;
    }
}
