package usersPackage;
import appServices.*;

import java.util.ArrayList;

public class Administrator extends UserProfile{

	ArrayList<Playground> requestedPlaygrounds;
	
	SystemUI system;
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
	
	
	public void linkWithSystemUI(SystemUI sys)
	{
		system = sys;
	}
	public void addRequestedPlayground(Playground playG)
	{
		requestedPlaygrounds.add(playG);
	}
	
	public void addPlayGToLiveList(Playground playG)
	{
		system.booking.addPlayground(playG);
	}
	
	public void showAllRequestedPlayGs()
	{
		int x = 0;
		for(Playground i: requestedPlaygrounds)
		{
			System.out.println("index: " + x);
			System.out.println(i.toString());
			x++;
		}
	}
	
	public Playground getPlayG(int index)
	{
		return requestedPlaygrounds.get(index);
	}
	
	
}
