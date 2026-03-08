package HMS;

import java.io.Serializable;

/**
 * Abstract class representing a person in the hospital system.
 * This class stores common details like ID, name, contact information, and gender for any person.
 * 
 * @author Omair Nawaz
 * @author Yacine Marabet
 * @author Mir Abbasi
 * @author Abdulrahman Al-Sulaiti
 */
public abstract class Person implements Serializable {

    private int id;
    private String name; 
    private Contact contact;
    private Gender gender;

    /**
     * Constructs a new Person with the given details.
     * 
     * @param id       the unique identifier for the person.
     * @param name     the name of the person.
     * @param contact  the contact information of the person.
     * @param gender   the gender of the person.
     */
    public Person(int id, String name, Contact contact, Gender gender) {
        super();
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Updates the contact information for the person.
     * 
     * @param newContact the new contact information to set for the person.
     */
    public void updateContactInfo(Contact newContact) {
        setContact(newContact);
    }

    /**
     * Validates if the given ID is a positive value.
     * 
     * @param id the ID to validate.
     * @return true if the ID is positive, false otherwise.
     */
    public boolean validateId(int id) {
        return id > 0;
    }

    /**
     * Displays the details of the person (ID, name, contact, and gender).
     */
    public void displayDetails() {
        System.out.println("ID: " + id + " Name: " + name + " Contact: " + contact + " Gender: " + gender);
    }

    /**
     * Returns a string representation of the person's details.
     * 
     * @return a string containing the person's ID, name, contact, and gender.
     */
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Contact: " + contact + ", Gender: " + gender;
    }
}
