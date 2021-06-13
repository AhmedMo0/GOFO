package appServices;
import java.util.ArrayList;

import usersPackage.*;

public class Booking {

	private ArrayList<Playground> livePlaygrounds;
	private ArrayList<Requests> allReqs;
	
	private static int requestID =0;
	
	/**
	 * Constructor
	 * */
	public Booking() 
	{
		livePlaygrounds = new ArrayList<>();
		allReqs = new ArrayList<>();
	}
	
	/**
	 * add new playground
	 * @param newPlayG new playground that will be added to available playgrounds menu
	 * */
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
		int x = 0;
		if(!livePlaygrounds.isEmpty())
		{
			for(Playground playG: livePlaygrounds)
			{
				System.out.println("------------------------------\n" + "index: " + x +"\n" + playG.toString() + "\n------------------------------\n");
				x++;
			}
		}
		else
		{
			System.out.println("List is empty!!");
		}
	}
	
	public void sendBookingReq(Playground playG, Player player, Requests req)
	{
		player.addNewRequest(req);
		playG.getMyOwner().addNewRequest(req);
		allReqs.add(req);
	}
	
	public void book(Playground playG, Player player, BookingDate date)
	{
		boolean ok = false;
		
		//check if chosen slot is free
		int index = playG.findBookingDate(date); // index of date
		
		if(index != -1) // date found
		{
			if(playG.getDate(index).isBooked())
			{
				System.out.println("Sorry this slot is booked");
			}
			else
			{
				requestID++; // generate new id for this request
				
				playG.getDate(index).bookTo(player.getName());
				double price = playG.getPrice() * playG.getDate(index).getHours();
				
				// create request to send it to owner and player
				
				Requests tmpRequest = new Requests(requestID, player, playG, date, RequestStatus.Pending);
				sendBookingReq(playG, player, tmpRequest);
				
				//send feedback
				System.out.println("Reservation completed successfully and you will pay: " + price + " $");
			}
		}
		else // if this time slot not reserved before
		{
			requestID++; // generate new id for this request
			
			playG.addNewSlot(date); // add this new slot to playground slots 
			index = playG.findBookingDate(date); // index of date
			
			playG.getDate(index).bookTo(player.getName());
			double price = playG.getPrice() * playG.getDate(index).getHours();
			
			// create request to send it to owner and player
			
			Requests tmpRequest = new Requests(requestID, player, playG, date, RequestStatus.Pending);	
			sendBookingReq(playG, player, tmpRequest);
			
			//send feedback
			System.out.println("Reservation completed successfully and you will pay: " + price + " $");
			
			
		}
	}
	
	
}
