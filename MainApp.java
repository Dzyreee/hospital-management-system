package HMS;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * MainApp class for managing the Hospital Management System.
 * 
 * @author Omair Nawaz
 * @author Yacine Marabet
 * @author Mir Abbasi
 * @author Abdulrahman Al-Sulaiti
 */
public class MainApp {
    public static HospitalSystem hs = new HospitalSystem();
    public static Scanner input = new Scanner(System.in);

    /**
     * The main entry point for the Hospital Management System application.
     * Displays the main menu and calls the appropriate methods based on user input.
     */
    public static void main(String[] args) {
        loadDataFromFiles();
        String in;
        while (true) {
            System.out.println("====== Hospital Management Menu ======");
            System.out.println("1. Add Patient\t2. Add Doctor\t3. Add Department\t4. Assign Doctor to Department");
            System.out.println("5. Schedule Appointment\t6. Generate Bill\t7. Show Reports");
            System.out.println("8. Show All Doctors\t9. Show All Departments\t10. Save and Exit");
            System.out.print("Enter your choice: ");
            in = input.nextLine();

            switch (in) {
                case "1": addPatient(); break;
                case "2": addDoctor(); break;
                case "3": addDepartment(); break;
                case "4": assignDoctorToDepartment(); break;
                case "5": scheduleAppointment(); break;
                case "6": generateBill(); break;
                case "7": showReports(); break;
                case "8": showAllDoctors(); break;
                case "9": showAllDepartments(); break;
                case "10": exit(); input.close(); return;
                default: System.out.println("Invalid value entered.");
            }
        }
    }

    /**
     * Adds a new patient to the system by collecting patient details.
     */
    public static void addPatient() {
        System.out.print("Please enter the patient's name: ");
        String name = input.nextLine();
        System.out.print("Please enter the patient's email: ");
        String email = input.nextLine();
        System.out.print("Please enter the patient's phone number: ");
        String phone = input.nextLine();
        System.out.print("Please enter the patient's gender (MALE/FEMALE): ");
        String gender = getGender();
        System.out.print("Please enter the patient's age: ");
        int age = inputInt();
        input.nextLine();
        System.out.print("Please enter any medical history: ");
        String mh = input.nextLine();
        Contact c = new Contact(email, phone);
        for (Patient p : hs.getPatients()) {
			if (name.equals(p.getName()) && email.equals(p.getContact().getEmail())
					&& phone.equals(p.getContact().getPhoneNumber())
					&& gender.equalsIgnoreCase(p.getGender() == Gender.MALE ? "MALE" : "FEMALE")
					&& p.getMedicalHistory().equals(mh)) {
				System.out.println("This patient has already been registered.");
				return;
			}
		}
        Patient p = new Patient(hs.getNextPatientId(), name, c, gender.equalsIgnoreCase("MALE")?Gender.MALE:Gender.FEMALE, age, mh);
        hs.addPatient(p);
    }

    /**
     * Adds a new doctor to the system by collecting doctor's details.
     */
    public static void addDoctor() {
        System.out.print("Please enter the doctor's name: ");
        String name = input.nextLine();
        System.out.print("Please enter the doctor's email: ");
        String email = input.nextLine();
        System.out.print("Please enter the doctor's phone number: ");
        String phone = input.nextLine();
        System.out.print("Please enter the doctor's gender (MALE/FEMALE): ");
        String gender = getGender();
        System.out.print("Please enter the doctor's specialization: ");
        String specialization = input.nextLine();
        Contact c = new Contact(email, phone);
        for (Doctor d : hs.getDoctors()) {
			if (name.equals(d.getName()) && email.equals(d.getContact().getEmail())
					&& phone.equals(d.getContact().getPhoneNumber())
					&& gender.equalsIgnoreCase(d.getGender() == Gender.MALE ? "MALE" : "FEMALE")
					&& d.getSpecialization().equals(specialization)) {
				System.out.println("This doctor has already been registered.");
				return;
			}
		}
        Doctor d = new Doctor(hs.getNextDoctorId(), name, c, gender.equalsIgnoreCase("MALE")?Gender.MALE:Gender.FEMALE, specialization);
        hs.addDoctor(d);
    }

    /**
     * Adds a new department to the system by collecting department details.
     */
    public static void addDepartment() {
        System.out.print("Please enter department ID: ");
        int id = inputInt();
        input.nextLine();
        System.out.print("Please enter department name: ");
        String name = input.next();
        Department d = new Department(id, name);
        for (Department dep : hs.getDepartments()) {
            if (dep.equals(d)) {
                System.out.println("Department already exists");
                return;
            }
        }
        hs.getDepartments().add(d);
        System.out.println("Department added successfully");
        input.nextLine();
    }

    /**
     * Assigns a doctor to a department.
     */
    public static void assignDoctorToDepartment() {
        System.out.print("Please enter a doctor ID: ");
        int docId = inputInt();
        System.out.print("Please enter a department ID: ");
        int depId = inputInt();
        input.nextLine();
        Doctor tempDoc = hs.searchDoctorById(docId);
        if (tempDoc == null) {
            System.out.println("No such registered doctor. Please register the doctor.");
            return;
        }
        hs.assignDoctorToDepartment(depId, tempDoc);
    }

    /**
     * Schedules an appointment by collecting the necessary details.
     */
    public static void scheduleAppointment() {
        System.out.print("Please enter a doctor ID: ");
        int docId = inputInt();
        if (hs.searchDoctorById(docId) == null) {
            System.out.println("No doctor registered with such ID");
            input.nextLine();
            return;
        }
        System.out.print("Please enter a patient ID: ");
        int patId = inputInt();
        input.nextLine();
        if (hs.searchPatientById(patId) == null) {
            System.out.println("No patient registered with such ID");
            return;
        }
        System.out.print("Please enter the date of the appointment (dd-MM-yyyy): ");
        String dateStr = input.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date;
        try {
            date = LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use dd-MM-yyyy.");
            return;
        }

        for (Appointment a : hs.getAppointments()) {
            if (a.getPatientID() == patId &&
                a.getDoctorID() == docId &&
                a.getAppointmentDate().equals(date)) {
                System.out.println("Appointment not scheduled, doctor is busy on this date.");
                return;
            }
        }
        Appointment app = new Appointment(hs.getNextAppointmentId(), patId, docId, date);
        hs.getAppointments().add(app);
        System.out.println("Appointment successfully scheduled.");
    }

    /**
     * Generates a bill for a scheduled appointment.
     */
    public static void generateBill() {
        int appointmentId;
        while (true) {
            System.out.print("Please enter an Appointment ID: ");
            appointmentId = inputInt();
            for (Bill b : hs.getBills()) {
                if (b.getAppointmentId() == appointmentId) {
                    System.out.println("A bill for this appointment ID already exists.");
                    input.nextLine();
                    return;
                }
            }
            if (appointmentId == -999) {
                System.out.println("Exiting...");
                input.nextLine();
                return;
            }
            if (hs.searchAppointmentById(appointmentId) != null) {
                break;
            }
            System.out.println("Please enter a valid appointment ID or enter -999 to exit. ");
        }

        input.nextLine();
        System.out.print("Please enter bill date (DD/MM/YYYY): ");
        String date = input.nextLine();
        int billId = hs.getNextBillId();
        Bill b = new Bill(billId, appointmentId, date);
        String service;
        while (true) {
            System.out.println("===== Hospital Services Menu =====");
            System.out.println("1. Consultation - QAR 50");
            System.out.println("2. Diagnostic Imaging - QAR 100");
            System.out.println("3. Laboratory Test - QAR 40");
            System.out.println("4. Advanced Scan - QAR 500");
            System.out.println("5. Surgical Procedure - QAR 1000");
            System.out.println("6. Emergency Care - QAR 150");
            System.out.println("7. Wound Dressing - QAR 70");
            System.out.println("8. Rehabilitation Session - QAR 60");
            System.out.println("9. Immunization - QAR 25");
            System.out.println("10. Routine Screening - QAR 120");
            System.out.println("11. Exit");
            System.out.print("Select a service (1-11): ");
            service = input.nextLine();
            if (service.equals("11")) break;
            b.addService(service);
        }
        hs.generateBill(b);
    }

    /**
     * Displays reports based on user input.
     */
    public static void showReports() {
        int in;
        while (true) {
            System.out.println("====== Reports ======");
            System.out.println("1. Patients Report\t2. Doctors Report\t3. Appointments Report\t4. Billings Report");
            System.out.println("5. Departmental Report\t6. Exit");
            System.out.print("Enter your choice: ");
            while (true) {
                try {
                    in = input.nextInt();
                    if (in > 0 && in <= 6) break;
                    System.out.print("Please enter a number between 1 and 6: ");
                } catch (Exception e) {
                    System.out.print("Invalid Input. Please enter a number between 1 and 6: ");
                    input.nextLine();
                }
            }

            switch (in) {
                case 1: hs.generatePatientReport(); break;
                case 2: hs.generateDoctorReport(); break;
                case 3: hs.generateAppointmentReport(); break;
                case 4: hs.generateBillingReport(); break;
                case 5: hs.generateDepartmentReport(); break;
                case 6:
                    System.out.println("Exiting...");
                    input.nextLine();
                    return;
            }
        }
    }

    /**
     * Displays all doctors' details.
     */
    public static void showAllDoctors() {
        int doctorsCount = hs.getDoctors().size();
        hs.generateDoctorReport();
        if (doctorsCount == 0) {
            System.out.println("No Registered Doctors");
        } else {
            System.out.println("Number of registered Doctors is " + doctorsCount + ".");
        }
    }

    /**
     * Displays all departments' details.
     */
    public static void showAllDepartments() {
        int depCount = hs.getDepartments().size();
        hs.generateDepartmentReport();
        if (depCount == 0) {
            System.out.println("No Registered Departments");
        } else {
            System.out.println("Number of registered Departments is " + depCount + ".");
        }
    }

    /**
     * Loads data from files at the start of the application.
     */
    public static void loadDataFromFiles() {
        hs.loadDataFromFiles();
    }

    /**
     * Saves data to files and exits the application.
     */
    public static void exit() {
        hs.saveDataToFile();
        System.out.println("Data saved. Goodbye!");
    }

    /**
     * Helper method to safely input integers from the user.
     *
     * @return an integer input by the user.
     */
    public static int inputInt() {
        while (true) {
            try {
                return input.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter an integer: ");
                input.nextLine(); 
            }
        }
    }
    /**
     * Helper method to reduce code repetition that validates the input of gender
     * @return a String of the gender entered
     */
    public static String getGender() {
    	String gender = input.nextLine();
        while (!gender.equalsIgnoreCase("MALE") && !gender.equalsIgnoreCase("FEMALE")) {
            System.out.print("Please enter a valid gender: ");
            gender = input.nextLine();
        }
        return gender;
    }
}
