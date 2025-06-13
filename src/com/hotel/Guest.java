package com.hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Statement;

public class Guest 
{
	// To create a new Guest
    public void addGuest(Connection con, Scanner sc) throws SQLException
    {
        System.out.print("Enter Name of the Guest : ");
        String name = sc.nextLine();
        System.out.print("Enter Address of the Guest : ");
        String address = sc.nextLine();
        System.out.print("Enter Phone Number of the Guest : ");
        int phone = sc.nextInt();
        System.out.print("Enter Email of the Guest : ");
        String email = sc.next();
        System.out.print("Enter Age of the Guest : ");
        int age = sc.nextInt();
        System.out.print("Enter Gender of the Guest : ");
        String  gender = sc.next();
        System.out.print("Enter Weather the Guest have any Membership :  (Yes/No) ");
        String  membership = sc.next();

        String query = "INSERT INTO Guest (name,address,phone,email,age,gender,membership) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, name);
        pst.setString(2,address);
        pst.setInt(3,phone);
        pst.setString(4,email);
        pst.setInt(5, age);
        pst.setString(6,gender);
        pst.setString(7,membership);

        int rows = pst.executeUpdate();
        System.out.println(rows + " New Cutomer Added Successfully.");
        pst.close();
    }
    // To display all guests
    public void displayAllGuests(Connection con) throws SQLException {
        String query = "SELECT * FROM Guest";
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();

        System.out.println("Guest List :");
        System.out.println("---------------------------------------------------------------");
        System.out.println("Guest ID | Name         | Address       | Phone     | Email           | Age | Gender | Membership");
        System.out.println("---------------------------------------------------------------");

        while (rs.next()) {
            int guestid = rs.getInt("guestid");
            String name = rs.getString("name");
            String address = rs.getString("address");
            int phone = rs.getInt("phone");
            String email = rs.getString("email");
            int age = rs.getInt("age");
            String gender = rs.getString("gender");
            String membership = rs.getString("membership");

            System.out.printf("%-8d | %-12s | %-13s | %-9d | %-15s | %-3d | %-6s | %-10s%n",
                    guestid, name, address, phone, email, age, gender, membership);
        }

        System.out.println("---------------------------------------------------------------");

        rs.close();
        pst.close();
    }
}
