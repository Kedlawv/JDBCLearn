package JDBCUtils;

import java.sql.*;

public class JDBCUtils {
    private static JDBCUtils instance;
    private Connection conn;

    public static JDBCUtils instance(){
        if(instance == null){
            instance = new JDBCUtils();
        }
        return instance;
    }

    private JDBCUtils(){
        String url = "jdbc:mysql://localhost:3306/mojabaza?serverTimezone=Europe/Warsaw";
        try {
            conn = DriverManager.getConnection(url,"root","abc123");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conn;
    }
}
