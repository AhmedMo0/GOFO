package appServices;
import java.util.ArrayList;

import usersPackage.*;

public class Booking {

	private ArrayList<Playground> livePlaygrounds;
	private Requests allReqs;
	
	
	public Booking() 
	{
		livePlaygrounds = new ArrayList<>();
		allReqs = new Requests();
	}
	
	public void addPlayground(Playground newPlayG)
	{
		livePlaygrounds.add(newPlayG);
	}
	
	public Playground getPlayG(int index)
	{
		return livePlaygrounds.get(index);
	}
	
	public void showAvailablePlayG()
	{
		for(Playground playG: livePlaygrounds)
		{
			System.out.println("------------------------------\n" + playG.toString() + "\n------------------------------\n");
		}
	}
	
	public void book(Playground playG, Player player, BookingDate date)
	{
		
	}
	
	
}
