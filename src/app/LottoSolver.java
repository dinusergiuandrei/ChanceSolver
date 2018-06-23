package app;

import dataExpert.DatabaseHandler;
import model.Entry;

import java.util.List;

import static model.Entries.displayEntries;

public class LottoSolver {

    public static void main(String args[]) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        List<Entry> entries = databaseHandler.getAll();
        displayEntries(entries);
    }
}
