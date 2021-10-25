package ru.unn;

public class PolyLine extends Line {

    private double x3, y3;

    public PolyLine(double x1, double y1, double x2, double y2, double x3, double y3) {
        super(x1, y1, x2, y2);
        this.x3 = x3;
        this.y3 = y3;
    }

    public double getX3() {
        return x3;
    }

    public double getY3() {
        return y3;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public void setY3(double y3) {
        this.y3 = y3;
    }

    @Override
    public void display() {
        System.out.printf("Polyline: (%.1f; %.1f), (%.1f; %.1f), (%.1f; %.1f)\n",
                getX(), getY(), getX2(), getY2(), x3, y3);
    }
}
