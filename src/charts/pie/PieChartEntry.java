package charts.pie;

public class PieChartEntry {
    private Comparable key;

    private Number value;

    public PieChartEntry(Comparable key, Number value) {
        this.key = key;
        this.value = value;
    }

    public Comparable getKey() {
        return key;
    }

    public Number getValue() {
        return value;
    }
}
