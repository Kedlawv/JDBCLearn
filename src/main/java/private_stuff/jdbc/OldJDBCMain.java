package private_stuff.jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.util.Scanner;



public class OldJDBCMain {
    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/mojabaza?serverTimezone=UTC";
        String user = "root";
        String password = "abc123";

        driverManagerTest(dbURL, user, password);
        //mySQLDataSourceTest(dbURL,user);



    }

    public static void driverManagerTest(String dbURL, String user,String password) {
        try (Connection myConn = DriverManager.getConnection(dbURL, user, password)){
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

    //todo no errors but no output either
    public static void mySQLDataSourceTest(String dbURL, String user ){
        MysqlDataSource mDS = new MysqlDataSource();

        mDS.setURL(dbURL);
        mDS.setURL(user);
        mDS.setPassword(getPassword());
        try (Connection myConn = mDS.getConnection()) {
            Statement myStm = myConn.createStatement();
            ResultSet myRs = myStm.executeQuery("SELECT * FROM customers");
            while (myRs.next()) {
                System.out.println(myRs.getString("first_name") + " "
                        + myRs.getString("last_name"));
            }
        }catch(SQLException e){

        }
    }

    public static String getPassword(){
        Scanner sc = new Scanner(System.in);
        System.out.println("password: \n");

        return sc.next();
    }
}


