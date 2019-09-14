package DAO;

import entity.Member;

import java.sql.SQLException;
import java.util.List;

public interface MemberDAO {
    void save(Member member) throws SQLException;
    Member findByID(int id) throws SQLException;
    List<Member> findAll() throws SQLException;
    void update(Member member) throws SQLException;
    void delete(int id) throws SQLException;
}
