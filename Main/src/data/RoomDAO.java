package data;

import entities.Room;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {

    public void insert(Room room) throws SQLException {
        String sql = "INSERT INTO rooms (room_number, price_per_night, is_available) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, room.getRoomNumber());
            stmt.setDouble(2, room.getPricePerNight());
            stmt.setBoolean(3, room.isAvailable());
            stmt.executeUpdate();
        }
    }

    public List<Room> readAll() throws SQLException {
        String sql = "SELECT * FROM rooms";
        List<Room> rooms = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                rooms.add(new Room(
                        rs.getInt("room_number"),
                        rs.getDouble("price_per_night"),
                        rs.getBoolean("is_available")
                ));
            }
        }
        return rooms;
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM rooms WHERE room_number = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
    public void updatePrice(int roomNumber, double newPrice) throws SQLException {
        String sql = "UPDATE rooms SET price_per_night = ? WHERE room_number = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, newPrice);
            stmt.setInt(2, roomNumber);
            stmt.executeUpdate();
        }
    }
}