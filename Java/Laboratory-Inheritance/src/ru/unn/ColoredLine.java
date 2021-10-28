package ru.unn;

public class ColoredLine extends Line {

    private String color;

    public ColoredLine(double x1, double y1, double x2, double y2, String color) {
        super(x1, y1, x2, y2);
        this.color = color;
    }

    public ColoredLine(Point p1, Point p2, String color) {
        super(p1, p2);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void display() {
        System.out.printf("Colored line: (%.1f; %.1f), (%.1f; %.1f), color: %s\n",
                getX(), getY(), getX2(), getY2(), color);
    }
}
