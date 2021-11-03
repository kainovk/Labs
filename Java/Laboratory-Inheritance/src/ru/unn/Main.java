package ru.unn;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Point polymorphism
        Point point = new Point(6, 4.1);
        Point coloredPoint = new ColoredPoint(8, 1, "YELLOW");
        Point line = new Line(11, 21, 33, 445.754);
        Point coloredLine = new ColoredLine(1, 2, 5, 6.4214, "WHITE");

        // display()
        List<Point> myObjects = Arrays.asList(point, coloredPoint, line, coloredLine);
        for (Point obj : myObjects) {
            obj.display();
        }

        // array of lines
        Line[] lines = new Line[5];
        lines[0] = new Line(0, 0, 1, 1);
        lines[1] = new Line(1, 1, 2, 4);
        lines[2] = new Line(0, 0, -1, 1);
        lines[3] = new Line(0, 0, -2, 4);
        lines[4] = new Line(-2, 4, 2, 4);

        PolyLine polyLine = new PolyLine(lines);
        polyLine.display();
    }
}
