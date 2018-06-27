package computing.statistics;

import model.Entry;

import java.util.Collection;

public interface Calculus {
    Number compute(Collection<Entry> entries);
}
