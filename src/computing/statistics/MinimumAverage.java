package computing.statistics;

import computing.operations.Integers;
import model.Entry;

import java.util.Collection;

public class MinimumAverage implements Calculus {
    @Override
    public Number compute(Collection<Entry> entries) {
        Double minAverage = Double.MAX_VALUE;
        for (Entry entry : entries) {
            Double average = Integers.getAverage(entry.getNumbers());
            minAverage = Math.min(minAverage, average);
        }
        return minAverage;
    }
}
