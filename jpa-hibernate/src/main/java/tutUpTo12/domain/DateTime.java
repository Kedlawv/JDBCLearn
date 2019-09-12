package tutUpTo12.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

//@Entity
public class DateTime  {

    @Id
    private long id;

    private java.sql.Date date;  // this is a wrapper class for java.util.Date
    private java.sql.Time time;
    private java.sql.Timestamp timestamp;

    @Temporal(TemporalType.DATE)
    private java.util.Date utilDate; // @Temporal + java.util.Date is equivalent to java.sql.Date

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
