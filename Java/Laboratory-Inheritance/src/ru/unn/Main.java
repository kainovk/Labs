package ru.unn;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Point point = new Point(6, 4.1);
        Point line = new Line(11, 21, 33, 445.754);
        Point coloredLine = new ColoredLine(1, 2, 5, 6.4214, "WHITE");
        Point polyLine = new PolyLine(1, 2231.321, 5, 6.3213, 12166, 71);

        List<Point> myObjects = Arrays.asList(point, line, coloredLine, polyLine);
        for (Point o : myObjects) {
            o.display();
        }
    }
}
