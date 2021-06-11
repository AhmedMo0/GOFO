package usersPackage;

import java.util.ArrayList;

public class Administrator extends UserProfile{

	ArrayList<Playground> requestedPlaygrounds;
	//Database database;
	//Booking livePlayG;
	
	public Administrator() {
		this.name = "admin";
		this.password = "admin";
	}
	
	public Administrator(String name, String mail, String password, String phone, String city) {
		this.name = name;
		this.mail = mail;
		this.password = password;
		this.phone = phone;
		this.city = city;
	}
}
