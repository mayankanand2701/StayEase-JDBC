package com.hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FoodItems {
	// Method to display all food items
    public void displayFoodMenu(Connection con) throws SQLException {
        String query = "SELECT * FROM FoodItems";
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();

        System.out.println("--------------------------------------------------");
        System.out.println("Item ID | Item Name                  | Price (₹)");
        System.out.println("--------------------------------------------------");

        while (rs.next()) {
            int itemid = rs.getInt("itemid");
            String itemname = rs.getString("itemname");
            double price = rs.getDouble("price");

            System.out.printf("%-8d | %-25s | %-9.2f%n", itemid, itemname, price);
        }

        System.out.println("--------------------------------------------------");

        rs.close();
        pst.close();
    }
}
