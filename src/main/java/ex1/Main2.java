package ex1;

import java.sql.*;

public class Main2 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(Config.URL, Config.USER, Config.PASSWORD);
        Statement statementOne = connection.createStatement();
        int amount = statementOne.executeUpdate("UPDATE animal SET name = 'Jasio' WHERE id = 2");
        System.out.println(amount);
        statementOne.close();

        Statement statementTwo = connection.createStatement();
        boolean execute = statementTwo.execute("SELECT * FROM animal");
        System.out.println(execute);
        statementTwo.close();

        connection.close();
    }
}
