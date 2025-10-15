package com.gcu.model;

/**
 * RegistrationForm is a model class that represents
 * the data submitted by a user during registration.
 *
 * It contains personal details such as name, email,
 * date of birth, address, and phone number.
 * This object is populated automatically when a user
 * submits the registration form in the Thymeleaf view.
 */
public class RegistrationForm {
    // Basic Info
    /** The user's first name. */
    private String firstName;

    /** The user's last name. */
    private String lastName;

    /** The user's email address. */
    private String email;

    /** The user's date of birth. */
    private String dateOfBirth;

    // Address
    /** The first line of the street address. */
    private String street1;

    /** The second line of the street address (optional). */
    private String street2;

    /** The city where the user resides. */
    private String city;

    /** The state or province where the user resides. */
    private String state;

    /** The postal or zip code. */
    private String zip;

    // Phone
    /** The area code of the phone number. */
    private String areaCode;

    /** The main part of the phone number. */
    private String phoneNumber;

    // Getters and Setters

    /**
     * Gets the user's first name.
     * 
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the user's first name.
     * 
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the user's last name.
     * 
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the user's last name.
     * 
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the user's email.
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email.
     * 
     * @param email the email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the user's date of birth.
     * 
     * @return dateOfBirth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the user's date of birth.
     * 
     * @param dateOfBirth the date of birth
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets the street address line 1.
     * 
     * @return street1
     */
    public String getStreet1() {
        return street1;
    }

    /**
     * Sets the street address line 1.
     * 
     * @param street1 the street address
     */
    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    /**
     * Gets the street address line 2.
     * 
     * @return street2
     */
    public String getStreet2() {
        return street2;
    }

    /**
     * Sets the street address line 2.
     * 
     * @param street2 the street address line 2
     */
    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    /**
     * Gets the city.
     * 
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city.
     * 
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the state.
     * 
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state.
     * 
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the postal/zip code.
     * 
     * @return zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * Sets the postal/zip code.
     * 
     * @param zip the postal code
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Gets the phone area code.
     * 
     * @return areaCode
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * Sets the phone area code.
     * 
     * @param areaCode the area code
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * Gets the phone number.
     * 
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number.
     * 
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
