import JDBCUtils.JDBCUtils;

import java.sql.*;

public class MainNoDAO {
    public static void main(String[] args) throws SQLException {

        Connection connection = JDBCUtils.instance().getConnection();

        Statement stmt = connection.createStatement();

        stmt.executeUpdate("delete from runs");

        stmt.executeUpdate("INSERT INTO runs (id, name, start_date)" +
                " VALUE(1,'Rzeszow Maraton','2019-08-08')");
        stmt.executeUpdate("INSERT INTO runs (id, name, start_date)" +
                " VALUE(2,'PKO Maraton','2019-09-12')");
        stmt.executeUpdate("INSERT INTO runs (id, name, start_date)" +
                " VALUE(3,'Sii Pol Maraton','2019-11-22')");

        ResultSet datesRs = stmt.executeQuery("select start_date from runs");

        while(datesRs.next()){
            Date start_date = datesRs.getDate("start_date");
            System.out.println(start_date);
        }

        stmt.close();


    }
}
