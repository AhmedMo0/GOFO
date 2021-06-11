package usersPackage;

import java.util.ArrayList;

import appServices.Requests;

public class PlaygroundOwner extends UserProfile{

	Requests requests = new Requests();
	ArrayList<Playground> playgrounds;
	
	public PlaygroundOwner(String name, String mail, String password, String phone, String city) {
		this.name = name;
		this.mail = mail;
		this.password = password;
		this.phone = phone;
		this.city = city;
	}
	
	public void updatePlayground(Playground playground){}
	public boolean acceptReq(int id) {return true;}
	public boolean deleteReq(int id) {return true;}
	
	
}
