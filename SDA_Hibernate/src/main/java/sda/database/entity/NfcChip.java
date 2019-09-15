package sda.database.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class NfcChip {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int serial;
    @ManyToMany
    @JoinTable(
            name = "chip_member",
            joinColumns = {@JoinColumn(name = "chip_id")},
            inverseJoinColumns = {@JoinColumn(name = "member_id")})
    private Set<Member> members;


    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }
}
