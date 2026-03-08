package HMS;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Represents an appointment in the hospital management system.
 * 
 * @author Omair Nawaz
 * @author Yacine Marabet
 * @author Mir Abbasi
 * @author Abdulrahman Al-Sulaiti
 */
public class Appointment implements Serializable {
	private int appointmentID;
	private int patientID;
	private int doctorID;
	private LocalDate appointmentDate;
	private AppointmentStatus appointmentStatus;

	/**
	 * Constructs an Appointment object with the given IDs and date.
	 * The default status is set to UNKNOWN.
	 *
	 * @param appointmentID the unique ID of the appointment
	 * @param patientID the ID of the patient
	 * @param doctorID the ID of the doctor
	 * @param appointmentDate the date of the appointment
	 */
	public Appointment(int appointmentID, int patientID, int doctorID, LocalDate appointmentDate) {
		this.appointmentID = appointmentID;
		this.patientID = patientID;
		this.doctorID = doctorID;
		this.appointmentDate = appointmentDate;
		this.appointmentStatus = AppointmentStatus.UNKNOWN;
	}

	public int getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(int appointmentID) {
		this.appointmentID = appointmentID;
	}

	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	public int getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public AppointmentStatus getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	/**
	 * Confirms the appointment by setting its status to CONFIRMED
	 * and prints a confirmation message.
	 */
	public void confirmAppointmet() {
		this.appointmentStatus = AppointmentStatus.CONFIRMED;
		System.out.println("Appointment Confirmed");
	}

	/**
	 * Cancels the appointment by setting its status to CANCELLED
	 * and prints a cancellation message.
	 */
	public void cancelAppointmet() {
		this.appointmentStatus = AppointmentStatus.CANCELLED;
		System.out.println("Appointment Cancelled");
	}

	/**
	 * Reschedules the appointment to a new date.
	 *
	 * @param newDate the new appointment date
	 */
	public void rescheduleAppointment(LocalDate newDate) {
		this.appointmentDate = newDate;
	}

	/**
	 * Returns a string representation of the appointment, including IDs, date,
	 * and status.
	 *
	 * @return formatted string with appointment details
	 */
	public String toString() {
		return "Appointment ID: " + appointmentID + ", Patient ID: " + patientID + ", Doctor ID: " + doctorID
				+ ", Appointment Date: " + appointmentDate + ", Appointment Status: " + appointmentStatus;
	}
}
