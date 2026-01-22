import data.RoomDAO;
import entities.*;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        RoomDAO dao = new RoomDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1) Add room");
            System.out.println("2) Show all rooms");
            System.out.println("3) Delete room");
            System.out.println("4) Update Room");
            System.out.println("5) Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Number: ");
                    int num = sc.nextInt();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Available (true/false): ");
                    boolean avail = sc.nextBoolean();

                    try {
                        dao.insert(new Room(num, price, avail));
                        System.out.println("Success.");
                    } catch (SQLException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        List<Room> rooms = dao.readAll();
                        for (int i = 0; i < rooms.size(); i++) {
                            Room r = rooms.get(i);
                            System.out.println(r);
                        }
                    } catch (SQLException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Room number to delete: ");
                    int id = sc.nextInt();
                    try {
                        dao.delete(id);
                        System.out.println("Deleted.");
                    } catch (SQLException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4: {
                    System.out.print("Enter room number to update: ");
                    int num1 = sc.nextInt();

                    System.out.print("Enter new price: ");
                    double price1 = sc.nextDouble();
                    sc.nextLine();

                    try {
                        dao.updatePrice(num1, price1);
                        System.out.println("Price updated successfully!");
                    } catch (SQLException e) {
                        System.out.println("Update error: " + e.getMessage());
                    }
                    break;
                }
                case 5:{
                    return;
                }
            }
        }
    }
}


//        Scanner scanner = new Scanner(System.in);
//        List<entities.Room> hotelRooms = new ArrayList<>();
//        hotelRooms.add(new entities.Room(101, 16000, true));
//        hotelRooms.add(new entities.Room(102, 12000, true));
//        hotelRooms.add(new entities.Room(103, 25000, false));
//        hotelRooms.add(new entities.Room(104, 18000, true));
//
//        while (true) {
//            System.out.println("1. List all rooms");
//            System.out.println("2. Show only available rooms");
//            System.out.println("3. Sort by price");
//            System.out.println("4. Find room by number");
//            System.out.println("5. Create VIP entities.Booking");
//            System.out.println("0. Exit");
//            System.out.print("Choose option:");
//
//            int choice = scanner.nextInt();
//            if (choice == 0) {
//                break;
//            }
//
//            switch (choice) {
//                case 1:
//                    System.out.println("\nAll Rooms");
//                    for (int i = 0; i < hotelRooms.size(); i++) {
//                        System.out.println(hotelRooms.get(i));
//                    }
//                    break;
//
//                case 2:
//                    System.out.println("\nAvailable Rooms");
//                    for (int i = 0; i < hotelRooms.size(); i++) {
//                        entities.Room r = hotelRooms.get(i);
//                        if (r.isAvailable()) {
//                            System.out.println(r);
//                        }
//                    }
//                    break;
//
//                case 3:
//                    hotelRooms.sort(Comparator.comparingDouble(entities.Room::getPricePerNight));
//                    System.out.println("\nSorted by Price");
//                    for (int i = 0; i < hotelRooms.size(); i++) {
//                        System.out.println(hotelRooms.get(i));
//                    }
//                    break;
//
//                case 4:
//                    System.out.print("Enter room number: ");
//                    int num = scanner.nextInt();
//                    boolean found = false;
//                    for (int i = 0; i < hotelRooms.size(); i++) {
//                        entities.Room r = hotelRooms.get(i);
//                        if (r.getRoomNumber() == num) {
//                            System.out.println("Result: " + r);
//                            found = true;
//                            break;
//                        }
//                    }
//                    if (!found) System.out.println("entities.Room not found.");
//                    break;
//
//                case 5:
//                    System.out.println("\nCreating VIP entities.Booking Demo");
//                    entities.Room room = hotelRooms.get(0);
//                    entities.Guest vip = new entities.VIPGuest("Aidos", "Marat", 0.20);
//                    entities.Booking booking = new entities.Booking(room, vip, 5);
//                    System.out.println(booking);
//                    break;
//
//                default:
//                    System.out.println("Invalid choice.");
//            }
//        }
//
//        scanner.close();
//    }
//}