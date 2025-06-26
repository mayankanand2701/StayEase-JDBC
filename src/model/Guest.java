package model;

public class Guest {
	int GuestId;
	String name;
	int phone;
	String email;
	int age;
	String gender;
	String membership;
	
	public Guest(int guestId, String name, int phone, String email, int age, String gender, String membership) {
		super();
		GuestId = guestId;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.membership = membership;
	}

	public int getId() {
		return GuestId;
	}

	public void setId(int GuestId) {
		this.GuestId = GuestId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMembership() {
		return membership;
	}

	public void setMembership(String membership) {
		this.membership = membership;
	}

	@Override
	public String toString() {
		return "Guest [id=" + GuestId + ", name=" + name + ", phone=" + phone + ", email=" + email + ", age=" + age
				+ ", gender=" + gender + ", membership=" + membership + "]";
	}
}
