import java.time.LocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Date;

public class Reminder {
    private Date date = new Date();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
