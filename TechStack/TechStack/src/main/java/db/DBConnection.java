package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection conn;
    private final String driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/techstack?user=root&password=ljy@.123&useSSL=false";

    public DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        conn = DriverManager.getConnection(url);
    }

    public Connection getConn(){
        return conn;
    }

    public void close() throws SQLException {
        conn.close();
    }

    public static void main(String[] args) {
        try {
            DBConnection connection = new DBConnection();
            connection.close();
            System.out.println("ok");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
