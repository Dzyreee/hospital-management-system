package HMS;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a hospital department with a unique ID, name, and a list of doctors.
 * Allows adding, removing, and displaying doctors in the department.
 * 
 * @author Omair Nawaz
 * @author Yacine Marabet
 * @author Mir Abbasi
 * @author Abdulrahman Al-Sulaiti
 */
public class Department implements Serializable {

	private int departmentId;
	private String departmentName;
	private ArrayList<Doctor> doctors;

	/**
	 * Constructs a Department with the specified ID and name.
	 * Initializes the list of doctors.
	 * 
	 * @param departmentId the unique ID of the department
	 * @param departmentName the name of the department
	 */
	Department(int departmentId, String departmentName) {
		setDepartmentId(departmentId);
		setDepartmentName(departmentName);
		doctors = new ArrayList<Doctor>();
	}

	/**
	 * Adds a doctor to the department if they are not already present.
	 * 
	 * @param doctor the Doctor object to add
	 */
	public void addDoctor(Doctor doctor) {
		for (Doctor d : doctors) {
			if (d.equals(doctor)) {
				System.out.println("Doctor already in department.");
				return;
			}
		}
		doctors.add(doctor);
		System.out.println("Doctor added to department.");
	}

	/**
	 * Removes a doctor from the department by their ID.
	 * If the doctor is found, they are removed and a confirmation message is printed.
	 * If not found, a message is printed indicating so.
	 * 
	 * @param doctorId the ID of the doctor to remove
	 */
	public void removeDoctor(int doctorId) {
		for (Doctor d : doctors) {
			if (d.getId() == doctorId) {
				doctors.remove(d);
				System.out.println("Doctor removed from department.");
				return;
			}
		}
		System.out.println("Doctor not in department.");
	}

	/**
	 * Displays the department details including its ID, name, and the list of doctors.
	 */
	public void displayDepartmentDetails() {
		System.out.println("Department ID: " + departmentId + " Department Name: " + departmentName);
		if (doctors.isEmpty()) {
			System.out.println("No Doctors in the department.");
			System.out.println("-".repeat(30));
			return;
		}
		System.out.println("Doctors:");
		for (Doctor d : doctors) {
			System.out.print("\t");
			System.out.println(d);
		}
	}

	public ArrayList<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(ArrayList<Doctor> doctors) {
		this.doctors = doctors;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
