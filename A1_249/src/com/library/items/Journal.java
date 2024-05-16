//------------------------------------------------------------------------------------------------------------------
// Assignment 1
// Written by: Hiba Talbi
//------------------------------------------------------------------------------------------------------------------

/*
 * The Journal class extends the Item class and stores a journal's information
 * (name, author, year of publication, and volume number) in the library system.
 * Each journal is assigned a unique ID starting with "J" and followed by a number.
 * This class contains constructors, to create book objects, accessors and mutators for attributes relevant to the Journal
 * class (volumeNbr and journalNbr), a toString() method to generate a string representation of a journal object,
 * and an equals() method to compare two journal objects for equality.
 */


package com.library.items;

public class Journal extends Item {
    // Declaring attributes
    private int volumeNumber;
    private static int journalNbr = 1;

    // Default constructor
    public Journal() {
        super();
        this.volumeNumber = 0;
        journalNbr++;
    }

    // Parametrized constructor
    public Journal(String name, String author, int yearOfPublication, int volumeNumber) {
        super(name, author, yearOfPublication);
        id = "J" + journalNbr;
        journalNbr++;
        this.volumeNumber = volumeNumber;
    }

    // Copy constructor
    public Journal (Journal other) {
        super(other);
        this.volumeNumber = other.volumeNumber;
        journalNbr++;
    }

    // Accessor and mutator methods for volumeNumber
    public int getVolumeNumber() {
        return volumeNumber;
    }

    public void setVolumeNumber(int volumeNumber) {
        this.volumeNumber = volumeNumber;
    }

    // toString method to generate a string representation of the Journal
    public String toString() {
        return "Journal{" +
                "id= '" + getId() + '\'' +
                ", name= '" + getName() + '\'' +
                ", author= '" + getAuthor() + '\'' +
                ", yearOfPublication= " + getYearOfPublication() +
                ". volumeNumber= " + volumeNumber +
                '}';
    }

    // equals() method to compare Journal objects for equality
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Journal)) return false;
        Journal journal = (Journal)obj;
        return super.equals(obj)&& volumeNumber == journal.volumeNumber;
    }
}
