package appServices;
import usersPackage.*;

import java.util.HashMap;
import java.util.Map;




public class Requests {

	int id;
	Player player;
	Playground playG;
	RequestStatus status;
	BookingDate date;

		
	
	
	public Requests()
	{
		
	}
	
	/**
	 * @param player
	 * @param playG
	 * @param status
	 * @param id
	 */
	public Requests(int id, Player player, Playground playG, BookingDate date, RequestStatus status) {
		this.player = player;
		this.playG = playG;
		this.status = status;
		this.id = id;
		this.date = date;
		
	}

	public void updateStatus(RequestStatus status)
	{
		this.status = RequestStatus.Accepted;

	}
	
	public int getID()
	{
		return id;
	}



	@Override
	public String toString() {
		return "Requests [Request_ID= " + id + ", player=" + player.getName() + "\n"+ playG.toString() + ", status=" + status + "]";
	}


	

	
	
	
}
