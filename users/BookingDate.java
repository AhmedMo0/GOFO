package usersPackage;

public class BookingDate {

	private	int day;
	private int month;
	private	int year;
	private int startTime;
	private int endTime;
	private	String playerName;
	private	boolean isBooked; 
	
	
	public BookingDate()
	{
		this.day = 6;
		this.month = 6;
		this.year = 2021;
		this.startTime = 6;
		this.endTime = 7;
		this.playerName = "";
		this.isBooked = false;
	}
	
	public BookingDate(int day, int month, int year, int startTime, int endTime)
	{
		this.day = day;
		this.month = month;
		this.year = year;
		this.startTime = startTime;
		this.endTime = endTime;
		this.playerName = "";
		this.isBooked = false;
	}
	
	public void bookTo(String playerName) {
		this.playerName = playerName;
		isBooked = true;
	}
	
	public boolean isBooked()
	{
		return isBooked;
	}

	@Override
	public String toString() {
		return "BookingDate [day=" + day + ", month=" + month + ", year=" + year + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}
	
	
	
	
}
