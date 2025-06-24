package com.hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Room
{
	// Method to display all rooms
    public void displayAllRooms(Connection con) throws SQLException
    {
        String query = "SELECT * FROM Rooms";
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();

        System.out.println("Details of all Rooms in our Hotel : ");
        System.out.println("--------------------------------------------------------");
        System.out.println("Room ID | Room Type           | Price (₹) | Status");
        System.out.println("--------------------------------------------------------");

        while (rs.next()) {
            int roomid = rs.getInt("roomid");
            String roomtype = rs.getString("roomtype");
            double price = rs.getDouble("price");
            String status = rs.getString("status");

            System.out.printf("%-7d | %-19s | %-9.2f | %-10s%n",roomid, roomtype, price, status);
        }

        System.out.println("---------------------------------------------------------");

        rs.close();
        pst.close();
    }
    
    // Method to check the availability of room and update its status 
    public boolean bookRoom(Connection con, int roomid) throws SQLException
    {
        // Step 1: Check if room exists and is available
        String checkQuery = "SELECT status FROM Rooms WHERE roomid = ?";
        PreparedStatement checkPst = con.prepareStatement(checkQuery);
        checkPst.setInt(1, roomid);
        ResultSet rs = checkPst.executeQuery();

        if (rs.next()) {
            String status = rs.getString("status");
            if (status.equalsIgnoreCase("Available")) 
            {
                // Step 2: Update the status to Occupied
                String updateQuery = "UPDATE Rooms SET status = 'Occupied' WHERE roomid = ?";
                PreparedStatement updatePst = con.prepareStatement(updateQuery);
                updatePst.setInt(1, roomid);
                int rows = updatePst.executeUpdate();
                updatePst.close();

                System.out.println("Room " + roomid + " has been successfully booked.");
                rs.close();
                checkPst.close();
                return true;
            } 
            else
            {
                System.out.println("Sorry, Room " + roomid + " is not available right now.");
            }
        } 
        else
        {
            System.out.println("Invalid Room ID. No such room exists.");
        }

        rs.close();
        checkPst.close();
        return false;
    }


}
