public class Main {
    public static void main(String[] args) {

        Room room1 = new Room(101,16000,true);
        Room room2 = new Room(102,18000,true);

        Guest guest1 = new Guest("Aidos","Marat" );

        Booking booking1 = new Booking(room1, guest1, 3);

        System.out.println("Room number: " + room1.getRoomNumber());
        System.out.println("Price: " + room1.getPricePerNight());
        System.out.println("Available: " + room1.isAvailable());

        System.out.println("Name: " + guest1.getName());
        System.out.println("Second Name: " + guest1.getSecondName());

        System.out.println("Guest: " + booking1.getGuest().getName());
        System.out.println("Room number: " + booking1.getRoom().getRoomNumber());
        System.out.println("Nights: " + booking1.getNights());
        System.out.println("Total price: " + booking1.calculateTotalPrice());


        
        if(room1.getPricePerNight() > room2.getPricePerNight()) {
            System.out.println("Room 1 is more expensive than Room 2");
        }
        else if(room1.getPricePerNight() < room2.getPricePerNight()) {
            System.out.println("Room 2 is more expensive than Room 1");
        }
        else{
            System.out.println("The price for both rooms is the same.");
        }
        }

    }
