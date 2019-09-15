package sda.database.dao_impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sda.database.dao.NfcChipDAO;
import sda.database.entity.NfcChip;
import sda.database.hibernate_utils.HibUtils;

import java.util.List;

public class NfcChipDaoImpl implements NfcChipDAO {
    private SessionFactory sF = HibUtils.instance().getSessionFactory();


    @Override
    public void save(NfcChip chip) {
        Session session = sF.getCurrentSession();

        session.beginTransaction();
        session.save(chip);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public NfcChip findByID(int id) {
        Session session = sF.getCurrentSession();
        session.beginTransaction();

         NfcChip chip = (NfcChip) session.createQuery("from NfcChip where id=:id").setParameter("id",id)
                .getSingleResult();

        session.getTransaction().commit();
        session.close();

        return chip;
    }

    @Override
    public List<NfcChip> findAll() {
        Session session = sF.getCurrentSession();
        session.beginTransaction();

        List<NfcChip> list = session.createQuery("from NfcChip").list();

        session.getTransaction().commit();
        session.close();

        return list;
    }

    @Override
    public void update(NfcChip chip) {

    }

    @Override
    public void delete(int id) {
        Session session = sF.getCurrentSession();

        session.beginTransaction();
        session.createQuery("delete NfcChip where id=:id")
                .setParameter("id",id).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
