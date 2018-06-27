package charts.time;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.SeriesException;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.util.ArrayList;
import java.util.List;

public class TimeSeriesTest {

    private static List<TimeSeriesEntry> createSource( ) {
        List<TimeSeriesEntry> entries = new ArrayList<>();
        Second current = new Second( );
        double value = 100.0;

        for (int i = 0; i < 4000; i++) {

            try {
                value = value + Math.random( ) - 0.5;
                entries.add(new TimeSeriesEntry(current, value));
                current = ( Second ) current.next( );
            } catch ( SeriesException e ) {
                System.err.println("Error adding to series");
            }
        }

        return entries;
    }

    public static void main( final String[ ] args ) {
        TimeSeries chart = new TimeSeries();
        chart.display(createSource());
    }
}
