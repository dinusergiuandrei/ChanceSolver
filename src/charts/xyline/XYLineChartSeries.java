package charts.xyline;

import org.jfree.data.xy.XYSeries;

import java.util.List;

public class XYLineChartSeries {

    private XYSeries series;

    public XYLineChartSeries() {
        this("Series Title");
    }

    public XYLineChartSeries(String seriesTitle) {
        this.series = new XYSeries(seriesTitle);
    }

    public void add(XYLineChartEntry entry){
        this.series.add(entry.getX(), entry.getY());
    }

    public void addAll(List<XYLineChartEntry> entries){
        entries.forEach(entry->series.add(entry.getX(), entry.getY()));
    }

    public XYSeries getSeries() {
        return series;
    }
}
