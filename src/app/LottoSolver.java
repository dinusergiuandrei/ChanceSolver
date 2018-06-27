package app;

import computing.operations.Integers;
import computing.printing.BubbleChartEntryAdaptor;
import computing.statistics.MaximumAverage;
import computing.statistics.MinimumAverage;
import dataExpert.SqliteDatabase;
import model.Entry;

import java.util.ArrayList;
import java.util.List;

import static model.Entries.displayEntries;

public class LottoSolver {

    public static void main(String args[]) {
        SqliteDatabase sqliteDatabase = new SqliteDatabase();
        List<Entry> entries = sqliteDatabase.getAll();
        BubbleChartEntryAdaptor.print(entries);
    }
}
