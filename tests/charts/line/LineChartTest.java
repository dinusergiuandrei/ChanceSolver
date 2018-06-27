package charts.line;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import java.util.ArrayList;
import java.util.List;

public class LineChartTest{

    private static List<LineChartEntry> createDataset( ) {
        List<LineChartEntry> entries = new ArrayList<>();

        entries.add(new LineChartEntry( 15 , "1" , "1970" ));
        entries.add(new LineChartEntry( 30 , "2" , "1980" ));
        entries.add(new LineChartEntry( 60 , "3" ,  "1990" ));
        entries.add(new LineChartEntry( 120 , "5" , "2000" ));
        entries.add(new LineChartEntry( 240 , "2" , "2010" ));
        entries.add(new LineChartEntry( 300 , "3" , "2014" ));
        return entries;
    }

    public static void main( String[ ] args ) {
        LineChart chart = new LineChart("School Vs Years");
        chart.display(createDataset(), "Numer of Schools vs years", "categories", "values");
    }
}
