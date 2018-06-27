package dataExpert;

import model.Entry;
import org.junit.Assert;
import org.junit.Test;
import utils.TimeKeeper;

import java.sql.*;
import java.util.List;

public class SqliteDatabaseTest {

    SqliteDatabase sqliteDatabase = new SqliteDatabase();

    @Test
    public void getConnectionTest() {
        TimeKeeper timeKeeper = new TimeKeeper();
        sqliteDatabase.getConnection();
        Long createTime = timeKeeper.toc();
        timeKeeper.tic();
        sqliteDatabase.getConnection();
        Long getTime = timeKeeper.toc();
        Assert.assertTrue(getTime < createTime);
    }

    @Test
    public void createConnectionTest() throws SQLException {
        Connection connection = sqliteDatabase.getConnection();
        Assert.assertTrue(!connection.isClosed());
    }

    @Test
    public void getAllTest() {
        List<Entry> entries = sqliteDatabase.getAll();
        Assert.assertTrue(entries.size() > 0);
    }

    @Test
    public void closeConnectionTest() throws SQLException {
        sqliteDatabase.getConnection();
        sqliteDatabase.close();
        Assert.assertTrue(sqliteDatabase.getConnection().isClosed());
    }
}
