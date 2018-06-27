package charts.xyline;

import java.awt.Color;
import java.awt.BasicStroke;
import java.util.List;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class XYLineChart extends ApplicationFrame {

    public XYLineChart() {
        this("Line Chart");
    }

    public XYLineChart(String applicationTitle ) {
        super(applicationTitle);

    }

    private XYDataset createDataset(List<XYLineChartSeries> seriesList) {
        XYSeriesCollection dataset = new XYSeriesCollection( );
        seriesList.forEach(series -> dataset.addSeries(series.getSeries()));
        return dataset;
    }

    public void display(List<XYLineChartSeries> seriesList) {
        display(seriesList, "Chart Title", "x label", "y label");
    }

    public void display(List<XYLineChartSeries> seriesList, String chartTitle, String xLabel, String yLabel){
        JFreeChart xyLineChart = ChartFactory.createXYLineChart(
                chartTitle ,
                xLabel ,
                yLabel ,
                createDataset(seriesList) ,
                PlotOrientation.VERTICAL ,
                true , true , false);
        ChartPanel chartPanel = new ChartPanel( xyLineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        final XYPlot plot = xyLineChart.getXYPlot( );

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        renderer.setSeriesPaint( 0 , Color.RED );
        renderer.setSeriesPaint( 1 , Color.GREEN );
        renderer.setSeriesPaint( 2 , Color.YELLOW );
        renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
        renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
        renderer.setSeriesStroke( 2 , new BasicStroke( 2.0f ) );
        plot.setRenderer( renderer );
        setContentPane( chartPanel );
        this.pack( );
        RefineryUtilities.centerFrameOnScreen( this );
        this.setVisible( true );
    }
}