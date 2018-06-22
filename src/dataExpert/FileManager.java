package dataExpert;

import model.Entry;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    public static List<Entry> getEntriesFromFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        List<Entry> entries = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String date = scanner.next();
            List<Integer> numbers = new ArrayList<>(6);
            for (int i = 0; i < 6; ++i) {
                Integer n = Integer.parseInt(scanner.next());
                numbers.add(n);
            }
            entries.add(new Entry(date, numbers));
        }
        return entries;
    }
}
