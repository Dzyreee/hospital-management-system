package HMS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * HospitalSystem class represents the entire hospital management system.
 * It contains methods for managing patients, doctors, appointments, bills, and departments.
 * The system also supports data persistence via file operations.
 * 
 * @author Omair Nawaz
 * @author Yacine Marabet
 * @author Mir Abbasi
 * @author Abdulrahman Al-Sulaiti
 */
public class HospitalSystem implements Payable, Serializable {
    public int nextPatientId = 1000;
    public int nextDoctorId = 2000;
    public int nextAppointmentId = 3000;
    public int nextBillId = 4000;
    private ArrayList<Patient> patients;
    private ArrayList<Doctor> doctors;
    private ArrayList<Appointment> appointments;
    private ArrayList<Bill> bills;
    private ArrayList<Department> departments;

    /**
     * Constructor for the HospitalSystem class.
     * Initializes the lists for patients, doctors, appointments, bills, and departments.
     */
    HospitalSystem() {
        patients = new ArrayList<Patient>();
        doctors = new ArrayList<Doctor>();
        appointments = new ArrayList<Appointment>();
        bills = new ArrayList<Bill>();
        departments = new ArrayList<Department>();
    }

    public int getNextPatientId() {
    	nextPatientId++;
        return nextPatientId;
    }

    public void setNextPatientId(int nextPatientId) {
        this.nextPatientId = nextPatientId;
    }

    public int getNextDoctorId() {
    	nextDoctorId++;
        return nextDoctorId;
    }

    public void setNextDoctorId(int nextDoctorId) {
        this.nextDoctorId = nextDoctorId;
    }

    public int getNextAppointmentId() {
    	nextAppointmentId++;
        return nextAppointmentId;
    }

    public void setNextAppointmentId(int nextAppointmentId) {
        this.nextAppointmentId = nextAppointmentId;
    }

    public int getNextBillId() {
    	nextBillId++;
        return nextBillId;
    }

    public void setNextBillId(int nextBillId) {
    	
        this.nextBillId = nextBillId;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    public ArrayList<Bill> getBills() {
        return bills;
    }

    public void setBills(ArrayList<Bill> bills) {
        this.bills = bills;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }

    /**
     * Adds a patient to the system.
     * @param patient The patient to be added.
     */
    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient successfully registered.");
    }

    /**
     * Deletes a patient from the system by patient ID.
     * @param patientId The ID of the patient to be deleted.
     */
    public void deletePatient(int patientId) {
        for (Patient p: patients) {
            if (p.getId() == patientId) {
                patients.remove(p);
                System.out.println("Patient successfully de-registered.");
                return;
            }
        }
        System.out.println("No such patient has been registered.");
    }

    /**
     * Searches for a patient by ID.
     * @param patientId The ID of the patient to search for.
     * @return The patient object if found, or null if not found.
     */
    public Patient searchPatientById(int patientId) {
        for (Patient p: patients) {
            if (p.getId() == patientId) {
                return p;
            }
        }
        return null;
    }

    /**
     * Adds a doctor to the system.
     * @param doctor The doctor to be added.
     */
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("Doctor successfully registered.");
    }

    /**
     * Deletes a doctor from the system by doctor ID.
     * @param doctorId The ID of the doctor to be deleted.
     */
    public void deleteDoctor(int doctorId) {
        for (Doctor d: doctors) {
            if (d.getId() == doctorId) {
                doctors.remove(d);
                System.out.println("Doctor successfully de-registered.");
                return;
            }
        }
        System.out.println("No such doctor has been registered.");
    }

    /**
     * Searches for a doctor by ID.
     * @param doctorId The ID of the doctor to search for.
     * @return The doctor object if found, or null if not found.
     */
    public Doctor searchDoctorById(int doctorId) {
        for (Doctor d: doctors) {
            if (d.getId() == doctorId) {
                return d;
            }
        }
        return null;
    }

    /**
     * Schedules an appointment if it is available.
     * @param appointment The appointment to be scheduled.
     * @return true if the appointment was scheduled successfully, false otherwise.
     */
    public boolean scheduleAppointment(Appointment appointment) {
        for (Appointment a: appointments) {
            if (a.equals(appointment)) {
                System.out.println("Appointment unavailable.");
                return false;
            }
        }
        appointments.add(appointment);
        return true;
    }

    /**
     * Cancels an appointment by appointment ID.
     * @param appointmentId The ID of the appointment to be cancelled.
     * @return true if the appointment was cancelled, false if not found.
     */
    public boolean cancelAppointmentById(int appointmentId) {
        Appointment tempApp = searchAppointmentById(appointmentId);
        if (tempApp == null)
            return false;
        appointments.remove(tempApp);
        return true;
    }

    /**
     * Searches for an appointment by appointment ID.
     * @param appointmentId The ID of the appointment to search for.
     * @return The appointment object if found, or null if not found.
     */
    public Appointment searchAppointmentById(int appointmentId) {
        for (Appointment a: appointments) {
            if (a.getAppointmentID() == appointmentId) {
                return a;
            }
        }
        return null;
    }

    /**
     * Generates a bill and adds it to the system.
     * @param bill The bill to be generated and added.
     */
    public void generateBill(Bill bill) {
        bills.add(bill);
        bill.generateInvoice();
    }

    /**
     * Searches for a bill by bill ID.
     * @param billId The ID of the bill to search for.
     * @return The bill object if found, or null if not found.
     */
    public Bill searchBillById(int billId) {
        for (Bill b: bills) {
            if (b.getBillId() == billId) {
                return b;
            }
        }
        return null;
    }

    /**
     * Adds a department to the hospital system.
     * @param department The department to be added.
     */
    public void addDepartment(Department department) {
        departments.add(department);
    }

    /**
     * Assigns a doctor to a specific department by department ID.
     * @param departmentId The ID of the department.
     * @param doctor The doctor to be assigned to the department.
     */
    public void assignDoctorToDepartment(int departmentId, Doctor doctor) {
        for (Department dep: departments) {
            if (dep.getDoctors().contains(doctor)) {
                dep.getDoctors().remove(doctor);
            }
            if (dep.getDepartmentId() == departmentId) {
                dep.getDoctors().add(doctor);
                System.out.println("Doctor assigned to department successfully.");
                return;
            }
        }
        System.out.println("No registered department with this ID.");
    }

    /**
     * Generates a report of all patients in the system.
     */
    public void generatePatientReport() {
        System.out.println("====== Patient Report ====== ");
        if (patients.isEmpty()) {
            System.out.println("No patients registered thus far.");
            return;
        }
        for (Patient p: patients) {
            System.out.println("\t" + p);
            System.out.println();
        }
    }

    /**
     * Generates a report of all doctors in the system.
     */
    public void generateDoctorReport() {
        System.out.println("====== Doctor Report ====== ");
        if (doctors.isEmpty()) {
            System.out.println("No doctors registered thus far.");
            return;
        }
        for (Doctor d : doctors) {
            System.out.print("\t" + d);
            for (Department dep : departments) {
                if (dep.getDoctors().contains(d)) {
                    System.out.print(", Department Name: " + dep.getDepartmentName());
                }
            }
            System.out.println();
            System.out.println();
        }
    }

    /**
     * Generates a report of all appointments in the system.
     */
    public void generateAppointmentReport() {
        System.out.println("====== Appointment Report ====== ");
        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled thus far.");
        }
        for (Appointment a: appointments) {
            System.out.println("\t" + a);
            System.out.println();
        }
    }

    /**
     * Generates a report of all billing information in the system.
     */
    public void generateBillingReport() {
        double total = 0;
        System.out.println("====== Billing Report ====== ");
        if (bills.isEmpty()) {
            System.out.println("No Bills thus far.");
            return;
        }
        for (Bill b: bills) {
            b.generateInvoice();
            total += b.getAmount();
            Doctor d = searchDoctorById(searchAppointmentById(b.getAppointmentId()).getDoctorID());
            System.out.printf(d.getName() + ", Earnings : QAR %.2f", calculatePayment(b.getBillId()));
            System.out.println("\n" + "-".repeat(30));
        }
        System.out.printf("Total Revenue : QAR %.2f\n", total);
    }

    /**
     * Generates a report of all departments in the system.
     */
    public void generateDepartmentReport() {
        System.out.println("====== Department Report ====== ");
        if (departments.isEmpty()) {
            System.out.println("No departments registered thus far.");
        }
        for (Department d: departments) {
            d.displayDepartmentDetails();
        }
    }

    /**
     * Loads data from files to restore the hospital system's state.
     */
    public void loadDataFromFiles() {
        ObjectInputStream ois = null;
        File file = new File("HospitalManagementSystemData.bin");
        if (!file.exists()) {
            System.out.println("No data has been entered and saved thus far.");
            return;
        }
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            nextPatientId = ois.readInt();
            nextDoctorId = ois.readInt();
            nextAppointmentId = ois.readInt();
            nextBillId = ois.readInt();
            patients = (ArrayList<Patient>) ois.readObject();
            doctors = (ArrayList<Doctor>) ois.readObject();
            appointments = (ArrayList<Appointment>) ois.readObject();
            bills = (ArrayList<Bill>) ois.readObject();
            departments = (ArrayList<Department>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: An issue occurred while reading the file.");
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Saves the hospital system's state to files.
     */
    public void saveDataToFile() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("HospitalManagementSystemData.bin"));
            oos.writeInt(nextPatientId);
            oos.writeInt(nextDoctorId);
            oos.writeInt(nextAppointmentId);
            oos.writeInt(nextBillId);
            oos.writeObject(patients);
            oos.writeObject(doctors);
            oos.writeObject(appointments);
            oos.writeObject(bills);
            oos.writeObject(departments);
        } catch (IOException e) {
            System.out.println("Error occurred while writing to file.");
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Calculates the total payment for a specific doctor based on the bills.
     * @param billId The bill ID to calculate the payment for.
     * @return The calculated payment amount.
     */
    public double calculatePayment(int billId) {
        double totalAmount = 0;
        for (Bill b : bills) {
            if (b.getBillId() == billId) {
                totalAmount += b.getAmount();
            }
        }
        return totalAmount * 0.15;
    }
}
