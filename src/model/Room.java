package model;

public class Room {
	int roomId;
	String roomType;
	double price;
	String status;
	
	public Room(int roomId, String roomType, double price, String status) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.price = price;
		this.status = status;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomType=" + roomType + ", price=" + price + ", status=" + status + "]";
	}
	
}
