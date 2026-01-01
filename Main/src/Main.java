import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Room> hotelRooms = new ArrayList<>();
        hotelRooms.add(new Room(101, 16000, true));
        hotelRooms.add(new Room(102, 12000, true));
        hotelRooms.add(new Room(103, 25000, false));
        hotelRooms.add(new Room(104, 18000, true));

        while (true) {
            System.out.println("1. List all rooms");
            System.out.println("2. Show only available rooms");
            System.out.println("3. Sort by price");
            System.out.println("4. Find room by number");
            System.out.println("5. Create VIP Booking");
            System.out.println("0. Exit");
            System.out.print("Choose option:");

            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("\nAll Rooms");
                    for (int i = 0; i < hotelRooms.size(); i++) {
                        System.out.println(hotelRooms.get(i));
                    }
                    break;

                case 2:
                    System.out.println("\nAvailable Rooms");
                    for (int i = 0; i < hotelRooms.size(); i++) {
                        Room r = hotelRooms.get(i);
                        if (r.isAvailable()) {
                            System.out.println(r);
                        }
                    }
                    break;

                case 3:
                    hotelRooms.sort(Comparator.comparingDouble(Room::getPricePerNight));
                    System.out.println("\nSorted by Price");
                    for (int i = 0; i < hotelRooms.size(); i++) {
                        System.out.println(hotelRooms.get(i));
                    }
                    break;

                case 4:
                    System.out.print("Enter room number: ");
                    int num = scanner.nextInt();
                    boolean found = false;
                    for (int i = 0; i < hotelRooms.size(); i++) {
                        Room r = hotelRooms.get(i);
                        if (r.getRoomNumber() == num) {
                            System.out.println("Result: " + r);
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Room not found.");
                    break;

                case 5:
                    System.out.println("\nCreating VIP Booking Demo");
                    Room room = hotelRooms.get(0);
                    Guest vip = new VIPGuest("Aidos", "Marat", 0.20);
                    Booking booking = new Booking(room, vip, 5);
                    System.out.println(booking);
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}