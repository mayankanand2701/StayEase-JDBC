package dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface FoodItemsDAO {
    void displayFoodMenu(Connection con) throws SQLException;
}