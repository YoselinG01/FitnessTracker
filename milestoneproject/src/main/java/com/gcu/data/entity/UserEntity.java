package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Entity class that maps to the "users" table in the database.
 * <p>
 * This class represents a registered user within the POWER Fitness Tracker system.
 * It stores user credentials for login as well as personal details collected during registration.
 */
@Table("users")
public class UserEntity {

    /**
     * Unique identifier for the user (primary key).
     * Automatically assigned by the database.
     */
    @Id
    private Long id;

    /**
     * Username used for authentication (typically the user's email).
     */
    private String username;

    /**
     * User's password used for secure authentication.
     */
    private String password;

    // Registration fields

    /**
     * User's first name.
     */
    @Column("first_name")
    private String firstName;

    /**
     * User's last name.
     */
    @Column("last_name")
    private String lastName;

    /**
     * Email address associated with the user's account.
     */
    private String email;

    /**
     * User's date of birth, stored as a string.
     */
    @Column("date_of_birth")
    private String dateOfBirth;

    /**
     * Primary street address (house number + street).
     */
    private String street1;

    /**
     * Secondary street address (apartment/unit/suite number).
     */
    private String street2;

    /**
     * City of residence.
     */
    private String city;

    /**
     * State or province of residence.
     */
    private String state;

    /**
     * ZIP or postal code.
     */
    private String zip;

    /**
     * Area code associated with the user's phone number.
     */
    @Column("area_code")
    private String areaCode;

    /**
     * Full phone number without formatting.
     */
    @Column("phone_number")
    private String phoneNumber;

    /**
     * Default constructor required for ORM and Spring Data mapping.
     */
    public UserEntity() {}

    /**
     * Constructor used during login authentication.
     *
     * @param username the user's login username (typically their email)
     * @param password the user's account password
     */
    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // ============================
    // Getters and setters
    // ============================

    /**
     * Gets the user's unique identifier.
     *
     * @return user ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the user's unique identifier.
     *
     * @param id user ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the username associated with the account.
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username associated with the account.
     *
     * @param username username used for login
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the user's password.
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password for the account.
     *
     * @param password user password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the user's first name.
     *
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the user's first name.
     *
     * @param firstName first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the user's last name.
     *
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the user's last name.
     *
     * @param lastName last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the user's email.
     *
     * @return email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email.
     *
     * @param email email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the user's date of birth.
     *
     * @return date of birth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the user's date of birth.
     *
     * @param dateOfBirth birth date
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets the user's primary street address.
     *
     * @return street address line 1
     */
    public String getStreet1() {
        return street1;
    }

    /**
     * Sets the user's primary street address.
     *
     * @param street1 street address line 1
     */
    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    /**
     * Gets the user's secondary street address.
     *
     * @return street address line 2
     */
    public String getStreet2() {
        return street2;
    }

    /**
     * Sets the user's secondary street address.
     *
     * @param street2 street address line 2
     */
    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    /**
     * Gets the user's city.
     *
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the user's city.
     *
     * @param city city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the user's state of residence.
     *
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the user's state of residence.
     *
     * @param state state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the user's ZIP or postal code.
     *
     * @return zip code
     */
    public String getZip() {
        return zip;
    }

    /**
     * Sets the user's ZIP or postal code.
     *
     * @param zip zip code
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Gets the user's phone area code.
     *
     * @return area code
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * Sets the user's phone area code.
     *
     * @param areaCode area code
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * Gets the user's phone number.
     *
     * @return phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the user's phone number.
     *
     * @param phoneNumber phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
