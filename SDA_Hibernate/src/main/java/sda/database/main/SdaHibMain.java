package sda.database.main;

import sda.database.dao.MemberDAO;
import sda.database.dao.NfcChipDAO;
import sda.database.dao.RunDAO;
import sda.database.dao_impl.MemeberDaoImpl;
import sda.database.dao_impl.NfcChipDaoImpl;
import sda.database.dao_impl.RunDaoImpl;
import sda.database.entity.Member;
import sda.database.entity.NfcChip;
import sda.database.hibernate_utils.HibUtils;

import java.util.ArrayList;

public class SdaHibMain {
    public static void main(String[] args) {

        MemberDAO memberDAO = new MemeberDaoImpl();
        RunDAO runDAO = new RunDaoImpl();
        NfcChipDAO chipDAO= new NfcChipDaoImpl();



        HibUtils.instance().getSessionFactory().close();

    }

    public static void memberTest(){
        MemberDAO memberDAO = new MemeberDaoImpl();
        Member member1 = new Member();
        member1.setStartID(234);
        member1.setName("Dariusz");

        Member member2 = new Member();
        member2.setName("Bakura");
        member2.setStartID(457);

        memberDAO.save(member1);
        memberDAO.save(member2);
    }

    public static void chipTest(){
        ArrayList<NfcChip> chips = new ArrayList<>();
        ArrayList<Member> members = new ArrayList<>();

        NfcChipDAO chipDao = new NfcChipDaoImpl();
        MemberDAO memberDAO = new MemeberDaoImpl();

        for(int i = 0; i<5; i++){
            NfcChip chip = new NfcChip();
            Member member = new Member();
            chip.setSerial(i);
            member.setName("Member" + i);
            chipDao.save(chip);
            memberDAO.save(member);


        }
    }


}
