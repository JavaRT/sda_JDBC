package ex1;

import javax.xml.transform.Result;
import java.math.BigDecimal;
import java.sql.*;

public class Main1 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_schema?serverTimezone=Europe/Warsaw", "root", "qwerty147258369");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM animal");
        while (resultSet.next()) {
            BigDecimal id = resultSet.getBigDecimal(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            System.out.println(String.format("Id:%s, name:%s, age:%s", id, name, age));
        }
        statement.close();
        connection.close();
    }
}