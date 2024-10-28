import java.util.Arrays;
/**
 * Customer
 */
public class Customer {

    private String customerID;
    private String name;
    private String contactNumber;
    private Room[] bookedRooms;
    private int customercount;
    
    public Customer(String customerID,String name,String contactNumber) 
    {
        this.customerID = customerID;
        this.contactNumber = name;
        this.name = contactNumber;
        this.customercount = 0;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void bookRoom(Room room)
    {
        if(customercount < 3)
        {
            if(bookedRooms == null)
            {
                bookedRooms = new Room[1];
                bookedRooms[bookedRooms.length-1] = room; 
            }
            else
            {
                bookedRooms = Arrays.copyOf(bookedRooms, bookedRooms.length+1);
                bookedRooms[bookedRooms.length-1] = room;
            }
            room.bookRoom();
            customercount++;
        }
        else
        {
            System.err.println("Cannot book more than 3 rooms for customer");
        }
    }
}