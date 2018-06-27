package charts.time;

import org.jfree.data.time.RegularTimePeriod;

public class TimeSeriesEntry {
    private RegularTimePeriod timePeriod;

    private Number value;

    public TimeSeriesEntry(RegularTimePeriod timePeriod, Number value) {
        this.timePeriod = timePeriod;
        this.value = value;
    }

    public RegularTimePeriod getTimePeriod() {
        return timePeriod;
    }

    public Number getValue() {
        return value;
    }
}
