package usersPackage;

import appServices.Requests;

public class Player extends UserProfile{

	
	Requests requests = new Requests();
	
	
	public Player(String name, String mail, String password, String phone, String city) {
		this.name = name;
		this.mail = mail;
		this.password = password;
		this.phone = phone;
		this.city = city;
	}
	
	public void deleteReq(int id) {}
	public void bookPlayG() {}
	
	
}
