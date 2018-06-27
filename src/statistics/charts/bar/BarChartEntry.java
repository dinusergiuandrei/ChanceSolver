package statistics.charts.bar;

public class BarChartEntry {
    private Number number;

    private Comparable rowKey;

    private Comparable columnKey;

    public BarChartEntry(Number number, Comparable rowKey, Comparable columnKey) {
        this.number = number;
        this.rowKey = rowKey;
        this.columnKey = columnKey;
    }

    public Number getNumber() {
        return number;
    }

    public Comparable getRowKey() {
        return rowKey;
    }

    public Comparable getColumnKey() {
        return columnKey;
    }
}
