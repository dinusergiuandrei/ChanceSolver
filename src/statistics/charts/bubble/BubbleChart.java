package statistics.charts.bubble;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;


import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BubbleChart extends ApplicationFrame {

    public BubbleChart(String applicationTitle ) {
        super( applicationTitle );
    }

    private XYZDataset createDataSet(String seriesKey, List<BubbleChartEntry> entries){
        DefaultXYZDataset defaultxyzdataset = new DefaultXYZDataset();
        double ys[ ] = new double[entries.size()];
        double xs[ ] = new double[entries.size()];
        double radius[ ] = new double[entries.size()];

        for (int index = 0; index < entries.size(); index++) {
            ys[index] = entries.get(index).getY();
            xs[index] = entries.get(index).getX();
            radius[index] = entries.get(index).getRadius();
        }

        double source[][] = { ys , xs , radius };
        defaultxyzdataset.addSeries(seriesKey, source );

        return defaultxyzdataset;
    }

    public void display(List<BubbleChartEntry> entries, String title, String xLabel, String yLabel, String seriesKey){
        JFreeChart jfreechart = ChartFactory.createBubbleChart(
                title,
                xLabel,
                yLabel,
                createDataSet(seriesKey, entries),
                PlotOrientation.HORIZONTAL,
                true, true, false);

        XYPlot xyplot = ( XYPlot )jfreechart.getPlot( );
        xyplot.setForegroundAlpha( 0.65F );
        XYItemRenderer xyitemrenderer = xyplot.getRenderer( );
        xyitemrenderer.setSeriesPaint( 0 , Color.blue );
        NumberAxis numberaxis = ( NumberAxis )xyplot.getDomainAxis( );
        numberaxis.setLowerMargin( 0.2 );
        numberaxis.setUpperMargin( 0.5 );
        NumberAxis numberaxis1 = ( NumberAxis )xyplot.getRangeAxis( );
        numberaxis1.setLowerMargin( 0.8 );
        numberaxis1.setUpperMargin( 0.9 );

        ChartPanel chartpanel = new ChartPanel( jfreechart );

        chartpanel.setDomainZoomable( true );
        chartpanel.setRangeZoomable( true );
        chartpanel.setPreferredSize(new Dimension( 560 , 370 ) );
        setContentPane(chartpanel);
        this.pack( );
        RefineryUtilities.centerFrameOnScreen( this );
        this.setVisible( true );
    }


    private XYZDataset createDataSet(List<BubbleChartEntry> entries) {
        return createDataSet("Series 1", entries);
    }


    public void display(List<BubbleChartEntry> entries) {
        display(entries, "Title", "xLabel", "yLabel", "Series key");
    }
}