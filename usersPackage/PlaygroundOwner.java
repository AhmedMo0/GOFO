package usersPackage;

import java.util.ArrayList;

import appServices.Requests;

public class PlaygroundOwner extends UserProfile{

	ArrayList<Requests> requests;
	ArrayList<Playground> playgrounds;
	
	public PlaygroundOwner(String name, String mail, String password, String phone, String city) {
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
		System.out.println("Requests");
		
		for(Requests i: requests)
		{
			System.out.println(i.toString());
		}
	}
	
	
	public void addPlayground(Playground playG)
	{
		playgrounds.add(playG);
	}
	
//	public void updatePlayground(Playground playground){}
//	public boolean acceptReq(int id) {return true;}
//	public boolean deleteReq(int id) {return true;}
	
	
}
