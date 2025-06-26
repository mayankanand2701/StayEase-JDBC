package dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface GuestDAO {
    void addGuest(Connection con, java.util.Scanner sc) throws SQLException;
    void displayAllGuests(Connection con) throws SQLException;
}
