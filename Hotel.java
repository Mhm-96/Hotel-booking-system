import java.util.Arrays;
import java.util.ArrayList;

public class Hotel 
{
    private String name;
    private Room[] rooms;
    private Customer[] customers;
    private Booking[] bookings;
    public Hotel(String name) 
    {
        this.name = name;
    }

    public void AddRoom(Room room)
    {
        if(rooms == null)
        {
            rooms = new Room[1];
            rooms[rooms.length-1] = room; 
        }
        else
        {
            rooms = Arrays.copyOf(rooms, rooms.length+1);
            rooms[rooms.length-1] = room;
        }
    }
    
    public void AddRoom(String roomNumber,String roomType)
    {
        if(rooms == null)
        {
            rooms = new Room[1];
            rooms[rooms.length-1] = new Room(roomNumber, roomType); 
        }
        else
        {
            rooms = Arrays.copyOf(rooms, rooms.length+1);
            rooms[rooms.length-1] = new Room(roomNumber, roomType); 
        }
    }

    public void AddCustomer(Customer customer) 
    {
        if(customers == null)
        {
            customers = new Customer[1];
            customers[customers.length-1] = customer; 
        }
        else
        {
            customers = Arrays.copyOf(customers, customers.length+1);
            customers[customers.length-1] = customer;
        }
    }

    public Room[] checkAvailableRooms() {
        ArrayList<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room != null && !room.isRoomBooked()) {
                availableRooms.add(room);
            }
        }
        return availableRooms.toArray(new Room[0]);
    }

    public void createBooking(String bookingID, Customer customer, Room[] roomsToBook) 
    {
        
        for (Room room : roomsToBook) 
        {
            customer.bookRoom(room);
        }

        if(bookings == null)
        {
            bookings = new Booking[1]; 
            bookings[bookings.length-1] = new Booking(bookingID, customer, roomsToBook);
        }
        else
        {
            bookings = Arrays.copyOf(bookings, bookings.length+1);
            bookings[bookings.length-1] = new Booking(bookingID, customer, roomsToBook);
        }
    }

    public void displayBookingsForCustomer(String customerID) {
        for (Booking booking : bookings) {
            if (booking.getCustomer().getCustomerID().equals(customerID)) {
                System.out.println("Booking ID: " + booking.getBookingID());
                for (Room room : booking.getRooms()) {
                    System.out.println("Room: " + room.getRoomNumber() + " (" + room.getRoomType() + ")");
                }
            }
        }
    }

    public void cancelBooking(String bookingID) {
        Booking bookingToCancel = null;
        for (Booking booking : bookings) {
            if (booking.getBookingID().equals(bookingID)) {
                bookingToCancel = booking;
                break;
            }
        }
        if (bookingToCancel != null) 
        {
            int index = 0;
            for (Room room : bookingToCancel.getRooms()) {
                room.cancelbooking();
            }
            
            for(Booking booking : bookings)
            {
                if(booking.getBookingID() == bookingToCancel.getBookingID())
                {
                    bookings[index] = new Booking(null, null, null);
                }
                index++;
            }
        } 
        else 
        {
            System.out.println("Booking not found.");
        }
    }

}
