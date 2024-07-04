package Project.Final.UserCode;

public class User {
	private String username;
	private String password;
	private String email;
	private String phoeneno;
	
	public User() {
		super();
	}
	
	public User(String username, String password, String email, String phoeneno) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoeneno = phoeneno;
	}

	public String getUsername() {
		return username;
	}

	
	public String getPassword() {
		return password;
	}

	

	public String getEmail() {
		return email;
	}

	public String getPhoeneno() {
		return phoeneno;
	}

	@Override
	public String toString() {
		return "Username=" + username + " \nemail=" + email + " \nphoeneno=" + phoeneno;
	}

}



