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
		playgrounds = new ArrayList<>();
	}
	
	public void addNewRequest(Requests req)
	{
		requests.add(req);
	}
	
	public boolean showMyRequests()
	{
		int x = 0;
		
		if(!requests.isEmpty())
		{
			System.out.println("Requests");
			
			for(Requests i: requests)
			{
				System.out.println("index: " + x);
				System.out.println(i.toString());
				x++;
			}
			
			return true;
		}
		else
		{
			System.out.println("List is empty!!");
		}

		return false;
	}
	
	
	
	public void addPlayground(Playground playG)
	{
		playgrounds.add(playG);
	}
	
	public void acceptReq(int index)
	{
		requests.get(index).updateStatus(RequestStatus.Accepted);
	}
//	public boolean deleteReq(int id) {return true;}
	
	
}
