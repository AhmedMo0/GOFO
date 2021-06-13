package usersPackage;

import java.util.ArrayList;

import appServices.Requests;

public class Player extends UserProfile{

	
	ArrayList<Requests> requests;
	
	
	public Player(String name, String mail, String password, String phone, String city) {
		this.name = name;
		this.mail = mail;
		this.password = password;
		this.phone = phone;
		this.city = city;
		
		requests = new ArrayList<>();
	}
	
	
	
	public void addNewRequest(Requests req)
	{
		requests.add(req);
	}
	
	
	
	public void showMyRequests()
	{
		if(!requests.isEmpty())
		{
			System.out.println("Requests");
			
			for(Requests i: requests)
			{
				System.out.println(i.toString());
			}
		}
		else
		{
			System.out.println("List is empty!!");
		}
	}
	
	
//	public void deleteReq(int id) {}
//	public void bookPlayG() {}
	
	
}
