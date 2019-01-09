package phone.sql;

import phone.method.AppProperties;
import phone.method.PropertiesLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlConnection {
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    String query;
    AppProperties appProperties = PropertiesLoader.loadProperties();
    private final String SQL_USER=appProperties.getImagePath("sqlUser");
    private final String SQL_PASSWORD=appProperties.getImagePath("sqlPassword");
    private final String SQL_DATABASE=appProperties.getImagePath("sqlDatabase");

    public SqlConnection() {
        connectUpdate(addQuery(SQL_USER,SQL_PASSWORD));
    }

    public void connectUpdate(String query) {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            connection = DriverManager.getConnection(SQL_DATABASE, SQL_USER,SQL_PASSWORD);
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public String addQuery(String user_name, String pass){
        query = "insert into Table1 values('" + user_name + "','" + pass + "')";
        return query;
    }

}