package jdbcTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.*;

public class CRUD_Practice {


    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/sakila", "root", "12345678");
    Statement statement;
    ResultSet resultSet;

    public CRUD_Practice() throws SQLException {
    }


    @Test
    public void createRecord() throws SQLException {
        int id = 8;
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        int rowsAffected = statement.executeUpdate("INSERT INTO language VALUES (" + id + ",'Spanish',sysdate());");

        System.out.println("rowsAffected = " + rowsAffected);
        readRecord();
    }

    @Test
    public String readRecord() throws SQLException {
        int id =8;
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        resultSet = statement.executeQuery("SELECT * FROM language where language_id = " + id);

        resultSet.next();
        String name = resultSet.getString("name");
        System.out.println("resultSet.getString(\"name\") = " + name);

        return name;
    }

    @Test
    public void updateRecord() throws SQLException {
        String newName = "SPANISH";
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        int rowsAffected = statement.executeUpdate("update language set name = '"+newName+"' where language_id = 8;");

        System.out.println("rowsAffected = " + rowsAffected);

        Assert.assertEquals(readRecord(),newName);
    }

    @Test
    public void deleteRecord() throws SQLException {
        int id =8;
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        int rowsAffected= statement.executeUpdate("delete from language where language_id = "+id);
        System.out.println("rowsAffected = " + rowsAffected);

        Assert.assertEquals(rowsAffected,1);

    }
}
