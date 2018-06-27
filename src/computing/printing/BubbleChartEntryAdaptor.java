package computing.printing;

import charts.bubble.BubbleChart;
import charts.bubble.BubbleChartEntry;
import model.Entry;

import java.util.ArrayList;
import java.util.List;

public class BubbleChartEntryAdaptor {
    public static void print(List<Entry> entries) {
        BubbleChart chart = new BubbleChart();
        List<BubbleChartEntry> chartEntries = new ArrayList<>();
        entries.forEach(
                entry -> {
                    entry.getNumbers().forEach(
                            number -> {
                                chartEntries.add(new BubbleChartEntry(entry.getId(), number, 1));
                            }
                    );
                }
        );
        chart.display(chartEntries);
    }
}
