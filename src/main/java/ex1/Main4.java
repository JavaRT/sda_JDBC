package ex1;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.mysql.cj.xdevapi.Result;

import java.sql.*;

import static ex1.Config.*;

public class Main4 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT age FROM animal where name = ?");
        preparedStatement.setString(1, "benio");

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int age = resultSet.getInt("age");
            System.out.println(age);
        }
        preparedStatement.close();
        connection.close();

    }
}