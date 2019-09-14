import DAO.RunDAO;
import DAOImpl.JDBCRunDAO;
import JDBCUtils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class MainDAO {
    public static void main(String[] args) throws SQLException {

        Connection connection = JDBCUtils.instance().getConnection();
        RunDAO runDao = new JDBCRunDAO();

//        Run run = new Run();
//        run.setId(5);
//        run.setName("Super Marathon");
//        run.setStartDate(new Date());
//
//        runDao.save(run);





    }

}
