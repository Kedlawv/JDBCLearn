package sda.database.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private int startID;

    @ManyToMany(mappedBy = "members")
    private Set<NfcChip> chips;



    @ManyToOne
    @JoinColumn(name = "run_id")
    private Run run;

    public Run getRun() {
        return run;
    }

    public void setRun(Run run) {
        this.run = run;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartID() {
        return startID;
    }

    public void setStartID(int startID) {
        this.startID = startID;
    }

}
