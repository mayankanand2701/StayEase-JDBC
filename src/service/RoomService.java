package service;

import dao.RoomDAO;
import java.sql.*;

public class RoomService implements RoomDAO {
    public void displayAllRooms(Connection con) throws SQLException {
        String query = "SELECT * FROM Rooms";
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();

        System.out.println("Room ID | Room Type           | Price (\u20B9) | Status");
        System.out.println("------------------------------------------------------");

        while (rs.next()) {
            System.out.printf("%-7d | %-19s | %-9.2f | %-10s\n",
                rs.getInt("roomid"), rs.getString("roomtype"),
                rs.getDouble("price"), rs.getString("status"));
        }
        System.out.println("------------------------------------------------------");

        rs.close();
        pst.close();
    }

    public boolean bookRoom(Connection con, int roomid) throws SQLException {
        String checkQuery = "SELECT status FROM Rooms WHERE roomid = ?";
        PreparedStatement pst = con.prepareStatement(checkQuery);
        pst.setInt(1, roomid);
        ResultSet rs = pst.executeQuery();

        if (rs.next() && rs.getString("status").equalsIgnoreCase("Available")) {
            String updateQuery = "UPDATE Rooms SET status = 'Occupied' WHERE roomid = ?";
            PreparedStatement updatePst = con.prepareStatement(updateQuery);
            updatePst.setInt(1, roomid);
            updatePst.executeUpdate();
            updatePst.close();
            System.out.println("Room " + roomid + " successfully booked.");
            return true;
        } else {
            System.out.println("Room not available or does not exist.");
        }

        rs.close();
        pst.close();
        return false;
    }
}

