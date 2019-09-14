package DAOImpl;

import DAO.RunDAO;
import JDBCUtils.JDBCUtils;
import entity.Run;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class JDBCRunDAOTest {

    @BeforeAll
    public static void clearAll() throws SQLException {
        Connection connection = JDBCUtils.instance().getConnection();
        Statement stmt = connection.createStatement();
        stmt.execute("delete from runs");
        stmt.close();

    }

    @Test
    public void saveTest() throws SQLException {
        RunDAO runDAO = new JDBCRunDAO();
        Run run = new Run();
        run.setId(22);
        run.setName("Bababa");
        run.setStartDate(new Date());
        runDAO.save(run);

        Run testRun = runDAO.findByID(22);

        assertEquals(run.getId(), testRun.getId());
        assertEquals(run.getName(),testRun.getName());

    }

    @Test
    public void updateTest() throws SQLException {
        RunDAO runDAO = new JDBCRunDAO();
        Run runSave = new Run();
        runSave.setId(22);
        runSave.setName("Bababa");
        runSave.setStartDate(new Date());
        runDAO.save(runSave);

        Run runUpdate = new Run();
        runSave.setId(22);
        runSave.setName("Kakaka");
        runSave.setStartDate(new Date());
        runDAO.update(runSave);

        Run testRun = runDAO.findByID(22);

        assertEquals(testRun.getId(), runSave.getId());
        assertEquals(testRun.getName(), runSave.getName());
    }

    @Test
    public void deleteTest() throws SQLException {
        RunDAO runDAO = new JDBCRunDAO();
        Run runSave = new Run();
        runSave.setId(22);
        runSave.setName("Bababa");
        runSave.setStartDate(new Date());
        runDAO.save(runSave);

        Run runActual = runDAO.findByID(22);
        assertEquals(runSave.getId(),runActual.getId());

        runDAO.delete(22);
        Run actual = runDAO.findByID(22);

        assertNull(actual);

    }

}