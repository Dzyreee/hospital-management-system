package HMS;

import java.io.Serializable;

/**
 * Represents a doctor in the hospital system, extending the Person class and including a specialization.
 * 
 * @author Omair Nawaz
 * @author Yacine Marabet
 * @author Mir Abbasi
 * @author Abdulrahman Al-Sulaiti
 */
public class Doctor extends Person implements Serializable {
	private String specialization;

	/**
	 * Constructs a Doctor object with specified ID, name, contact info, gender, and specialization.
	 *
	 * @param id the unique identifier of the doctor
	 * @param name the name of the doctor
	 * @param contact the contact information of the doctor
	 * @param gender the gender of the doctor
	 * @param specialization the doctor's medical specialization
	 */
	Doctor(int id, String name, Contact contact, Gender gender, String specialization) {
		super(id, name, contact, gender);
		setSpecialization(specialization);
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	/**
	 * Displays the doctor's details including inherited person information and specialization.
	 */
	@Override
	public void displayDetails() {
		System.out.println(super.toString() + " Specialization: " + specialization);
	}

	/**
	 * Returns a string representation of the doctor, including inherited person info and specialization.
	 *
	 * @return a formatted string with doctor details
	 */
	@Override
	public String toString() {
		return super.toString() + ", Specialization: " + specialization;
	}
}
