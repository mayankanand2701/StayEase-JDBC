package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public interface FoodOrderDAO 
{
    void placeFoodOrder(Connection con, Scanner sc, int guestId, int roomId) throws SQLException;
}
