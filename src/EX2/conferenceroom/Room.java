package EX2.conferenceroom;

import EX2.conferenceroom.Booking;

import java.util.*;
import java.util.stream.IntStream;

public class Room {

    private static final Integer MIN_DURATION = 15;
    private static final Integer MAX_DURATION = 180;

    private Integer roomId;
    private Integer maxParticipants;
    private List<Booking> bookings = new ArrayList<>();

    public Room(Integer roomId, Integer maxParticipants) {
        this.roomId = roomId;
        this.maxParticipants = maxParticipants;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public Integer getMaxParticipants() {
        return maxParticipants;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking booking) {
        if (hasCorrectDuration(booking.getDuration()) && !overlap(booking)) {
            this.bookings.add(booking);
        } else {
            System.out.println("Booking " + booking.getBookingId() + " overlapped");
        }
        // At this point it means the new booking overlaps with another one so the booking is not added to the room's booking.
        // I can throw an exception telling the booking cannot be added.
    }

    private boolean overlap(Booking booking) {
        //This method can be improved using Java 8 streams like used in other cases
        for (Booking filteredBooking: bookings) {
            Date filteredBookingFinishDate = getDateWithAddedMinutes(filteredBooking.getStartDate(), filteredBooking.getDuration());
            Date bookingFinishDate = getDateWithAddedMinutes(filteredBooking.getStartDate(), filteredBooking.getDuration());
            if ((booking.getStartDate().before(filteredBookingFinishDate) && booking.getStartDate().after(filteredBooking.getStartDate())) ||
                    (bookingFinishDate.before(filteredBookingFinishDate) && bookingFinishDate.after(filteredBooking.getStartDate()))) {
                return true;
            }
        }
        return false;
    }

    private Date getDateWithAddedMinutes(Date date, Integer minutes) {
        final long ONE_MINUTE_IN_MILLIS = 60000;
        long time = date.getTime();
        return new Date(time + (minutes * ONE_MINUTE_IN_MILLIS));
    }

    private boolean hasCorrectDuration(Integer bookingDuration) {
        return bookingDuration >= MIN_DURATION && bookingDuration <= MAX_DURATION;
    }

    public void editBookingDateById(Date startDate, Integer bookingId) {
        OptionalInt bookingIndex = getBookingIndexById(bookingId);
        bookingIndex.ifPresent(index -> bookings.get(index).setStartDate(startDate));
    }

    public void editBookingDurationById(Integer duration, Integer bookingId) {
        OptionalInt bookingIndex = getBookingIndexById(bookingId);
        bookingIndex.ifPresent(index -> bookings.get(index).setDuration(duration));
    }

    private OptionalInt getBookingIndexById(Integer bookingId) {
        return IntStream.range(0, bookings.size())
                .filter(i -> bookings.get(i).getBookingId().equals(bookingId))
                .findFirst();
    }

}
