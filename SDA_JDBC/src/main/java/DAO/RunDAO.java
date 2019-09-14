package DAO;

import entity.Run;

import java.sql.SQLException;
import java.util.List;

public interface RunDAO {
    void save(Run run) throws SQLException;
    Run findByID(int id) throws SQLException;
    List<Run> findAll() throws SQLException;
    void update(Run run) throws SQLException;
    void delete(int id) throws SQLException;
}
