import java.sql.*;

/**
 * Created by dima on 02.04.17.
 */
public class TransactionIsolationLevel {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://127.0.0.1:5432/javadb";
        Connection connection = DriverManager.getConnection(url, "postgres", "1");

        /*Statement statement = connection.createStatement();
        statement.addBatch("INSERT INTO my_users (name, lastname) VALUES('Ivan', 'Ivanov')");
        statement.addBatch("INSERT INTO my_users (name, lastname) VALUES('Ivan1', 'Ivanov1')");
        statement.addBatch("INSERT INTO my_users (name, lastname) VALUES('Ivan2', 'Ivanov2')");
        int res[] = statement.executeBatch();
        for(int i : res){
            System.out.println(i);
        }*/

        /*connection.setAutoCommit(false);
        Statement statement1 = connection.createStatement();
        Statement statement2 = connection.createStatement();
        try {
            statement1.execute("INSERT INTO my_users (name, lastname) VALUES('Ivan6', 'Ivanov6')");
            statement2.execute("INSERT INTO my_users (name, lastname) VALUES('Ivan7', 'Ivanov7')");
            //ne khorosho:
            //connection.setAutoCommit(true);
        } catch (SQLException e){
            connection.rollback();
        } finally {
            connection.commit();
            connection.close();
        }*/

        /*Savepoint savepoint = null;
        connection.setAutoCommit(false);
        Statement statement1 = connection.createStatement();
        Statement statement2 = connection.createStatement();
        try {
            statement1.execute("INSERT INTO my_users (name, lastname) VALUES('Ivan9', 'Ivanov9')");
            savepoint = connection.setSavepoint();
            statement2.execute("INSERT INTO my_users (name, lastname) VALUsES('Ivan10', 'Ivanov10')");
        } catch (SQLException e){
            connection.rollback(savepoint);
        } finally {
            connection.commit();
            connection.close();
        }*/

        //connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        System.out.println(connection.getTransactionIsolation() == Connection.TRANSACTION_READ_COMMITTED);

        DatabaseMetaData databaseMetaData = connection.getMetaData();
        System.out.println(databaseMetaData.supportsTransactionIsolationLevel(Connection.TRANSACTION_READ_UNCOMMITTED));

        ResultSet resultSet = databaseMetaData
                .getTables("javadb", null, "my_users", null);
        while (resultSet.next()){
            System.out.println(resultSet.getString(4));
        }
    }
}
