package dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface RoomDAO 
{
	 void displayAllRooms(Connection con) throws SQLException;
	 boolean bookRoom(Connection con, int roomid) throws SQLException;
}
