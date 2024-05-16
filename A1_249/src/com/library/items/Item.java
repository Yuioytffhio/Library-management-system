//------------------------------------------------------------------------------------------------------------------
// Assignment 1
// Written by: Hiba Talbi
//------------------------------------------------------------------------------------------------------------------

/*
 * The Item class stores information for items book, journal or media items in the library system.
 * It contains common information shared by all items(name, author, year of publication, lease status and the client to
 * whom it is leased (if leased)).
 * This class provides constructors for creating item objects, accessor and mutator methods, used to retrieve or modify
 * a value, a toString() method to generate a string representation of an item object, and an equals() method to compare
 * two item objects for equality.
 */

package com.library.items;

import com.library.clients.Client;

public class Item {
    // Declaring attributes
    protected String id;
    protected String name;
    protected String author;
    protected int yearOfPublication;
    protected boolean leased = false;
    protected Client clientLeasedTo;

    // Default constructor
    public Item() {
        this.name = "";
        this.author = "";
        this.yearOfPublication = 0;
    }

    // Parametrized constructor
    public Item(String name, String author, int yearOfPublication) {
        this.name = name;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    // Copy constructor
    public Item (Item other) {
        this.name = other.name;
        this.author = other.author;
        this.yearOfPublication = other.yearOfPublication;
    }

    // Accessors
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }
    public String getId() {return id;}

    // Mutators
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public boolean getLeased() {
        return leased;
    }

    public void setLeased(boolean leased) {
        this.leased = leased;
    }

    public Client getLeasedTo() {
        return clientLeasedTo;
    }

    public void setClientLeasedTo(Client client) {
        this.clientLeasedTo = client;
    }

    // toString() Method
    public String toString() {
        return "Item{" +
                ", name= '" + name + '\'' +
                ", author= '" + author + '\'' +
                ", yearOfPublication= " + yearOfPublication +
                '}';
    }

    // equals() Method
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        // Type cast the Object into an Item
        Item item = (Item) obj;
        // Compare attributes of objects and return result
        return yearOfPublication == item.yearOfPublication &&
                name.equals(item.name) &&
                author.equals(item.author);
    }

}
