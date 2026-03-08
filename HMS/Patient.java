package HMS;

import java.io.Serializable;

/**
 * Patient class representing a patient in the hospital system.
 * This class extends the Person class and implements Serializable for file storage.
 * 
 * @author Omair Nawaz
 * @author Yacine Marabet
 * @author Mir Abbasi
 * @author Abdulrahman Al-Sulaiti
 */
public class Patient extends Person implements Serializable {

    private int age;
    private String medicalHistory;

    /**
     * Constructor to create a Patient object with the given details.
     *
     * @param id            The unique identifier for the patient.
     * @param name          The name of the patient.
     * @param contact       The contact information of the patient.
     * @param gender        The gender of the patient (MALE/FEMALE).
     * @param age           The age of the patient.
     * @param medicalHistory The medical history of the patient.
     */
    Patient(int id, String name, Contact contact, Gender gender, int age, String medicalHistory) {
        super(id, name, contact, gender);
        setAge(age);
        setMedicalHistory(medicalHistory);
    }

    /**
     * Gets the age of the patient.
     *
     * @return the patient's age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the patient.
     *
     * @param age the patient's age.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the medical history of the patient.
     *
     * @return the patient's medical history.
     */
    public String getMedicalHistory() {
        return medicalHistory;
    }

    /**
     * Sets the medical history of the patient.
     *
     * @param medicalHistory the patient's medical history.
     */
    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    /**
     * Updates the medical history of the patient with the given information.
     *
     * @param medicalHistoryInfo the new medical history information to update.
     */
    public void updateMedicalHistory(String medicalHistoryInfo) {
        setMedicalHistory(medicalHistoryInfo);
        System.out.println("Medical History updated.");
    }

    /**
     * Displays the details of the patient, including the basic details from the Person class,
     * age, and medical history.
     */
    public void displayDetails() {
        System.out.println(super.toString() + ", Age: " + age + ", Medical History: " + medicalHistory);
    }

    /**
     * Returns a string representation of the patient's details, including the basic details from
     * the Person class, age, and medical history.
     *
     * @return a string representing the patient's details.
     */
    public String toString() {
        return super.toString() + ", Age: " + age + ", Medical History: " + medicalHistory;
    }
}
