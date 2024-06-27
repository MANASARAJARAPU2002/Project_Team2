package Capstone.Project.Team2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Registration_Details {
	private User_Details user;

	public Registration_Details(User_Details user) {
		this.user = user;

	}

	private static boolean isValidName(String name) {
		return name.matches("[a-zA-Z]+");
	}

	private static boolean isValidEmail(String email) {
		// Regular expression for email validation
		String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		return email.matches(regex);
	}

	private static boolean isValidPassword(String password) {
		// Password must be at least 8 characters long
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

	private static boolean isValidPhoneNumber(String phone) {
		// Phone number must be exactly 10 digits
		return phone.matches("\\d{10}");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Login Details:");

		String username;
		do {
			System.out.println("Enter Username (must be alphabetic):");
			username = br.readLine();
			try {
				if (!isValidName(username)) {
					System.out.println("Invalid username format. Please enter alphabetic characters only.");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (!isValidName(username));

		String password;
		do {
			System.out.println(
					"Password Creation: \n1.Minimum  length of 8 characters\n2. At least one uppercase\n3. At least one lowercase\n4.At least one special character");
			System.out.println("Enter the password:");
			password = br.readLine();
			if (!isValidPassword(password)) {
				System.out.println("Invalid password format. Please check the requirements.");
			}
		} while (!isValidPassword(password));
		
		System.out.println("Registration process starts......");
		
		System.out.println("Enter full name:");
		String fullName = br.readLine();
		
		String email1;
		do {
			System.out.println("Enter Email:");
			email1 = br.readLine();
			if (!isValidEmail(email1)) {
				System.out.println("Invalid email format. Please enter a valid email address.");
			}
		} while (!isValidEmail(email1));
		
		
		
		String phone;
		do {
			System.out.println("Enter phone number (must be 10 digits):");
			phone = br.readLine();
			if (!isValidPhoneNumber(phone)) {
				System.out.println("Invalid phone number format. Please enter exactly 10 digits.");
			}
		} while (!isValidPhoneNumber(phone));
		System.out.println("Registration process ends........");
		User_Details user = new User_Details(username, password, fullName, email1, phone);
		Registration_Details reg = new Registration_Details(user);

		// Close the scanner
		br.close();
	}
}
