import java.sql.*;

/**
 * Created by dima on 28.03.17.
 */
public class Statements {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://127.0.0.1:5432/javadb";

        Connection connection =
                DriverManager.getConnection(url, "postgres", "1");
        if(connection == null){
            System.exit(0);
        }
        //Statement statement = connection.createStatement();
        /*String sql = "INSERT INTO my_users (name, lastname) VALUES ('Vasyl', 'Pupkin')";
        statement.execute(sql);*/

        /*String sql = "SELECT * FROM my_users";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2)
            + " " + resultSet.getString(3));
        }
        statement.close();*/

        String sql = "INSERT INTO my_users (name, lastname) VALUES (?, ?)";
        PreparedStatement preparedStatement;
        //preparedStatement = connection.prepareStatement(sql);
        /*preparedStatement.setString(1, "Petro");
        preparedStatement.setString(2, "Petrov");
        preparedStatement.execute();*/

        String sql1 = "SELECT * FROM my_users WHERE id=?";
        preparedStatement = connection.prepareStatement(sql1);
        preparedStatement.setInt(1, 1);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2)
                    + " " + resultSet.getString(3));
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
