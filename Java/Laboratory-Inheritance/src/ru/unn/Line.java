package ru.unn;

public class Line extends Point {

    private double x2, y2;

    public Line(double x1, double y1, double x2, double y2) {
        super(x1, y1);
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    @Override
    public void display() {
        System.out.printf("Line: (%.1f; %.1f), (%.1f; %.1f)\n",
                getX(), getY(), x2, y2);
    }
}
