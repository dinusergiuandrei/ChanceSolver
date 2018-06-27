package statistics.charts.bar;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BarChart extends ApplicationFrame {

    public BarChart(String applicationTitle) {
        super( applicationTitle );
    }

    private CategoryDataset createDataSet(Iterable<BarChartEntry> source ) {
        final DefaultCategoryDataset dataSet = new DefaultCategoryDataset( );
        source.forEach(entry -> dataSet.addValue(entry.getNumber(), entry.getRowKey(), entry.getColumnKey()));
        return dataSet;
    }

    public void display(String chartTitle, Iterable<BarChartEntry> source, String xLabel, String yLabel){
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                xLabel,
                yLabel,
                createDataSet(source),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel( barChart );
        chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );
        setContentPane( chartPanel );
        this.pack();
        RefineryUtilities.centerFrameOnScreen( this );
        this.setVisible( true );
    }
}