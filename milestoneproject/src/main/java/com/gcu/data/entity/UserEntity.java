package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Represents a user in the system and maps to the "users" table in the
 * database.
 * Contains login and registration information.
 */
@Table("users")
public class UserEntity {

    /** Unique identifier for the user. */
    @Id
    private Long id;

    /** Username for login (usually the email). */
    private String username;

    /** Password for login. */
    private String password;

    // Registration fields
    /** User's first name. */
    @Column("first_name")
    private String firstName;

    /** User's last name. */
    @Column("last_name")
    private String lastName;

    /** User's email address. */
    private String email;

    /** User's date of birth. */
    @Column("date_of_birth")
    private String dateOfBirth;

    /** Primary street address. */
    private String street1;

    /** Secondary street address. */
    private String street2;

    /** City of residence. */
    private String city;

    /** State of residence. */
    private String state;

    /** ZIP/postal code. */
    private String zip;

    /** Area code for the user's phone number. */
    @Column("area_code")
    private String areaCode;

    /** User's phone number. */
    @Column("phone_number")
    private String phoneNumber;

    /**
     * Default constructor.
     */
    public UserEntity() {

    }

    /**
     * Constructor with username and password for login purposes.
     *
     * @param username the user's username
     * @param password the user's password
     */
    public UserEntity(String username, String password) {

        this.username = username;
        this.password = password;
    }

    // Getters and Setters for Login
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getters and Setters for Register
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
