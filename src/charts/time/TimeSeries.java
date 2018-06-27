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

import java.util.List;

public class TimeSeries extends ApplicationFrame {

    public TimeSeries() {
        this("Time Series");
    }

    public TimeSeries(final String title ) {
        super( title );
    }

    private XYDataset createDataSet(List<TimeSeriesEntry> entries, String seriesTitle){
        org.jfree.data.time.TimeSeries series = new org.jfree.data.time.TimeSeries( seriesTitle );
        entries.forEach(entry -> series.add(entry.getTimePeriod(), entry.getValue()));
        return new TimeSeriesCollection(series);
    }

    public void display(List<TimeSeriesEntry> entries) {
        display(entries, "Series Title", "Chart Title", "Time Label", "Value Label");
    }

    public void display(List<TimeSeriesEntry> entries, String seriesTitle, String chartTitle, String timeLabel, String valueLabel){

        final XYDataset dataset = createDataSet(entries, seriesTitle);

        final JFreeChart chart = ChartFactory.createTimeSeriesChart(
                chartTitle,
                timeLabel,
                valueLabel,
                dataset,
                false,
                false,
                false);

        final ChartPanel chartPanel = new ChartPanel( chart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 370 ) );
        chartPanel.setMouseZoomable( true , false );
        setContentPane( chartPanel );

        this.pack( );
        RefineryUtilities.positionFrameRandomly( this );
        this.setVisible( true );
    }
}
