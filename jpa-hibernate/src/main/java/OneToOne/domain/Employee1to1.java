package OneToOne.domain;


import javax.persistence.*;

@Entity
public class Employee1to1 {

    @Id @GeneratedValue
    private long id;

    private String firstName;
    private String lastName;
    private double salary;

    @OneToOne
    @JoinColumn(name = "addressId")
    private Address1to1 address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Address1to1 getAddress() {
        return address;
    }

    public void setAddress(Address1to1 address) {
        this.address = address;
    }
}
