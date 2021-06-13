package appServices;
import java.io.File;
import java.util.Scanner;

import usersPackage.*;

public class SystemUI {

	
	Database database; // class that has all users information
	public Booking booking; // class that has all available playgrounds
	
	UserProfile currentUser;
	
	Administrator defaultAdmin;
	
	
	
	Scanner scan = new Scanner(System.in);

	/**
	 * @param database
	 */
	public SystemUI(Database database) {
		booking = new Booking();
		this.database = database;
		defaultAdmin = database.adminList.get(0);
		defaultAdmin.linkWithSystemUI(this);
		
	}
	
	
	public void signUpPlayer(Player player)
	{
		database.addPlayer(player);
	}
	
	public void signUpPlaygroundOwner(PlaygroundOwner owner)
	{
		database.addPlaygroundOwner(owner);
	}
	
	public void signUpAdmin(Administrator admin)
	{
		database.addadmin(admin);
	}
	
	public void login(String email, String password)
	{
		int userType = database.isValidAccount(email, password);
		boolean valid = false;
		int type;
		
		while(!valid)
		{
			switch(userType)
			{
				case 0:
				{
					System.out.println("Invalid email or password");
					
					valid = true;
					break;
				}
				
				default:
				{
					currentUser = database.user;
					valid = true;
					
					if(userType == 1)
					{
						defaultAdmin = (Administrator)currentUser;
						adminMenu();
						
					}
					else if(userType == 2)
					{
						playerMenu();
					}
					else
					{
						ownerMenu();
					}
				}
			}
		}
		
	}
	
	public void playerMenu()
	{
		Player player = (Player)currentUser; 
		
		int choice = 0;
		boolean valid = true;
		
		boolean correctChoice = false;
		while(valid)
		{
			
			while(!correctChoice)
			{
				System.out.println("1- Book Playground\n"
						  +"2- View my requests\n"
						  +"3- logOut");
		
				choice = scan.nextInt();
				
				if(choice >=1 && choice <= 3)
				{
					correctChoice = true;
				}
				else
				{
					correctChoice = false;
				}
			}
		
			switch(choice)
			{
				case 1:
				{
					int index;
					booking.showAvailablePlayG();
					
					System.out.println("1- choose playground\n"+
									   "2- Go back to menu");
					int num = scan.nextInt();
					if(num == 2)
					{
						correctChoice = false;
						break;
					}
					System.out.println("1-type playground index");
					index = scan.nextInt();
					
					Playground tmpPlayG = booking.getPlayG(index);
					
					System.out.println("type your time slot details");
					System.out.println("Day:");
					int day = scan.nextInt();
					
					System.out.println("month:");
					int month = scan.nextInt();
					
					System.out.println("year:");
					int year = scan.nextInt();
					
					System.out.println("start hour:");
					int startTime = scan.nextInt();
					
					System.out.println("end hour:");
					int endTime = scan.nextInt();
					
					BookingDate date = new BookingDate(day, month, year, startTime, endTime);
					
					booking.book(tmpPlayG, player, date);
					
					correctChoice = false;
					break;
				}
				
				case 2:
				{
					player.showMyRequests();
					correctChoice = false;
					break;
				}
				
				case 3:
				{
					valid = false;
					break;
				}
				
				default:
				{
					valid = true;
				}
			}
		
		}
	}
	
	public void ownerMenu()
	{
		PlaygroundOwner owner = (PlaygroundOwner)currentUser; 
		
		int choice = 0;
		boolean valid = true;
		
		boolean correctChoice = false;
		while(valid)
		{
			
			while(!correctChoice)
			{
				System.out.println("1- add playground\n"
						  +"2- View my requests\n"
						  +"3- logOut");
		
				choice = scan.nextInt();
				
				if(choice >=1 && choice <= 3)
				{
					correctChoice = true;
				}
				else
				{
					correctChoice = false;
				}
			}
		
			switch(choice)
			{
				case 1:
				{
					
					System.out.println("playground name:");
					String name = scan.next();
					
					System.out.println("playground size:");
					int size = scan.nextInt(); 
					
					System.out.println("price per hour:");
					double pricePerHour = scan.nextDouble();
					
					Playground tmpPlayG = new Playground(owner, name, size, pricePerHour);
					
					owner.addPlayground(tmpPlayG);
					defaultAdmin.addRequestedPlayground(tmpPlayG);
					
					correctChoice = false;
					break;
				}
				
				case 2:
				{
					if(owner.showMyRequests())
					{
						System.out.println("1- choose request to accept\n"+
								   "2- Go back to menu");
						int num = scan.nextInt();
						if(num == 2)
						{
							correctChoice = false;
							break;
						}
						
						System.out.println("Enter Index of request");
						int reqNum = scan.nextInt();
						
						owner.acceptReq(reqNum);
						
						correctChoice = false;
						break;
						
					}
					correctChoice = false;
					break;
				}
				
				case 3:
				{
					valid = false;
					break;
				}
				
				default:
				{
					valid = true;
					correctChoice = false;
				}
			}
		
		}
		
	}
	
	
	public void adminMenu()
	{ 	
		int choice = 0;
		boolean valid = true;
		
		boolean correctChoice = false;
		while(valid)
		{
			
			while(!correctChoice)
			{
				System.out.println("1- check new requested playgrounds\n"
						  +"2- logOut");
		
				choice = scan.nextInt();
				
				if(choice >=1 && choice <= 2)
				{
					correctChoice = true;
					if(choice == 2)
					{
						valid = false;
					}
				}
				else
				{
					correctChoice = false;
				}
			}
		
			switch(choice)
			{
				case 1:
				{
					defaultAdmin.showAllRequestedPlayGs();
					System.out.println("1- choose playground to accept\n2- logout");
					int num = scan.nextInt();
					
					if(num == 1)
					{
						System.out.println("Enter playground index to accept");
						int index = scan.nextInt();
						
						Playground tmpPlayG = defaultAdmin.getPlayG(index);
						
						defaultAdmin.addPlayGToLiveList(tmpPlayG);
						
						System.out.println("playground Accepted!");
					}
					else
					{
						valid = false;
						break;
					}
					
					break;
				}
				
				case 2:
				{
					valid = false;
					break;
				}
			
				
				default:
				{
					valid = false;
				}
			}
		
		}
	}
	

}
