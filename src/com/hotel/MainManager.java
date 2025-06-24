package com.hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class MainManager
{
	static final String URL = "jdbc:mysql://localhost:3306/hotel";
	static final String USER = "root";
	static final String PASS = "root";

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
			Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection(URL, USER, PASS);
	        Scanner sc = new Scanner(System.in);
	        
	        Guest guest=new Guest();
	        Room room=new Room();
	        FoodItems foodItems=new FoodItems();
	        FoodOrder foodOrder=new FoodOrder();
	        
	        while (true) {
	            System.out.println("---- Hotel Management System ----");
	            System.out.println("--------------------------------");
	            System.out.println("Options : ");
	            System.out.println("1. Stay at Hotel (Lodging)");
	            System.out.println("2. Dine at Restaurant Only (Dining)");
	            System.out.println("3. Know our Services.");
	            System.out.println("4. Exit");
	            System.out.println("--------------------------------");
	            System.out.print("Choose an option: ");
	            int choice = sc.nextInt();
	            sc.nextLine();
	         
	            switch (choice) 
	            {
	                case 1:
	                	System.out.println("------------------------------------");
	                	System.out.println("Opted for Stay at Hotel (Lodging)");
	                	System.out.println("------------------------------------");
	                    // System.out.println("Thanks for Registering with Us");
	                    // System.out.println("------------------------------------");
	                	// System.out.println("Do You Want to Want to See the Guest List ? (Yes/No) ");
	                	// String str=sc.next();
	                	// if(str.equals("Yes") || str.equals("yes")) guest.displayAllGuests(con);
	                	room.displayAllRooms(con);
	                	System.out.println("Enter the Room Id which you want to Book : ");
	                	int id=sc.nextInt();
	                	room.bookRoom(con, id);
	                    
	                    break;
	                case 2:
	                	System.out.println("------------------------------------");
	                	System.out.println("Opted for Dine at Restaurant Only (Dining)");
	                	System.out.println("------------------------------------");
	                	foodItems.displayFoodMenu(con);
	                	foodOrder.placeFoodOrder(con, sc, -1, -1);
	                    break;
	                case 3:
	                	System.out.println("------------------------------------");
	                    System.out.println("Services offered by us : ");
	                    System.out.println("------------------------------------");
	                    System.out.println("Stay at Hotel (Lodging)");
	                    System.out.println("Dine at Restaurant Only (Dining)");
	                    System.out.println("-------------------------------------");
	                    System.out.println("Kindly Choose 1 for Lodging.");
	                    System.out.println("Kindly Choose 2 for Dining.");
	                    System.out.println("Thanks for Visiting our Hotel. Have a great day !");
	                    System.out.println("-------------------------------------------------");
	                    break;
	                case 4:
	                	System.out.println("-----------------------------------------------");
	                    System.out.println("Thanks for Visitng our Hotel. Have a great day !");
	                    System.out.println("-----------------------------------------------");
	                    con.close();
	                    sc.close();
	                    System.exit(0);
	                default:
	                	System.out.println("--------------------------");
	                    System.out.println("Invalid option! Try again.");
	                    System.out.println("--------------------------");
	            }
	        }
	}
}
