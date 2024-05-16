//------------------------------------------------------------------------------------------------------------------
// Assignment 1
// Written by: Hiba Talbi
//------------------------------------------------------------------------------------------------------------------

/*
 * The Client class stores a client's information(name, phone number, email address) in the library system.
 * Each client is assigned a unique id starting with "C" and followed by a number.
 * This class contains a constructor, to create client objects, accessors and mutators for each attribute,
 * a toString() method to generate a string representation of a client object and an equals() method
 * to compare two client objects for their equality.
 */

package com.library.clients;
public class Client {
    // Declaring attributes
    private String id;
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private static int clientNbr = 1;

    // Default constructor
    public Client() {
        this.name = "";
        this.phoneNumber = "";
        this.emailAddress = "";
        clientNbr++;
    }

    // Parametrized constructor
    public Client(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        id = "C" + clientNbr;
        clientNbr++;
    }

    // Copy constructor
    public Client(Client other) {
        this.id = other.id;
        this.name = other.name;
        this.phoneNumber = other.phoneNumber;
        this.emailAddress = other.emailAddress;
        clientNbr++;
    }

    // Accessor and mutator methods
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    // toString() method to generate a string representation of Client
    public String toString() {
        return "Client{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    // equals() method to compare Client objects for equality
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Client)) return false;
        Client client = (Client)obj;
        return id.equals(client.id)&&
                name.equals(client.name) &&
                phoneNumber.equals(client.phoneNumber)&&
                emailAddress.equals(client.emailAddress);
    }
}
