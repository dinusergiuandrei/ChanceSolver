package model;

import java.util.List;

public interface Entries {
    static void displayEntries(List<Entry> entries){
        for (Entry entry : entries) {
            System.out.println(entry);
        }
    }
}
