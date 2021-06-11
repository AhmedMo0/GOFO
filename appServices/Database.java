package appServices;
import java.util.ArrayList;

import usersPackage.*;
public class Database {

	ArrayList<Player> playerList;
	ArrayList<PlaygroundOwner> ownerList;
	ArrayList<Administrator> adminList;
	
	public Database()
	{
		playerList = new ArrayList<>();
		ownerList = new ArrayList<>();
		adminList = new ArrayList<>();
		
		adminList.add(new Administrator());
	}
	
	
	public void addPlaygroundOwner(PlaygroundOwner owner){}
	public void addPlayer(Player player){}
	public int isValidAccount(String email, String password) {return 0;}
	
}
