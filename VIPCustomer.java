import java.util.Arrays;

public class VIPCustomer extends Customer 
{
    private Room[] bookedRooms;
    private int vipcustomercount;
    public VIPCustomer(String customerID, String name, String contactNumber) 
    {
        super(customerID, name, contactNumber);  
        vipcustomercount = 0;      
    }

    @Override
    public void bookRoom(Room room)
    {
        if(vipcustomercount < 5)
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
            vipcustomercount++;
        }
        else
        {
            System.err.println("Cannot book more than 5 rooms for customer");
        }
    }

        
}
