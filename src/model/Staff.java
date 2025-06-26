package model;

import java.util.Date;

public class Staff {
	int staffId;
	String name;
	String role;
	int phone;
	Date shiftTime;
	
	public Staff(int staffId, String name, String role, int phone, Date shiftTime) {
		super();
		this.staffId = staffId;
		this.name = name;
		this.role = role;
		this.phone = phone;
		this.shiftTime = shiftTime;
	}
	
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public Date getShiftTime() {
		return shiftTime;
	}
	public void setShiftTime(Date shiftTime) {
		this.shiftTime = shiftTime;
	}
	
	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", name=" + name + ", role=" + role + ", phone=" + phone + ", shiftTime="
				+ shiftTime + "]";
	}
	
}
