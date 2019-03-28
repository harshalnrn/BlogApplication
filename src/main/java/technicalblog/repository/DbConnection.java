package technicalblog.repository;

import java.sql.*;

public class DbConnection {


    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public ResultSet connectToDb() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bloggingApplication", "postgres", "Kvihar@24");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from posts");

        } catch (ClassNotFoundException e) {
        } catch (SQLException e) {
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {

            }
        }
        return resultSet;
    }


}
