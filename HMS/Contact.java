package HMS;

import java.io.Serializable;

/**
 * Represents contact information for a person, including email and phone number.
 * 
 * @author Omair Nawaz
 * @author Yacine Marabet
 * @author Mir Abbasi
 * @author Abdulrahman Al-Sulaiti
 */
public class Contact implements Serializable {
	private String email;
	private String phoneNumber;

	/**
	 * Constructs a Contact object with the specified email and phone number.
	 *
	 * @param email the email address
	 * @param phoneNumber the phone number
	 */
	public Contact(String email, String phoneNumber) {
		setEmail(email);
		setPhoneNumber(phoneNumber);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Displays the contact information to the console.
	 */
	public void displayContactInfo() {
		System.out.println("Email: " + email + " phoneNumber: " + phoneNumber);
	}

	/**
	 * Returns a string representation of the contact information.
	 *
	 * @return a formatted string containing email and phone number
	 */
	public String toString() {
		return "Email: " + email + " phoneNumber: " + phoneNumber;
	}
}
