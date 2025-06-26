package service;

import dao.FoodOrderDAO;
import model.FoodItem;
import java.sql.*;
import java.util.*;

public class FoodOrderService implements FoodOrderDAO
{
    public void placeFoodOrder(Connection con, Scanner sc, int guestId, int roomId) throws SQLException
    {
        List<FoodItem> orderItems = new ArrayList<>();
        double grandTotal = 0.0;

        sc.nextLine();
        System.out.print("Enter the name of the guest for whom the food order is placed : ");
        String guestName = sc.nextLine();
        
        PreparedStatement pst = con.prepareStatement("SELECT guestid FROM Guest WHERE name = ?");
        pst.setString(1, guestName);
        ResultSet rs1 = pst.executeQuery();
        
        System.out.println("----------------------------------------------");
        if (rs1.next()) {
            guestId = rs1.getInt("guestid");
            System.out.println("Guest found. Guest ID = " + guestId);
        } else {
            System.out.println("Guest not found. Please register first.");
            return;
        }
        
        System.out.println("Creating order for Guest : " + guestName);
        
        System.out.print("How many different food items? ");
        int count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.print("Item ID: ");
            int itemId = sc.nextInt();
            System.out.print("Quantity: ");
            int qty = sc.nextInt();
            orderItems.add(new FoodItem(itemId, qty));
        }

        System.out.println("----------------------------------------------");
        for (FoodItem item : orderItems) {
            // Fetch the price for this item ID
            String priceQuery = "SELECT price FROM FoodItems WHERE itemid = ?";
            PreparedStatement priceStmt = con.prepareStatement(priceQuery);
            priceStmt.setInt(1, item.getItemId());
            ResultSet rs = priceStmt.executeQuery();
           
            if (rs.next())
            {
                double unitPrice = rs.getDouble("price");
                double totalAmount = unitPrice * item.getQuantity();
                grandTotal += totalAmount;
                System.out.println("Ordered Item ID " + item.getItemId() + " | Quantity: " + item.getQuantity() + " | Total: " + totalAmount);
            } 
            else System.out.println("Item ID " + item.getItemId() + " not found.");
            

            rs.close();
            priceStmt.close();
        }
        System.out.println("-----------------------------------");
        System.out.println("Grand Total for this Order : " + grandTotal);
        System.out.println("-----------------------------------");
    }
}
