package jdbcTests;

import java.sql.*;

public class BaseConnection {

    public static void main(String[] args) throws SQLException {

        String dbURL = "jdbc:mysql://localhost/sakila";
        String dbUsername = "root";
        String dbPassword = "12345678";

        System.out.println("\t\t ----- DB Baglantisi olusturuluyor -----");
        // create connection - Baglanti olustur
        Connection connection = DriverManager.getConnection(dbURL,dbUsername,dbPassword);

        System.out.println(connection.getMetaData().getDatabaseProductName());


        // create a statement - Query-Sorgu aciklamasi/detayi hazirla
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);



        // run a query and get the results in ResultSet object - Query'i kos ve donen cevabi sakla!!
        ResultSet resultSet = statement.executeQuery("SELECT * FROM customer;");

        resultSet.next(); // 1. satira cursor u getir

        System.out.println("resultSet.getRow() = " + resultSet.getRow());
        System.out.println(resultSet.getRow() + ". Satir First name column value = " + resultSet.getString("first_name"));

        resultSet.next(); // 2. satira cursor u getir

        System.out.println("resultSet.getRow() = " + resultSet.getRow());
        System.out.println(resultSet.getRow() + ". Satir First name column value = " + resultSet.getString("first_name"));
        System.out.println("resultSet.getInt(3) = " + resultSet.getString(4));
        System.out.println("resultSet.getInt(1) CUSTOMER ID Si= " + resultSet.getInt(1));


        resultSet.absolute(10); // 10. satir
        System.out.println("resultSet.getRow() = " + resultSet.getRow());
        System.out.println(resultSet.getRow() + ". Satir First name column value = " + resultSet.getString("first_name"));

//        resultSet.deleteRow();

    }
}
