package sda.database.dao;

import sda.database.entity.Member;

import java.util.List;

public interface MemberDAO {
    void save(Member member);
    Member findByID(int id);
    List<Member> findAll();
    void update(Member member);
    void delete(int id);
}
