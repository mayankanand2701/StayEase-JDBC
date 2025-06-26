package ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import dao.FoodItemsDAO;
import dao.FoodOrderDAO;
import dao.GuestDAO;
import dao.RoomDAO;
import service.FoodItemsService;
import service.FoodOrderService;
import service.GuestService;
import service.RoomService;


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
	        
	        GuestDAO guest = new GuestService();
	        RoomDAO room = new RoomService();
	        FoodItemsDAO foodItems = new FoodItemsService();
	        FoodOrderDAO foodOrder = new FoodOrderService();
	        
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
	                	System.out.println("Kindly fill your details : ");
	                	guest.addGuest(con, sc);
	                	System.out.println("------------------------------------");
	                    System.out.println("Thanks for Registering with Us");
	                    System.out.println("------------------------------------");
	                	room.displayAllRooms(con);
	                	System.out.println("Enter the Room Id which you want to Book : ");
	                	int id=sc.nextInt();
	                    break;
	                case 2:
	                	System.out.println("------------------------------------");
	                	System.out.println("Opted for Dine at Restaurant Only (Dining)");
	                	System.out.println("------------------------------------");
	                	guest.addGuest(con, sc);
	                	System.out.println("------------------------------------");
	                    System.out.println("Thanks for Registering with Us");
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
