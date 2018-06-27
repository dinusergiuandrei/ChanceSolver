package computing.statistics;

import computing.operations.Integers;
import model.Entry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AverageMinimum implements Calculus{
    @Override
    public Number compute(Collection<Entry> entries) {
        List<Integer> mins = new ArrayList<>();
        for (Entry entry : entries) {
            mins.add(Integers.getMin(entry.getNumbers()));
        }
        return Integers.getAverage(mins);
    }
}
