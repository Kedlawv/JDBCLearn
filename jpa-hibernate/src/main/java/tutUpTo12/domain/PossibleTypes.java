package tutUpTo12.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.math.BigInteger;

//@Entity
public class PossibleTypes {

    @Id
    private int id;

    // we can put any type into the DB as long as it implements Serializable

    private int someInt;            //primitive types
    private short someShort;
    private float someFloat;
    private double someDouble;
    private boolean someBoolean;

    private Integer classInteger;   // class types / wrapper types
    private BigInteger bigInteger;
    private BigDecimal bigDecimal;

    private int[] intArray;         //arrays
    private double[] doubleArray;

    private MyEnum myEnum;

    @Transient                     // @Transient will let Hibernate know to ignore this field
    private int ignoredFiled;


    public int getIgnoredFiled() {
        return ignoredFiled;
    }

    public void setIgnoredFiled(int ignoredFiled) {
        this.ignoredFiled = ignoredFiled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSomeInt() {
        return someInt;
    }

    public void setSomeInt(int someInt) {
        this.someInt = someInt;
    }

    public short getSomeShort() {
        return someShort;
    }

    public void setSomeShort(short someShort) {
        this.someShort = someShort;
    }

    public float getSomeFloat() {
        return someFloat;
    }

    public void setSomeFloat(float someFloat) {
        this.someFloat = someFloat;
    }

    public double getSomeDouble() {
        return someDouble;
    }

    public void setSomeDouble(double someDouble) {
        this.someDouble = someDouble;
    }

    public boolean isSomeBoolean() {
        return someBoolean;
    }

    public void setSomeBoolean(boolean someBoolean) {
        this.someBoolean = someBoolean;
    }

    public Integer getClassInteger() {
        return classInteger;
    }

    public void setClassInteger(Integer classInteger) {
        this.classInteger = classInteger;
    }

    public BigInteger getBigInteger() {
        return bigInteger;
    }

    public void setBigInteger(BigInteger bigInteger) {
        this.bigInteger = bigInteger;
    }

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

    public int[] getIntArray() {
        return intArray;
    }

    public void setIntArray(int[] intArray) {
        this.intArray = intArray;
    }

    public double[] getDoubleArray() {
        return doubleArray;
    }

    public void setDoubleArray(double[] doubleArray) {
        this.doubleArray = doubleArray;
    }

    public MyEnum getMyEnum() {
        return myEnum;
    }

    public void setMyEnum(MyEnum myEnum) {
        this.myEnum = myEnum;
    }
}
