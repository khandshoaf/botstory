package database;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    public static Connection getConnection(){
        Connection c = null;
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(new Driver());

            String jdbcUrl = "jdbc:mySQL://localhost:3306/dbStories";
            String username = "root";
            String password = "123456";

            c = DriverManager.getConnection(jdbcUrl,username,password);
            System.out.println("kết nối thành công đến csdl.");
        } catch (SQLException e) {
            System.out.println("Kết nối thất bại đến csdl.");
            e.printStackTrace();
        }

        return c;
    }

    public static void colseConection(Connection c){
        try {
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
