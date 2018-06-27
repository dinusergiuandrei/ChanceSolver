package app;

import statistics.computing.Integers;
import dataExpert.SqliteDatabase;
import model.Entry;

import java.util.ArrayList;
import java.util.List;

public class LottoSolver {

    public static void main(String args[]) {
        SqliteDatabase sqliteDatabase = new SqliteDatabase();
        List<Entry> entries = sqliteDatabase.getAll();
        //displayEntries(entries);

        List<Integer> mins = new ArrayList<>();
        List<Integer> maxs = new ArrayList<>();

        for (Entry entry : entries) {
            mins.add(Integers.getMin(entry.getNumbers()));
            maxs.add(Integers.getMax(entry.getNumbers()));
        }

        System.out.println("Average minimum: " + Integers.getAverage(mins));
        System.out.println("Average maximum: " + Integers.getAverage(maxs));
    }


}
