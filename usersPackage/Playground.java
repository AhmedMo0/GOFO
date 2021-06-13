package usersPackage;

import java.util.ArrayList;

public class Playground {

	private PlaygroundOwner owner;
	private	String name;
	private int size; /////////
	private double pricePerHour;
	protected boolean isActive; ///// instead of enum!!!!!!
	ArrayList<BookingDate> bookingData;
	
	
	
	
	/**
	 * @param owner
	 * @param name
	 * @param size
	 * @param pricePerHour
	 */
	public Playground(PlaygroundOwner owner, String name, int size, double pricePerHour) {
		super();
		this.owner = owner;
		this.name = name;
		this.size = size;
		this.pricePerHour = pricePerHour;
		bookingData = new ArrayList<>();
		isActive = false;
	}

	@Override
	public String toString() {
		return "Playground [owner name =" + owner.getName() + ", Playground name=" + name + ", size=" + size + ", pricePerHour=" + pricePerHour
				+ "]";
	}
	
	
	
	public PlaygroundOwner getMyOwner()
	{
		return owner;
	}
	public void addNewSlot(BookingDate date)
	{
		bookingData.add(date);
	}
	
	public double getPrice()
	{
		return pricePerHour;
	}
	
	public boolean isActive()
	{
		return isActive;
	}
	
	public boolean isItFreeSlot(BookingDate time)
	{
		return time.isBooked();
	}
	
	public BookingDate getDate(int index)
	{
		return bookingData.get(index);
	}
	
	public int findBookingDate(BookingDate date)
	{
		int x = -1;
		for(BookingDate i: bookingData)
		{
			x++;
			if(i.equals(date))
			{
				return x;
			}
		}
		return x;
	}
	
	
	
}
