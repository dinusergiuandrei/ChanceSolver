package charts.pie;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PieChartTest {

    private static List<PieChartEntry> createDataset( ) {
        List<PieChartEntry> entries = new ArrayList<>();
        entries.add(new PieChartEntry( "IPhone 5s" , 20d));
        entries.add(new PieChartEntry( "SamSung Grand" , 20d) );
        entries.add(new PieChartEntry( "MotoG" , 40d));
        entries.add(new PieChartEntry( "Nokia Lumia" , 10d));
        return entries;
    }

    public static void main( String[ ] args ) {
        PieChart chart = new PieChart();
        chart.display(createDataset());
    }
}