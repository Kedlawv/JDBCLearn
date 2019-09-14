package DAOImpl;

import DAO.RunDAO;
import JDBCUtils.JDBCUtils;
import entity.Run;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCRunDAO implements RunDAO {

    private Connection connection = JDBCUtils.instance().getConnection();

    @Override
    public void save(Run run) throws SQLException {
        PreparedStatement  statement = connection
                .prepareStatement("insert into runs(id,name,start_date)" +
                        "values(?, ?, ?)");
        statement.setInt(1, run.getId());
        statement.setString(2,run.getName() );

        java.sql.Date dateSQL = new java.sql.Date(run.getStartDate().getTime());

        statement.setDate(3,dateSQL);

        statement.execute();
        statement.close();

    }

    @Override
    public Run findByID(int id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery
                ("select * from runs where id = " + id);

        if(resultSet.next()){
            Run run = new Run();
            run.setId(resultSet.getInt("id"));
            run.setName((resultSet.getString("name")));
            java.sql.Date dateSQL = resultSet.getDate("start_date");
            java.util.Date dateUtil = new java.util.Date(dateSQL.getTime());
            run.setStartDate(dateUtil);
            return run;
        }
        return null;
    }

    @Override
    public List<Run> findAll() throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from runs");

        List<Run> runList = new ArrayList<>();

        while(resultSet.next()){
            Run run = new Run();
            run.setId(resultSet.getInt("id"));
            run.setName((resultSet.getString("name")));
            java.sql.Date dateSQL = resultSet.getDate("start_date");
            java.util.Date dateUtil = new java.util.Date(dateSQL.getTime());
            run.setStartDate(dateUtil);

            runList.add(run);
        }

        return runList;

    }

    @Override
    public void update(Run run) throws SQLException {
        PreparedStatement  statement = connection
                .prepareStatement("update runs set name = ?, start_date = ? where id = ?");

        statement.setString(1,run.getName() );

        java.sql.Date dateSQL = new java.sql.Date(run.getStartDate().getTime());
        statement.setDate(2,dateSQL);
        statement.setInt(3, run.getId());



        statement.execute();
        statement.close();

    }

    @Override
    public void delete(int id) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("delete from runs where id = " + id);

        stmt.close();

    }
}
