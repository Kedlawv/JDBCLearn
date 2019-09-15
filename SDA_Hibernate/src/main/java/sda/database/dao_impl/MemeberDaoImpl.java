package sda.database.dao_impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sda.database.dao.MemberDAO;
import sda.database.entity.Member;
import sda.database.hibernate_utils.HibUtils;

import java.util.List;

public class MemeberDaoImpl implements MemberDAO {

    SessionFactory sF = HibUtils.instance().getSessionFactory();

    @Override
    public void save(Member member) {
        Session session = sF.getCurrentSession();
        session.beginTransaction();

        session.save(member);

        session.getTransaction().commit();
        session.close();

    }

    @Override
    public Member findByID(int id) {
        Session session = sF.getCurrentSession();
        session.beginTransaction();
        Member member = (Member) session.createQuery("from Memeber where id=:id").setParameter("id",id)
                .getSingleResult();

        session.getTransaction().commit();
        session.close();

        return member;
    }

    @Override
    public List<Member> findAll() {
        Session session = sF.getCurrentSession();
        session.beginTransaction();

        List<Member> memberList = session.createQuery("from Memeber").list();

        session.getTransaction().commit();
        session.close();

        return memberList;
    }

    @Override
    public void update(Member member) {

    }

    @Override
    public void delete(int id) {

    }
}
