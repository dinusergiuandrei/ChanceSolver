package dataExpert;

import model.Entry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler implements AutoCloseable {
    private String databasePath;

    private String databaseUrl;

    private Connection connection = null;

    public DatabaseHandler(String databasePath) {
        this.databasePath = databasePath;
        this.databaseUrl = "jdbc:sqlite:" + this.databasePath;
    }

    public Connection getConnection() {
        if (this.connection != null) {
            return this.connection;
        } else {
            this.connection = this.createConnection();
            return this.connection;
        }
    }

    private Connection createConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(this.databaseUrl);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
        return conn;
    }

    public List<Entry> selectAll() {
        String sql = "SELECT id, extraction_date, n1, n2, n3, n4, n5, n6 FROM entries";
        List<Entry> entries = new ArrayList<>();
        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String extraction_date = rs.getString("extraction_date");

                List<Integer> numbers = new ArrayList<>(6);
                numbers.add(rs.getInt("n1"));
                numbers.add(rs.getInt("n2"));
                numbers.add(rs.getInt("n3"));
                numbers.add(rs.getInt("n4"));
                numbers.add(rs.getInt("n5"));
                numbers.add(rs.getInt("n6"));

                Entry newEntry = new Entry(extraction_date, numbers);
                newEntry.setId(id);

                entries.add(newEntry);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return entries;
    }

    @Override
    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
