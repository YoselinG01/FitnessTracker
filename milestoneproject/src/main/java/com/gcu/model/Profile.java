package com.gcu.model;

/**
 * Profile is a model class representing a user's fitness and personal details.
 *
 * <p>This class is used to store and transfer profile-related information 
 * such as name, contact details, goals, and physical attributes. It can be 
 * bound to form inputs in the view layer and processed in the business layer.</p>
 */
public class Profile {
    /** The user's first name. */
    private String firstName;

    /** The user's last name. */
    private String lastName;

    /** The user's phone number. */
    private String phoneNumber;

    /** The user's email address. */
    private String email;

    /** The user's fitness or personal goal. */
    private String goal;

    /** The user's weight in kilograms or pounds (depending on the system used). */
    private double weight;

    /** The user's gender. */
    private String gender;

    /** The user's height in centimeters or inches (depending on the system used). */
    private double height;

    /**
     * Default constructor.
     * <p>Creates an empty Profile object with no initial values.</p>
     */
    public Profile() {}

    /**
     * Full constructor to initialize a Profile with all details.
     *
     * @param firstName   the user's first name
     * @param lastName    the user's last name
     * @param phoneNumber the user's phone number
     * @param email       the user's email address
     * @param goal        the user's fitness or personal goal
     * @param weight      the user's weight
     * @param gender      the user's gender
     * @param height      the user's height
     */
    public Profile(String firstName, String lastName, String phoneNumber, String email,
                   String goal, double weight, String gender, double height) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.goal = goal;
        this.weight = weight;
        this.gender = gender;
        this.height = height;
    }

    /** @return the user's first name */
    public String getFirstName() { return firstName; }

    /** @param firstName the user's first name */
    public void setFirstName(String firstName) { this.firstName = firstName; }

    /** @return the user's last name */
    public String getLastName() { return lastName; }

    /** @param lastName the user's last name */
    public void setLastName(String lastName) { this.lastName = lastName; }

    /** @return the user's phone number */
    public String getPhoneNumber() { return phoneNumber; }

    /** @param phoneNumber the user's phone number */
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    /** @return the user's email address */
    public String getEmail() { return email; }

    /** @param email the user's email address */
    public void setEmail(String email) { this.email = email; }

    /** @return the user's fitness or personal goal */
    public String getGoal() { return goal; }

    /** @param goal the user's fitness or personal goal */
    public void setGoal(String goal) { this.goal = goal; }

    /** @return the user's weight */
    public double getWeight() { return weight; }

    /** @param weight the user's weight */
    public void setWeight(double weight) { this.weight = weight; }

    /** @return the user's gender */
    public String getGender() { return gender; }

    /** @param gender the user's gender */
    public void setGender(String gender) { this.gender = gender; }

    /** @return the user's height */
    public double getHeight() { return height; }

    /** @param height the user's height */
    public void setHeight(double height) { this.height = height; }
}
