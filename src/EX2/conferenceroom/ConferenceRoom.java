package EX2.conferenceroom;

import java.util.*;

public class ConferenceRoom {

    private List<Room> rooms = new ArrayList<>();

    public void createRoomsData() {
        Room room1 = new Room(1, 10);
        Room room2 = new Room(2, 5);
        Room room3 = new Room(3, 4);
        rooms.addAll(Arrays.asList(room1, room2, room3));

        Booking booking1 = new Booking(1, new Date(2021,5,5,13,0), 45);
        Booking booking2 = new Booking(2, new Date(2021,5,7,10,0), 120);
        Booking booking3 = new Booking(3, new Date(2021,5,7,11,0), 30);
        room1.addBooking(booking1);
        room1.addBooking(booking2);
        room1.addBooking(booking3);

        System.out.println("\nBookings added:");
        rooms.get(0).getBookings().forEach(booking ->
                System.out.println("Booking " + booking.getBookingId() + ", Date: " + booking.getStartDate() + ", Duration: " + booking.getDuration()));

    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public List<Booking> getBookingsByRoomId(Integer roomId) {
        Optional<Room> roomSelected = rooms.stream()
                .filter(room -> room.getRoomId().equals(roomId))
                .findFirst();
        return roomSelected.map(Room::getBookings).orElse(null);
    }
}
