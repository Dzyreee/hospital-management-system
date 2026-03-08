package HMS;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a bill linked to a specific appointment, including services rendered and their costs.
 * Implements the Payable interface to allow calculation of total charges.
 * 
 * @author Omair Nawaz
 * @author Yacine Marabet
 * @author Mir Abbasi
 * @author Abdulrahman Al-Sulaiti
 */
public class Bill implements Payable, Serializable {

	private int billId;
	private int appointmentId;
	private double amount;
	private ArrayList<String> services;
	private String date;

	/**
	 * Constructs a Bill object associated with an appointment and initializes services.
	 * 
	 * @param billId the unique ID of the bill
	 * @param appointmentId the appointment ID linked to this bill
	 * @param date the date the bill was generated
	 */
	Bill(int billId, int appointmentId, String date) {
		setBillId(billId);
		setAppointmentId(appointmentId);
		services = new ArrayList<String>();
		setAmount(0);
		setDate(date);
	}

	/**
	 * Adds a service to the bill and updates the total amount accordingly.
	 * Service codes from "1" to "10" are supported.
	 * 
	 * @param service the service code representing a medical service
	 */
	public void addService(String service) {
		switch (service) {
			case "1": {
				services.add("Consultation");
				amount += 50;
				break;
			}
			case "2": {
				services.add("Diagnostic Imaging");
				amount += 100;
				break;
			}
			case "3": {
				services.add("Laboratory Test");
				amount += 50;
				break;
			}
			case "4": {
				services.add("Advanced Scan");
				amount += 500;
				break;
			}
			case "5": {
				services.add("Surgical Procedure");
				amount += 1000;
				break;
			}
			case "6": {
				services.add("Emergency Care");
				amount += 150;
				break;
			}
			case "7": {
				services.add("Wound Dressing");
				amount += 70;
				break;
			}
			case "8": {
				services.add("Rehabilitation Session");
				amount += 60;
				break;
			}
			case "9": {
				services.add("Immunization");
				amount += 25;
				break;
			}
			case "10": {
				services.add("Routine screening");
				amount += 120;
				return;
			}
			default: {
				System.out.println("Invalid value entered.");
			}
		}
	}

	/**
	 * Prints a detailed invoice of the bill, including services, date, and total cost.
	 */
	public void generateInvoice() {
		System.out.println("Bill ID: " + billId);
		System.out.println("Appointment ID: " + appointmentId);
		System.out.println("Services: ");
		for (String s : services)
			System.out.println(s);
		System.out.println("Date: " + date);
		System.out.printf("Amount: QAR%.2f\n", amount);
	}

	public ArrayList<String> getServices() {
		return services;
	}

	public void setServices(ArrayList<String> services) {
		this.services = services;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * Calculates the total payment due for this bill.
	 * 
	 * @param billId the ID of the bill (unused in current implementation)
	 * @return the total amount due
	 */
	public double calculatePayment(int billId) {
		return this.amount;
	}
}
