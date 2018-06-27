package computing.statistics;

import computing.operations.Integers;
import model.Entry;

import java.util.Collection;

public class MaximumAverage implements Calculus {
    @Override
    public Number compute(Collection<Entry> entries) {
        Double maxAverage = 0.0;
        for (Entry entry : entries) {
            Double average = Integers.getAverage(entry.getNumbers());
            maxAverage = Math.max(maxAverage, average);
        }
        return maxAverage;
    }
}
