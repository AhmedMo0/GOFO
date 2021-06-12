package appServices;
import java.util.ArrayList;

import usersPackage.*;
public class Database {

	ArrayList<Player> playerList;
	ArrayList<PlaygroundOwner> ownerList;
	ArrayList<Administrator> adminList;
	
	UserProfile user;
	
	public Database()
	{
		playerList = new ArrayList<>();
		ownerList = new ArrayList<>();
		adminList = new ArrayList<>();
		
		adminList.add(new Administrator());
	}
	
	
	public void addPlaygroundOwner(PlaygroundOwner owner)
	{
		ownerList.add(owner);
	}
	
	public void addPlayer(Player player)
	{
		playerList.add(player);
	}
	
	public void addadmin(Administrator admin)
	{
		adminList.add(admin);
	}
	
	
	public int isValidAccount(String email, String password)
	{
		
		for(Administrator i: adminList)
		{
			if(i.getmail().equals(email))
			{
				user = i;
				return 1;
			}
		}
		
		for(Player i: playerList)
		{
			if(i.getmail().equals(email) && i.getpassword().equals(password))
			{
				user = i;
				return 2;
			}
		}
		
		for(PlaygroundOwner i: ownerList)
		{
			if(i.getmail().equals(email) && i.getpassword().equals(password))
			{
				user = i;
				return 3;
			}
		}
		
		// not found in database
		
		return 0;
	}
	
}
