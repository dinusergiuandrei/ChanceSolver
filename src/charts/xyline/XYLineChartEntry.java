package charts.xyline;

public class XYLineChartEntry {
    private Number x;

    private Number y;

    public XYLineChartEntry(Number x, Number y) {
        this.x = x;
        this.y = y;
    }

    public Number getX() {
        return x;
    }

    public Number getY() {
        return y;
    }
}
