package com.hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Helper class to store individual item order info
class FoodOrderItem {
 int itemId;
 int quantity;

 public FoodOrderItem(int itemId, int quantity) {
     this.itemId = itemId;
     this.quantity = quantity;
 }

 public int getItemId() {
     return itemId;
 }

 public int getQuantity() {
     return quantity;
 }
}

public class FoodOrder {
	public void placeFoodOrder(Connection con, Scanner sc, int guestId, int roomId) throws SQLException {
	    List<FoodOrderItem> orderItems = new ArrayList<>();

	    System.out.print("How many different food items do you want to order? ");
	    int count = sc.nextInt();

	    for (int i = 0; i < count; i++) {
	        System.out.print("Enter Food Item ID: ");
	        int itemId = sc.nextInt();
	        System.out.print("Enter Quantity: ");
	        int qty = sc.nextInt();

	        orderItems.add(new FoodOrderItem(itemId, qty));
	    }

	    for (FoodOrderItem item : orderItems) {
	        // Fetch price from FoodItems table
	        String priceQuery = "SELECT price FROM FoodItems WHERE itemid = ?";
	        PreparedStatement priceStmt = con.prepareStatement(priceQuery);
	        priceStmt.setInt(1, item.getItemId());
	        ResultSet rs = priceStmt.executeQuery();

	        double price = 0;
	        if (rs.next()) {
	            price = rs.getDouble("price");
	        } else {
	            System.out.println("Item ID " + item.getItemId() + " not found. Skipping.");
	            continue;
	        }
	        rs.close();
	        priceStmt.close();

	        double totalAmount = price * item.getQuantity();

	        // Insert into FoodOrders table
	        String insertQuery = "INSERT INTO FoodOrders (orderid, guestid, itemid, roomid, numberofitems, totalamount, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement insertStmt = con.prepareStatement(insertQuery);

	        int orderId = (int) (Math.random() * 100000); // Use better logic or sequence in real DB
	        insertStmt.setInt(1, orderId);
	        insertStmt.setInt(2, guestId);
	        insertStmt.setInt(3, item.getItemId());
	        insertStmt.setInt(4, roomId);
	        insertStmt.setInt(5, item.getQuantity());
	        insertStmt.setDouble(6, totalAmount);
	        insertStmt.setString(7, "Ordered");

	        insertStmt.executeUpdate();
	        insertStmt.close();

	        System.out.println("Item ID " + item.getItemId() + " x " + item.getQuantity() + " ordered successfully.");
	    }

	    System.out.println("Food Order Completed.");
	}


}
