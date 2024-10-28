import java.time.LocalDate;

public class Booking 
{
    private String bookingID;
    private Customer customer;
    private Room[] rooms;
    private LocalDate bookingDate;

    public Booking(String bookingID,Customer customer, Room[] rooms) 
    {
       this.bookingDate = LocalDate.now();
       this.bookingID = bookingID;
       this.customer = customer;
       this.rooms = rooms; 
    }

    public String getBookingID() {
        return bookingID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

}
