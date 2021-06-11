package usersPackage;

import java.util.ArrayList;

public class Playground {

	private PlaygroundOwner owner;
	private	String name;
	private int size; /////////
	private double pricePerHour;
	protected boolean isActive; ///// instead of enum!!!!!!
	ArrayList<BookingDate> bookingData;
	
	
	
	@Override
	public String toString() {
		return "Playground [owner=" + owner + ", name=" + name + ", size=" + size + ", pricePerHour=" + pricePerHour
				+ ", bookingData=" + bookingData.toString() + "]";
	}
	
	public boolean isActive()
	{
		return isActive;
	}
	
	
	
}
