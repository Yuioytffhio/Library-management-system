//------------------------------------------------------------------------------------------------------------------
// Assignment 1
// Written by: Hiba Talbi
//------------------------------------------------------------------------------------------------------------------

/*
 * The Media class extends the Item class and stores a media's information
 * (name, author, year of publication, and type) in the library system.
 * Each media is assigned a unique ID starting with "M" and followed by a number.
 * This class contains constructors, to create book objects, accessors and mutators for attributes relevant to the Media
 * class (type and mediaNbr), a toString() method to generate a string representation of a media object,
 * and an equals() method to compare two media objects for equality.
 */


package com.library.items;

public class Media extends Item {
    // Declaring attributes
    private String type; // audio, video, interactive
    private static int mediaNbr = 1;

    // Default constructor
    public Media() {
        super();
        this.type = "";
        mediaNbr++;
    }

    // Parametrized constructor
    public Media(String name, String author, int yearOfPublication, String type) {
        super(name, author, yearOfPublication);
        id = "M" + mediaNbr;
        mediaNbr++;
        this.type = type;
    }

    // Copy constructor
    public Media(Media other) {
        super(other);
        this.type = other.type;
        mediaNbr++;
    }

    // Accessor and mutator methods for type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // toString method to generate a string representation of Media
    public String toString() {
        return "Media{" +
                "id= '" + getId() + '\'' +
                ", name= '" + getName() + '\'' +
                ", author= '" + getAuthor() + '\'' +
                ", yearOfPublication= " + getYearOfPublication() +
                ", type= '" + type + '\'' +
                '}';
    }

    // equals() method to compare Media objects for equality
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Media)) return false;
        Media media = (Media)obj;
        return super.equals(obj)&& type == media.type;
    }

}

