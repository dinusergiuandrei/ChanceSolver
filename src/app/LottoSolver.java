package app;

import dataExpert.DatabaseHandler;
import model.Entry;

import java.util.List;

public class LottoSolver {
    static String sourcePath = "source.txt";

    static String databasePath = "database/lotto_archive.db";

    public static void main(String args[]) {
        List<Entry> entries = loadEntries();
        displayEntries(entries);
    }

    public static List<Entry> loadEntries(){
        DatabaseHandler databaseHandler = new DatabaseHandler(databasePath);
        return databaseHandler.selectAll();
    }

    public static void displayEntries(List<Entry> entries){
        for (Entry entry : entries) {
            System.out.println(entry);
        }
    }

}
