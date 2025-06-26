package service;

import dao.FoodOrderDAO;
import model.FoodItem;
import java.sql.*;
import java.util.*;

public class FoodOrderService implements FoodOrderDAO {
    public void placeFoodOrder(Connection con, Scanner sc, int guestId, int roomId) throws SQLException {
        List<FoodItem> orderItems = new ArrayList<>();

        System.out.print("How many different food items? ");
        int count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.print("Item ID: "); 
            int itemId = sc.nextInt();
            System.out.print("Quantity: "); 
            int qty = sc.nextInt();
            orderItems.add(new FoodItem(itemId, qty));
        }

        for (FoodItem item : orderItems) {
            PreparedStatement priceStmt = con.prepareStatement("SELECT price FROM FoodItems WHERE itemid = ?");
            priceStmt.setInt(1, item.getItemId());
            ResultSet rs = priceStmt.executeQuery();

            if (rs.next()) {
                double total = rs.getDouble("price") * item.getQuantity();
                PreparedStatement insert = con.prepareStatement("INSERT INTO FoodOrders (orderid, guestid, itemid, roomid, numberofitems, totalamount, status) VALUES (?, ?, ?, ?, ?, ?, ?)");
                insert.setInt(1, new Random().nextInt(99999));
                insert.setInt(2, guestId); insert.setInt(3, item.getItemId());
                insert.setInt(4, roomId); insert.setInt(5, item.getQuantity());
                insert.setDouble(6, total); insert.setString(7, "Ordered");
                insert.executeUpdate(); insert.close();
            }

            rs.close();
            priceStmt.close();
        }

        System.out.println("Food order placed successfully.");
    }
}

