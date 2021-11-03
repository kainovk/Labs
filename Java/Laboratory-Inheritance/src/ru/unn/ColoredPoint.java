package ru.unn;

public class ColoredPoint extends Point{

    String color;

    public ColoredPoint(double x, double y, String color) {
        super(x, y);
        this.color = color;
    }

    public ColoredPoint(Point point, String color) {
        super(point);
        this.color = color;
    }

    public ColoredPoint(ColoredPoint coloredPoint) {
        super(coloredPoint);
        this.color = coloredPoint.color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void display() {
        System.out.printf("Point: (%.1f; %.1f), color: %s\n", getX(), getY(), color);
    }
}
