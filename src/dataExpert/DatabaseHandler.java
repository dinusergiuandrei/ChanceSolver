package dataExpert;

import model.Entry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler implements AutoCloseable {
    String databasePath;

    String databaseUrl;

    Connection connection = null;

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

    public void createNewDatabase(String databaseName) {
        try (Connection conn = DriverManager.getConnection(this.databaseUrl)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createNewTable() {
        String url = this.databaseUrl;

        String sql = "CREATE TABLE entries (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	extraction_date date,\n"
                + "	n1 integer,\n"
                + "	n2 integer,\n"
                + "	n3 integer,\n"
                + "	n4 integer,\n"
                + "	n5 integer,\n"
                + "	n6 integer \n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(Integer id, Entry entry) throws Exception{
        String sql = "INSERT INTO entries VALUES(?,?,?,?,?,?,?,?)";

        Connection conn = this.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setString(2, entry.getDate());
        for (int i = 0; i < 6; ++i) {
            statement.setInt(3 + i, entry.getNumbers().get(i));
        }
        statement.executeUpdate();
    }
}
