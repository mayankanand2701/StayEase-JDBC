package service;

import dao.FoodItemsDAO;
import java.sql.*;

public class FoodItemsService implements FoodItemsDAO {
    public void displayFoodMenu(Connection con) throws SQLException {
        PreparedStatement pst = con.prepareStatement("SELECT * FROM FoodItems");
        ResultSet rs = pst.executeQuery();

        System.out.println("Item ID | Item Name              | Price (\u20B9)");
        System.out.println("--------------------------------------------");
        while (rs.next()) {
            System.out.printf("%-8d | %-22s | %-9.2f\n",
                    rs.getInt("itemid"), rs.getString("itemname"), rs.getDouble("price"));
        }
        System.out.println("--------------------------------------------");
        rs.close();
        pst.close();
    }
}
