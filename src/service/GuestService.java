package service;

import dao.GuestDAO;
import java.sql.*;
import java.util.Scanner;

public class GuestService implements GuestDAO {
    public void addGuest(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Name: "); String name = sc.nextLine();
        System.out.print("Enter Address: "); String address = sc.nextLine();
        System.out.print("Enter Phone: "); int phone = sc.nextInt();
        System.out.print("Enter Email: "); String email = sc.next();
        System.out.print("Enter Age: "); int age = sc.nextInt();
        System.out.print("Enter Gender: "); String gender = sc.next();
        System.out.print("Membership (Yes/No): "); String membership = sc.next();

        PreparedStatement pst = con.prepareStatement("INSERT INTO Guest (name,address,phone,email,age,gender,membership) VALUES (?,?,?,?,?,?,?)");
        pst.setString(1, name); pst.setString(2, address); pst.setInt(3, phone);
        pst.setString(4, email); pst.setInt(5, age); pst.setString(6, gender); pst.setString(7, membership);
        pst.executeUpdate(); pst.close();
        System.out.println("Guest Registered Successfully.");
    }

    public void displayAllGuests(Connection con) throws SQLException {
        String query = "SELECT * FROM Guest";
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();

        System.out.println("Guest ID | Name | Email | Age | Gender | Membership");
        while (rs.next()) {
            System.out.printf("%-8d | %-10s | %-20s | %-3d | %-6s | %-10s\n",
                    rs.getInt("guestid"), rs.getString("name"), rs.getString("email"),
                    rs.getInt("age"), rs.getString("gender"), rs.getString("membership"));
        }
        System.out.println("-----------------------------------------------------");

        rs.close();
        pst.close();
    }
}

