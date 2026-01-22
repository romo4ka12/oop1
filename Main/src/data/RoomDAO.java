package data;

import entities.Room;
import java.sql.*;
import java.util.*;

public class RoomDAO {

    public void insert(Room room) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO rooms (room_number, price_per_night, is_available) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, room.getRoomNumber());
            stmt.setDouble(2, room.getPricePerNight());
            stmt.setBoolean(3, room.isAvailable());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        }
    }

    public List<Room> readAll() {
        List<Room> rooms = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM rooms";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                rooms.add(new Room(
                        rs.getInt("room_number"),
                        rs.getDouble("price_per_night"),
                        rs.getBoolean("is_available")
                ));
            }
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        }
        return rooms;
    }

    public void delete(int id) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "DELETE FROM rooms WHERE room_number = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        }
    }

    public void updatePrice(int roomNumber, double newPrice) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "UPDATE rooms SET price_per_night = ? WHERE room_number = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setDouble(1, newPrice);
            stmt.setInt(2, roomNumber);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        }
    }
}