package charts.pie;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.util.List;

public class PieChart extends ApplicationFrame {

    public PieChart() {
        this("Pie chart");
    }

    public PieChart(String title ) {
        super( title );
    }

    private PieDataset createDataset(List<PieChartEntry> entries) {
        DefaultPieDataset dataset = new DefaultPieDataset( );
        entries.forEach(entry -> dataset.setValue(entry.getKey(), entry.getValue()));
        return dataset;
    }

    public void display(List<PieChartEntry> entries) {
        display(entries, "Chart title");
    }

    public void display(List<PieChartEntry> entries, String title){
        JFreeChart chart = ChartFactory.createPieChart(
                title,
                createDataset(entries),
                true,
                true,
                false);
        setContentPane(new ChartPanel( chart ));

        this.pack( );
        RefineryUtilities.centerFrameOnScreen( this );
        this.setVisible( true );
    }

}