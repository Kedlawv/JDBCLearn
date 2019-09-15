package sda.database.dao;


import sda.database.entity.Run;

import java.util.List;

public interface RunDAO {
    void save(Run run);
    Run findByID(int id);
    List<Run> findAll();
    void update(Run run);
    void delete(int id);
}
