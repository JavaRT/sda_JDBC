package ex1;

import java.sql.*;
import static ex1.Config.*;

public class Main3 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = connection.createStatement();

        statement.executeUpdate("CREATE TABLE IF NOT EXISTS user(id BIGINT NOT NULL AUTO_INCREMENT, " +
                "username VARCHAR(50), " +
                "password VARCHAR(50), " +
                "PRIMARY KEY(id))");

        statement.executeUpdate("INSERT INTO user(username,password) VALUES " +
                "('JAN0', 'password0')," +
                "('JAN1', 'password1')," +
                "('JAN2', 'password2')," +
                "('JAN3', 'password3')," +
                "('JAN4', 'password4')");

        ResultSet resultSet = statement.executeQuery("select username from user");
        while (resultSet.next()){
           String username =  resultSet.getString("username");
            System.out.println(username);
    }
statement.executeUpdate("Delete from user");
        statement.close();
        connection.close();
    }
}