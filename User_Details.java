package Capstone.Project.Team2;

	public class User_Details {
	    private int userId;
	    private String name;
	    private String email;
	    private String password;
	    private String phoneNumber;

	    public User_Details() {
	    	super();
	    }

	    public User_Details(String name, String email, String password, String phoneNumber, String address) {
	        this.name = name;
	        this.email = email;
	        this.password = password;
	        this.phoneNumber = phoneNumber;
	        
	    }
		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}		
	    
	}


