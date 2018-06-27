package charts.xyline;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class XYLineChartTest {

    private static List<XYLineChartSeries> createDataset() {
        XYLineChartSeries firefoxSeries = new XYLineChartSeries("FireFox Series");
        firefoxSeries.add(new XYLineChartEntry(1, 1));
        firefoxSeries.add(new XYLineChartEntry(2, 4));
        firefoxSeries.add(new XYLineChartEntry(3, 3));

        XYLineChartSeries chromeSeries = new XYLineChartSeries("Chrome Series");
        chromeSeries.add(new XYLineChartEntry(1, 4));
        chromeSeries.add(new XYLineChartEntry(2, 5));
        chromeSeries.add(new XYLineChartEntry(3, 6));

        XYLineChartSeries explorerSeries = new XYLineChartSeries("Explorer Series");
        explorerSeries.add(new XYLineChartEntry(3, 4));
        explorerSeries.add(new XYLineChartEntry(4, 5));
        explorerSeries.add(new XYLineChartEntry(5, 4));

        List<XYLineChartSeries> seriesList = new ArrayList<>();
        seriesList.add(firefoxSeries);
        seriesList.add(chromeSeries);
        seriesList.add(explorerSeries);
        return seriesList;
    }

    public static void main(String[] args) {
        XYLineChart chart = new XYLineChart();
        chart.display(createDataset());
    }
}