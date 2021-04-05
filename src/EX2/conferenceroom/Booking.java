package EX2.conferenceroom;

import java.util.Date;

public class Booking {

    private Integer bookingId;
    private Date startDate;
    private Integer duration; //Specified in minutes

    public Booking(Integer bookingId, Date startDate, Integer duration) {
        this.bookingId = bookingId;
        this.duration = duration;
        this.startDate = startDate;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setStartDate(Date date) {
        this.startDate = date;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
