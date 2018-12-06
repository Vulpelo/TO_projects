package sample.FileReading;

import sample.shape.Shape;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TXTReader {
    public List<Shape> readFile_Shapes(String path){
        List<Shape> parsedShapes = new ArrayList<>();
        ParseElement parseElement = new ParseElement();

        try {
            File f = new File(path);
            Scanner sc = new Scanner(f);

            while (sc.hasNextLine()){
                Shape shape = parseElement.processElement(sc.nextLine());
                if (shape != null){
                    parsedShapes.add(shape);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return parsedShapes;
    }
}
