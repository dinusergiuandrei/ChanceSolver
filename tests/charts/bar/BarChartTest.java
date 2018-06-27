package charts.bar;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BarChartTest {
    static List<BarChartEntry> source = new ArrayList<>();

    public static void createDataset( ) {
        String fiat = "FIAT";
        String audi = "AUDI";
        String ford = "FORD";
        String speed = "Speed";

        String millage = "Millage";
        String userRating = "User Rating";
        String safety = "safety";

        source.add(new BarChartEntry( 1.0 , fiat , speed ));
        source.add(new BarChartEntry( 3.0 , fiat , userRating ));
        source.add(new BarChartEntry( 5.0 , fiat , millage ));
        source.add(new BarChartEntry( 5.0 , fiat , safety ));

        source.add(new BarChartEntry( 5.0 , audi , speed ));
        source.add(new BarChartEntry( 6.0 , audi , userRating) );
        source.add(new BarChartEntry( 10.0 , audi , millage ));
        source.add(new BarChartEntry( 4.0 , audi , safety ));

        source.add(new BarChartEntry( 4.0 , ford , speed ));
        source.add(new BarChartEntry( 2.0 , ford , userRating ));
        source.add(new BarChartEntry( 3.0 , ford , millage ));
        source.add(new BarChartEntry( 6.0 , ford , safety ));
    }

    public static void main(String args[]) throws AWTException {
        createDataset();
        BarChart barChart = new BarChart("App title");
        barChart.display("Chart title", source, "xLabel", "yLabel");
    }

}