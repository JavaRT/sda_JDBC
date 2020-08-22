package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static ex1.Config.*;

public class Main5 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        List<String> username = List.of("jan", "ala", "Mikol", "ola");
        List<String> passwords = List.of("pas1", "pas2", "pas3", "pas4");

        if (username.size() != passwords.size()){
            throw new RuntimeException("messange");
        }

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT into user(username, password) VALUE (?, ?)");

        for (int i = 0; i < 4; i++) {
        preparedStatement.setString(1, username.get(i));
        preparedStatement.setString(2, passwords.get(i));
        preparedStatement.executeUpdate();
    }
        preparedStatement.close();
        connection.close();

    }
}
