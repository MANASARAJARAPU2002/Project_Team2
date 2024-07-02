package Project.Team2.FinalCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Random;

	class Train {
	    private static boolean loggedIn;
	    private int totalSeats = 100; 
	    private static int bookedSeats = 0;
	    private static String registeredUsername;
	    private static String registeredPassword;
	    private static String departure,destination;
	    private static String phonenumber,fullname;
	    private double totalAmount = 0;
	    private int General_seat=100,Sleeper_seat=200,Ac_seat=300;
	    public Train() {
	        this.loggedIn = false; 
	    }

	    public void displayMenu() throws NumberFormatException, IOException {
	        Scanner scanner = new Scanner(System.in);
	        int choice;
	        do {
	            System.out.println("\n*** Train Ticket System Menu ***");
	            System.out.println("Menu\n1.Register\n2.Login\n3.Check seat Availability\n4.Book seat\n5.Make payment process\n6.Display ticket details\n7.Cancel booking seats\n8.Logout\n9.Exit");//Show the menu
	            System.out.print("Enter your choice:");
	            choice = scanner.nextInt();
	            switch (choice) {
	                case 1:Register_User();break;//enter 1 to register 
	                case 2:Login_In();break;//enter 2 to login
	                case 3:Check_Availability(); break; //enter 3 to check availability
	                case 4:Book_Seat();;break;//enter 4 to book seat
	                case 5:Make_Payment();break;//enter 5 to make payment process
	                case 6:Ticket_Details();break;//enter 6 to display the ticket details
	                case 7:Cancel_Booking(); break;//enter the 7 to cancel the booking seats
	                case 8:Log_out();break;//enter the 8 to cancel booking
	                case 9:System.out.println("Exit Successfully");break;
	                default:
	                    System.out.println("Invalid choice. Please enter a valid option.");
	            }
	        } while (choice != 9);

	        scanner.close();
	    }
		private static void Register_User() {
			//Enter into the register method to register
	    	Scanner sc= new Scanner(System.in);
	    	System.out.println("....REGISTRATION PROCESS STARTS...");
	    	String username;
			do {
				System.out.println("Enter Username (must be alphabetic):");
				username = sc.next();
				try {
					if (!isValidName(username)) {
						System.out.println("Invalid username format. Please enter alphabetic characters only.");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} while (!isValidName(username));
			 registeredUsername = username;
			String password;
			do {
				System.out.println("Password Creation: \n1.Minimum  length of 8 characters\n2. At least one uppercase\n3. At least one lowercase\n4.At least one special character");
				System.out.println("Enter the password:");
				password = sc.next();
				if (!isValidPassword(password)) {
					System.out.println("Invalid password format. Please check the requirements.");
				}
			} while (!isValidPassword(password));
			 registeredPassword = password;
			sc.nextLine();
	
			System.out.println("Enter the full name:");
			fullname=sc.nextLine();
			
			String email;
			do {
				System.out.println("Enter email I'd:");
				email=sc.nextLine();
				try {
					if(!isValidEmail(email)) {
						System.out.println("Invalid email format. Please enter email id correctly");
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}while(!isValidEmail(email));
				
			do {
				System.out.println("Enter the phone number:");
				phonenumber=sc.next();
				try {
					if(!isValidphoneno(phonenumber)) {
						System.out.println("Invalid phone number . Please enter phone number with 10 digits");
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}while(!isValidphoneno(phonenumber));
			
			System.out.println(".......REGISTRATION COMPLETED SUCCESSFULLY......");
			
	}
//checking the phone number is valid or not
	   private static boolean isValidphoneno(String phonenumber) {
			return phonenumber.matches("\\d{10}");
		}
//checking the email is valid or not
	private static boolean isValidEmail(String email) {
	    			String regular_form = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	    			return email.matches(regular_form);
	    }
	    //checking the password is valid or not
			private static boolean isValidPassword(String password) {
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
//checking name is valid or not
		private static boolean isValidName(String username) {
			
			return username.matches("[a-zA-Z]+");
		}

		private static void Login_In() 
		{
			//Enter into the login method to login into
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu\n1.Loggin in\n2.Register new user");
		System.out.println("Enter your choice:");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:System.out.println("Logging in..."); System.out.println("Enter Username:");
		//checking entered user name is equals to registered username 
        String username = sc.next();
        if(username.equals(registeredUsername)) {
        	loggedIn =true;
        	//If username is valid then only it asks password
        System.out.println("Enter Password:");
        String password = sc.next();
        if(password.equals(registeredPassword)){
        	loggedIn=true;
        	System.out.println("....LOGIN SUCCESSFULLY....");
        }
        else
        {
        	//If password is not 
        	System.out.println("Invalid password. Please try again..");
        }}
        else {
        	System.out.println("Invalid username");
        	System.out.println(".....LOGIN AGAIN......");
        }
        break;
		case 2: System.out.println("....Plz register first...."); break;
		default:System.out.println("Exit");

		}
	}
   
		private void Book_Seat() {
	        if (!loggedIn) {
	            System.out.println(".....Please login first....");
	            return;
	        }
	        //Enter into into the booking seat method
	        Scanner sc = new Scanner(System.in);
	        //enter the departure location
	        System.out.println("Enter Departure:");
	        departure = sc.nextLine().trim();
	        //enter the destination location
	        System.out.println("Enter destination location:");
	        destination = sc.nextLine();
	        if (!isValidLocation(departure) || !isValidLocation(destination)) {
	            System.out.println("Invalid departure or destination.");
	            return;
	        }
	        //enter the no of seats to book
	        System.out.println("Enter the no of seats to book:");
	        int seat_count=sc.nextInt();

	        if (bookedSeats < totalSeats) {
	            bookedSeats++;
	            System.out.println(seat_count+" "+"Seat(s) booked successfully from " + departure + " to " + destination + ".");
	        } else {
	            System.out.println("Sorry, no seats available.");
	        }
		}
		//checking the location is valid or not

	    private boolean isValidLocation(String location) {
	    	return !location.isEmpty();
		}
//Checking the seat availability 
		private void Check_Availability() {
	        System.out.println("Total seats: " + totalSeats);
	        System.out.println("Booked seats: " + bookedSeats);
	        System.out.println("Available seats: " + (totalSeats - bookedSeats));
	    }
//enter into the payment process
	    private void Make_Payment() throws NumberFormatException, IOException {
	        if (!loggedIn) {
	            System.out.println("Please login first."); return;
	        }
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        //enter the no of tickets booked
	        System.out.println("Enter the no of tickets booked:");
	        int count=Integer.parseInt(br.readLine());
	        //enter the number of general seats booked
	        System.out.println("Enter the number of general seats booked:");
	        int General = Integer.parseInt(br.readLine());
	        //enter the number of sleeper seats booked
	        System.out.println("Enter the number of sleeper seats booked:");
	        //enter the number of Ac seats booked
	        int Sleeperseat = Integer.parseInt(br.readLine());
	        System.out.println("Enter the number of AC seats booked");
            int Acseats=Integer.parseInt(br.readLine());
            //calculate the total amount to pay
	        totalAmount = (General * General_seat) + (Sleeperseat * Sleeper_seat)+(Acseats*Ac_seat);
	        System.out.println("Total amount to pay: $" + totalAmount);
	        //enter the amount to pay
	        System.out.println("Enter the amount to pay:");
	        double Amount=Double.parseDouble(br.readLine());
	        //total amount equals to amount payment successfully
	        if(Amount==totalAmount)
	        System.out.println("********Payment successful*********");
	        //if total amount not equals to amounte payment is failed
	        else
	        	System.out.println("*******Payment Failed. Try Again*********");
	    }
	    //if you want to cancel the booking enter into this method
	    private void Cancel_Booking() {
	        if (!loggedIn) {
	            System.out.println("Please login first.");return;
	        }

	        if (bookedSeats > 0) {
	            bookedSeats--;
	            System.out.println("***********Booking cancelled successfully***************");
	        } else {
	            System.out.println("No bookings to cancel.");
	        }
	    }
	    public static void Ticket_Details( )
	    {
	    	//display the ticket details like username , fullname, pnr_no,ticket_id, departure, destination, phone number, booked seat and date and time and estimated arrival date and time
	    	System.out.println("*********************************************");
	    	System.out.println("****TICKET DETAILS****");
	    	
	        	  System.out.println("Username:"+ registeredUsername);
	        	  System.out.println("Fullname:"+fullname);
	        	  System.out.println("PNR Number:" +PNR_No());
	        	  System.out.println("Ticket NO:"+Ticket_Id());
	        	  System.out.println("Your departure:"+departure);
	        	  System.out.println("Your destination:"+destination);
	        	  System.out.println("Phone number:"+ phonenumber);
	        	  System.out.println("Number of Tickets booked:"+bookedSeats);
	        	  System.out.println("Booking Date and Time: " + formatDateTime(LocalDateTime.now()));
	        	  int journeyDurationHours=15;
	        	  System.out.println("Estimated Arrival Date and Time: " + formatDateTime(LocalDateTime.now().plusHours(journeyDurationHours)));
	        	  
	        	  System.out.println("*********************HAPPY JOURNEY****************************");
		        }

			private static String formatDateTime(LocalDateTime plusHours)
	          {
	        	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	              return plusHours.format(formatter);
	          }
				      public static String PNR_No()
				      {
				          Random random = new Random();
				          int firstPart = random.nextInt(1000);
				          String firstPartString = String.format("%03d", firstPart);
				          long secondPart = random.nextInt(10000000);
				          String secondPartString = String.format("%07d", secondPart);
				          String randomNumber = firstPartString + "-" + secondPartString;
				          return randomNumber;
				      }
				      
				      public static int Ticket_Id()
				      {
				    	  int min_value = 10000;
				          int max_value = 99999; 
				          Random random = new Random();
				          int random_Number = random.nextInt(max_value - min_value + 1) + min_value;
				          return random_Number;
				      }
	          
	    private void Log_out() {
	        this.loggedIn = false;
	        System.out.println("*******Logged out successfully******");
	    }
	}
	public class Online_Train_Ticket_Booking {
	    public static void main(String[] args) throws NumberFormatException, IOException {
	        Train train = new Train();
	        train.displayMenu();
	        
	    }

		
	}



