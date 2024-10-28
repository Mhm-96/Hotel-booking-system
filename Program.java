public class Program 
{
    public static void main(String[] args) {
        // Create hotel
        Hotel hotel = new Hotel("Dream Hotel");

        // Add rooms to the hotel
        hotel.AddRoom(new Room("101", "Standard"));
        hotel.AddRoom("102", "Deluxe");
        hotel.AddRoom("103", "Suite");

        // Create customers
        Customer customer1 = new Customer("C001", "John Doe", "123456789");
        VIPCustomer vipCustomer1 = new VIPCustomer("C002", "Jane Smith", "987654321");

        // Add customers to the hotel
        hotel.AddCustomer(customer1);
        hotel.AddCustomer(vipCustomer1);

        // Book rooms for customers
        hotel.createBooking("B001", customer1, new Room[] { hotel.checkAvailableRooms()[0] });
        hotel.createBooking("B002", vipCustomer1,
                new Room[] { hotel.checkAvailableRooms()[0], hotel.checkAvailableRooms()[1] });

        // Display bookings for customer1
        hotel.displayBookingsForCustomer("C001");

        // Cancel booking
        hotel.cancelBooking("B001");
    }

}