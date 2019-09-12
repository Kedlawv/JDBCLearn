package tutUpTo12.domain;

import javax.persistence.*;

//@Entity
@Table(name = "Pracownicy2Tabele")
@SecondaryTable(name = "adresy", pkJoinColumns = @PrimaryKeyJoinColumn(name = "employeeID"))
public class Employee2Tables {

    // Will create a foreign key in the secondary table
    // We can change the name of the foreign key in the @SecondaryTable
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "imie")      // if we don't specify the table name in the @Column annotation
    private String firstName;   // the column will be added to the primary @Table

    @Column(name = "nazwisko")
    private String lastName;

    @Column(name = "pensja")
    private double salary;


    @Column(table = "adresy", name = "miejscowosc")     //adding table argument in the column
    private String locality;                            //annotation will put that column in the
    //                                                  //@SecondaryTable
    @Column(table = "adresy", name = "kod_pocztowy")
    private String zipcode;

    @Column(table = "adresy", name = "ulica")
    private String street;

    //column names cannot contain spaces, will cause SQL syntax error !!
    @Column(table = "adresy", name = "numer_domu")
    private int streetNumber;

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

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }
}
