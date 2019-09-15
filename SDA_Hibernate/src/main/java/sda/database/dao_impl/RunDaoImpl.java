package sda.database.dao_impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sda.database.dao.RunDAO;
import sda.database.entity.Run;
import sda.database.hibernate_utils.HibUtils;

import java.util.List;

public class RunDaoImpl implements RunDAO {

    private SessionFactory sF = HibUtils.instance().getSessionFactory();


    @Override
    public void save(Run run) {

        Session session = sF.getCurrentSession();

        session.beginTransaction();
        session.save(run);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Run findByID(int id) {

        Session session = sF.getCurrentSession();
        session.beginTransaction();

        Run run = (Run) session.createQuery("from Run where id=:id").setParameter("id",id)
                .getSingleResult();

        session.getTransaction().commit();
        session.close();

        return run;
    }

    @Override
    public List<Run> findAll() {
        Session session = sF.getCurrentSession();
        session.beginTransaction();

        List<Run> list = session.createQuery("from Run").list();

        session.getTransaction().commit();
        session.close();

        return list;

    }

    @Override
    public void update(Run run) {

    }

    @Override
    public void delete(int id) {

        Session session = sF.getCurrentSession();

        session.beginTransaction();
        session.createQuery("delete Run where id=:id")
                .setParameter("id",id).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
