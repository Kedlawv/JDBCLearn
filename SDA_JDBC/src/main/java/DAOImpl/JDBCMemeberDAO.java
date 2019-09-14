package DAOImpl;

import DAO.MemberDAO;
import entity.Member;

import java.sql.SQLException;
import java.util.List;

public class JDBCMemeberDAO implements MemberDAO {
    @Override
    public void save(Member member) throws SQLException {

    }

    @Override
    public Member findByID(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Member> findAll() throws SQLException {
        return null;
    }

    @Override
    public void update(Member member) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
