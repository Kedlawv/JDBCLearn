package private_stuff;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/sql_store";
        String user = "root";
        String pass;

        Scanner sc = new Scanner(System.in);
        System.out.println("password: \n");
        pass = sc.next();

        try {
            Connection myConn = DriverManager.getConnection(dbURL, user, pass);
            Statement myStm = myConn.createStatement();
            ResultSet myRs = myStm.executeQuery("SELECT * FROM customers");
            while (myRs.next()) {
                System.out.println(myRs.getString("first_name") + " "
                        + myRs.getString("last_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

