//------------------------------------------------------------------------------------------------------------------
// Assignment 1
// Written by: Hiba Talbi
//------------------------------------------------------------------------------------------------------------------

/*
 * The Book class extends the Item class and stores a book's information
 * (name, author, year of publication, and number of pages) in the library system.
 * Each book is assigned a unique ID starting with "B" and followed by a number.
 * This class contains constructors, to create book objects, accessors and mutators for attributes relevant to the Book
 * class (numberOfPages and idBook), a toString() method to generate a string representation of a book object,
 * and an equals() method to compare two book objects for equality.
 */

package com.library.items;

public class Book extends Item {
    // Declaring constructor
    private int numberOfPages;
    private static int idBook = 1;

    // Default constructor
    public Book() {
        super();
        id = "B" + idBook;
        this.numberOfPages = 0;
        idBook++;
    }

    // Parametrized constructor
    public Book(String name, String author, int yearOfPublication, int numberOfPages) {
        super(name, author, yearOfPublication);
        id = "B" + idBook;
        this.numberOfPages = numberOfPages;
        idBook++;
    }

    // Copy constructor
    public Book (Book other) {
        super(other);
        id = "B" + idBook;
        this.numberOfPages = other.numberOfPages;
        idBook++;
    }

    // Accessor and mutator methods for numberOfPages
    public int getNumberOfPages() {
        return numberOfPages;
    }
    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    // toString method to generate a string representation of Book
    public String toString() {
        return "Book{" +
                "id= '" + getId() + '\'' +
                ", name= '" + getName() + '\'' +
                ", author= '" + getAuthor() + '\'' +
                ", yearOfPublication= " + getYearOfPublication() +
                ", numberOfPages= '" + numberOfPages + '\'' +
                '}';
    }

    // equals() method to compare Book objects for equality
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (!(obj instanceof Book)) return false;
        Book book = (Book)obj;
        return super.equals(obj) && numberOfPages == book.numberOfPages;
    }
}
