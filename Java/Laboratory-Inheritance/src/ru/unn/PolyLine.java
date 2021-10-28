package ru.unn;

public class PolyLine extends Line {

    private final Line[] lines;

    public PolyLine(Line[] lines) {
        super(lines[0]);
        this.lines = new Line[lines.length - 1];
        System.arraycopy(lines, 1, this.lines, 0, lines.length - 1);
    }

    public Line getLineAt(int index) {
        if (index >= lines.length) {
            return null;
        }
        return lines[index];
    }

    @Override
    public void display() {
        System.out.printf("Polyline: %d lines:\n(%.1f; %.1f), (%.1f; %.1f)\n",
                lines.length + 1, getX(), getY(), getX2(), getY2());
        for (Line line : lines) {
            System.out.printf("(%.1f; %.1f), (%.1f; %.1f)\n",
                    line.getX(), line.getY(), line.getX2(), line.getY2());
        }
    }
}
