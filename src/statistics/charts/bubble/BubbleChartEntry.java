package statistics.charts.bubble;

public class BubbleChartEntry {
    private double x;

    private double y;

    private double radius;

    public BubbleChartEntry(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }
}
