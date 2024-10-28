public class Room 
{  
    private String roomNumber;
    private boolean isBooked;
    private String roomType;

    public Room(String roomNumber,String roomType) 
    {
        this.isBooked = false;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }

    public void bookRoom() {
        this.isBooked = true;
    }

    public boolean isRoomBooked(){
        return isBooked;
    }

    public void cancelbooking(){
        this.isBooked = false;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }
}
