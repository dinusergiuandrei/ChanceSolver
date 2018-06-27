package computing.statistics;

import computing.operations.Integers;
import model.Entry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AverageMaximum implements Calculus {
    @Override
    public Number compute(Collection<Entry> entries) {
        List<Integer> maximums = new ArrayList<>();
        for (Entry entry : entries) {
            maximums.add(Integers.getMin(entry.getNumbers()));
        }
        return Integers.getAverage(maximums);
    }
}
