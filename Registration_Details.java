package Project.Final.TrainCode;

 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

import Project.Final.UserCode.User;
 
 
public class Train
{
    static boolean loggedIn;
    User currentUser;
    private static String username;
    private static String password;
    public int gen=0;
	public int ac=0;
	public int sleep=0;
	public int total=0;
	
    public void displayMenu() throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        int choice;
 
        do
        {
            System.out.println("\n** Train Ticket System Menu **");
            System.out.println("1.Register into the website\n2.Login into the website\n3.Check seat avaialability\n4.Book seats\n5.Payment\n6.Ticket Details\n7.Cancel booking\n8.Logout\n9.Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
    
            switch (choice)
            {
                case 1:
                    register(scanner);
                    break;
                case 2:
                    login(scanner);
                    break;
                case 3:
                	checkAvailability(scanner);
                    break;
                case 4:
                	bookSeat(scanner);
                    break;
                case 5:
                	makePayment(gen,ac,sleep);
                    break;
                case 6: ticketDetails(currentUser,bookedSeats,departureStation,destinationStation);
                	break;
                case 7:
                	cancelBooking();
                    break;
                case 8:
                	logoutUser();
                    break;
                case 9:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 9);
 
        scanner.close();
    }
 
 
 
	private void register(Scanner scanner) throws IOException
    {
        this.currentUser = registerUser(scanner);
        this.loggedIn = true;
        System.out.println("Registration Successful!!  \n  Please Login.");
       // username=currentUser.getUsername();
       // password=currentUser.getPassword();
		
		
    }
 
    //registerUser
    public static User registerUser(Scanner scanner) throws IOException
    {
    	
    	System.out.println("\n** Registration **");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("Enter Username (must be alphanumeric):");
            username = br.readLine();
            if (!isValidName(username)) {
                System.out.println("Invalid username format. Please enter alphanumeric characters, underscores, or hyphens only.");
            }
        } while (!isValidName(username));
 
       
        
        
        
        // Validate password here
        do {
            System.out.println(
            "Password Creation: \n1.Minimum length of 8 characters\n2. At least one uppercase\n3. At least one lowercase\n4.At least one special character");
            System.out.println("Enter the password:");
            password = br.readLine();
            if (!isValidPassword(password)) {
            System.out.println("Invalid password format. Please check the requirements.");
            }
            } while (!isValidPassword(password));
 
        //validate email
        String email;
        do {
            System.out.println("Enter Email:");
            email = br.readLine();
            if (!isValidEmail(email)) {
                System.out.println("Invalid email format. Please enter a valid email address.");
            }
        } while (!isValidEmail(email));
        String phoneno;
        do {
            System.out.println("Enter phoneno:");
            phoneno = br.readLine();
            if (!isValidPhonenumber(phoneno)) {
                System.out.println("Invalid phoneno format. Please enter a valid email address.");
            }
        } while (!isValidPhonenumber(phoneno));
        
 
        return new User(username, password, email, phoneno);
    	
    }
    private static boolean isValidPhonenumber(String phoneno) {
		// TODO Auto-generated method stub
		return phoneno.matches("\\d{10}");
	}
 
 
 
	private static boolean isValidEmail(String email)
    {
		// TODO Auto-generated method stub
		String regullar_form = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		return email.matches(regullar_form);
	}
  
	private static boolean isValidPassword(String password)
    {
		// TODO Auto-generated method stub
    	if (password.length() < 8) {
    		return false;
    		}
    		if (!password.matches(".*[A-Z].*")) {
    		return false;
    		}
    		if (!password.matches(".*[a-z].*")) {
    		return false;
    		}
    		if (!password.matches(".*[!@#$%^&*()-+=\\[\\]{};:'\"\\\\|,.<>/?].*")) {
    		return false;
    		}
    		return true;
  
	}
 
	private static boolean isValidName(String username) {
 
		return username.matches("[a-zA-Z]+");
		 //return username.matches("[a-zA-Z0-9_-]+");
	}
 
	void login(Scanner scanner)
    {
       Scanner sc = new Scanner(System.in);
        System.out.println("Menu\n1.Loggin in\n2.Register new user");
        System.out.println("Enter your choice:");
        int choice=sc.nextInt();
        switch(choice)
        {
        	case 1:
                System.out.println("Logging in...");
                
                System.out.println("Enter Username:");
                String enteredusername = sc.next();
                if(enteredusername.equals(username))
                {
                	loggedIn =true;
                	System.out.println("Enter Password:");
                	String enteredpassword = sc.next();
                	if(enteredpassword.equals(password))
                	{
                		loggedIn=true;
                		System.out.println("....LOGIN SUCCESSFULL....");
                	}
                	else
                	{
                		System.out.println("Invalid password. Please try again..");
                	}
                
                }
                else
                {
                 System.out.println("Invalid username");
                 System.out.println(".....LOGIN AGAIN......");
                }
                break;
        	case 2:System.out.println("Plz register first....");
        	break;
        	default :System.out.println("Exit");break;
        }
		
    }
    
    //loginUser
    public static boolean loginUser(Scanner scanner)
    {
        System.out.println("\n** Login **");
        
       // System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();
 
        return true;
    }
    
    
    //book seat method
    int totalSeats = 100; // Total number of seats available
    int bookedSeats = 0;  // Number of seats currently booked
    int availableSeats=0;
    String departureStation;
    String destinationStation;
    
    public void bookSeat(Scanner scanner)
    {
    	
    	String ch;
    	do
    	{
    		System.out.println("Select your seats:\n 1.General(G) \n2.A/C(Ac)\n3.Sleeper(S)");
        	ch= scanner.next();
        	switch(ch)
        	{
        		case "G" :System.out.println("Enter the number of General seats:");
        					gen=scanner.nextInt();
        					break;
      
        		case "AC" :System.out.println("Enter the number of A/C seats:");
    						ac=scanner.nextInt();
    						break;
    			
        		case "S"	:System.out.println("Enter the number of Sleeper seats:");
    						sleep=scanner.nextInt();
    						break;
        		case "0":System.out.println("Exit");
        				break;
    			default:System.out.println("Please enter proper input");
    			  
        	}
    		
    	}while(!ch.equals("0"));
 
    		bookedSeats=gen+ac+sleep;
            System.out.println(bookedSeats +"Seat(s) booked successfully from " + departureStation + " to " + destinationStation + ".");
 
    }
    
    
    //seat availability method
      public void checkAvailability(Scanner scanner) throws IOException
      {
          System.out.println("Total seats: " + totalSeats);
          System.out.println("Booked seats: " + bookedSeats);
          availableSeats=totalSeats-bookedSeats;
          System.out.println("Available seats: " + availableSeats);
          
 
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
          do {
          System.out.println("Enter Departure Station (must be alphabetic):");
          departureStation= br.readLine();
          try {
          if (!isValidName(departureStation)) {
          System.out.println("Invalid format. Please enter alphabetic characters only.");
          }
          } catch (Exception e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
          }
          } while (!isValidName(departureStation));
           
          
          BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
          
          do {
          System.out.println("Enter Destination Station (must be alphabetic):");
          destinationStation= br1.readLine();
          try {
          if (!isValidName(destinationStation)) {
          System.out.println("Invalid format. Please enter alphabetic characters only.");
          }
          } catch (Exception e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
          }
          } while (!isValidName(destinationStation));
           
          if(availableSeats == 0)
          {
        	  System.out.println("Sorry Tickets are not available");
          }
          else
          {
        	  System.out.println("Please book your tickets");
          }
 
      }
 
    //payment method
      public void makePayment(int gen , int ac, int sleep)
      {
    	  int gent=gen*100;
    	  int act=ac*200;
    	  int sleept=sleep*300;
    	  total=gent+act+sleept;
    	  System.out.println("Pay the amount :$"+total);
    	  Scanner scanner = new Scanner(System.in);
		int amnt=scanner.nextInt();
    	  if(amnt==total)
    	  {
    		  System.out.println("Amount Paid:"+total +"\n Payment successful.");
    	  }
    	  else
    	  {
    		  System.out.println("Payment unsuccessful. \nPlease try again!!!");
    	  }
         
      }
    
      //cancel booking method
      public void cancelBooking()
      {
          if (bookedSeats > 0)
          {
              bookedSeats--;
              System.out.println("Booking cancelled successfully.");
          } else {
              System.out.println("No bookings to cancel.");
          }
      }
      
      
      //loutUser method
      public void logoutUser()
      {
          System.out.println("Logged out successfully.");
      }
      
      
      //display ticket details
      public void ticketDetails(User currentUser, int bookedSeats,String departureStation, String destinationStation)
      {
    	  System.out.println("----------------Ticket Details--------------------");
    	  //usernmae
    	  System.out.println(currentUser);
    	  //pnr no
    	  System.out.println("PNR Number:"+randomNum10());
    	  
    	  //ticketno
    	  System.out.println("Ticket NO:"+randomNum5());
    	  //departure
    	  System.out.println("Your departure:"+departureStation);
    	  //destnation
    	  System.out.println("Your destination:"+destinationStation);
    	  //bookedseats
    	  System.out.println("Number of Tickets booked:"+bookedSeats);
    	  
    	  //amount paid
    	  System.out.println("Amount Paid:"+total);
    	  
    	  //booked date time
    	  System.out.println("Booking Date and Time: " + formatDateTime(LocalDateTime.now()));
    	  //arival date and time
    	  int journeyDurationHours=15;
    	  System.out.println("Estimated Arrival Date and Time: " + formatDateTime(LocalDateTime.now().plusHours(journeyDurationHours)));
      }
      
      private String formatDateTime(LocalDateTime plusHours)
      {
		// TODO Auto-generated method stub
    	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
          return plusHours.format(formatter);
      }
 
	//train no 10 digit no
      public static String randomNum10()
      {
          Random random = new Random();
          
          // Generate first 3 digits
          int firstPart = random.nextInt(1000); // Generate a number between 0 and 999
          String firstPartString = String.format("%03d", firstPart); // Ensure 3-digit format
          
          // Generate last 7 digits
          long secondPart = random.nextInt(10000000); // Generate a number between 0 and 9999999
          String secondPartString = String.format("%07d", secondPart); // Ensure 7-digit format
          
          // Concatenate parts with a hyphen
          String randomNumber = firstPartString + "-" + secondPartString;
          
          return randomNumber;
      }
      
      public static int randomNum5()
      {
    	  int min = 10000; // minimum 5-digit number (10^4)
          int max = 99999; // maximum 5-digit number (10^5 - 1)
 
          Random random = new Random();
          int randomNumber = random.nextInt(max - min + 1) + min;
          
          return randomNumber;
      }
}
 
