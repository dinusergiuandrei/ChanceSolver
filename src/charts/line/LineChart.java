package charts.line;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.List;

public class LineChart extends ApplicationFrame {

    public LineChart() {
        this("Line Chart");
    }

    public LineChart(String applicationTitle) {
        super(applicationTitle);
    }

    private DefaultCategoryDataset createDataset(List<LineChartEntry> entries) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        entries.forEach(entry -> dataset.addValue(entry.getNumber(), entry.getRowKey(), entry.getColumnKey()));
        return dataset;
    }

    public void display(List<LineChartEntry> entries) {
        display(entries, "title", "category label", "value label");
    }

    public void display(List<LineChartEntry> entries, String chartTitle, String categoryAxisLabel, String valueAxisLabel ){
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                categoryAxisLabel,valueAxisLabel,
                createDataset(entries),
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        setContentPane( chartPanel );

        this.pack( );
        RefineryUtilities.centerFrameOnScreen( this );
        this.setVisible( true );
    }

}
