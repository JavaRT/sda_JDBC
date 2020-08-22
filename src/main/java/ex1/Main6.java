package ex1;

import java.sql.*;

import static ex1.Config.*;

public class Main6 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println(login("jan", "pas1", connection));
        System.out.println(login("ala", "wrongPassword", connection));
    }

    private static boolean securedLogin(String username, String password, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from user where username = ? and password=?");
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean isLogged = resultSet.next();
        preparedStatement.close();

        return isLogged;
    }

    private static boolean login(String username, String password, Connection connection) throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(" SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'");
        boolean isLogged = resultSet.next();
        statement.close();

        return isLogged;

    }
}