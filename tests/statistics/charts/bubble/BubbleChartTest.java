package statistics.charts.bubble;

import java.util.ArrayList;
import java.util.List;

public class BubbleChartTest {
    public static List<BubbleChartEntry> createEntries( ) {
        List<BubbleChartEntry> entries = new ArrayList<>();

        double radius = 5D;
        entries.add(new BubbleChartEntry(10, 20, radius));
        entries.add(new BubbleChartEntry(10, 40, radius));
        entries.add(new BubbleChartEntry(10, 30, radius));
        entries.add(new BubbleChartEntry(20, 20, radius));
        entries.add(new BubbleChartEntry(25, 20, radius));
        entries.add(new BubbleChartEntry(31, 20, radius));

        return entries;
    }

    public static void main( String args[ ] ) {
        BubbleChart bubbleChart = new BubbleChart("Bubble chart");
        bubbleChart.display(createEntries(), "test title", "x", "y", "a series");
    }
}