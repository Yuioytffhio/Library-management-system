//------------------------------------------------------------------------------------------------------------------
// Assignment 1
// Written by: Hiba Talbi
//------------------------------------------------------------------------------------------------------------------

/*
 * This program serves as a library management system, allowing users to add or edit items(books, journals and media),
 * add or edit clients and lease or return items. This class contains a driver which runs a pre-defined scenario
 * and contains methods to display the biggest book and copy the books in the library.
 */

package com.library.libraryDriver;

import com.library.clients.Client;
import com.library.items.Book;
import com.library.items.Item;
import com.library.items.Journal;
import com.library.items.Media;

import java.util.Scanner;

public class LibraryDriver {
    //Declaring Scanner
    private static Scanner scanner = new Scanner(System.in);

    // Main method
    public static void main(String[] args) {
        //Creating arrays for every type
        Item[] items = new Item[0];
        Client[] clients = new Client[0];
        Book[] books = new Book[0];
        Journal[] journals = new Journal[0];
        Media[] media = new Media[0];

        // Boolean for the loop
        boolean restart = true;

        // Main loop for the program
        while(restart) {
            // Prompt user for choice
            System.out.print("""
                    Library Management System
                    1. Run predefined scenario
                    2. Display menu
                    3. Exit
                    Enter your choice:\s""");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    runPredefinedScenario();
                }
                case 2 -> {
                    // Display menu
                    System.out.print("""
                            \nMenu
                            1. Add or edit an item
                            2. Add or edit client information
                            3. Lease and return an item from a client
                            4. Show all items leased by a client
                            5. Show all leased items
                            6. Display biggest book
                            7. Copy books array
                            Enter your choice:\s""");
                    int userChoice = scanner.nextInt();

                    switch (userChoice) {
                        case 1 -> {
                            Object[] updatedArrays = changeItemInformation(items, books, journals, media);
                            // update arrays
                            items = (Item[]) updatedArrays[0];
                            books = (Book[]) updatedArrays[1];
                            journals = (Journal[]) updatedArrays[2];
                            media = (Media[]) updatedArrays[3];
                        }
                        case 2 -> {clients = editClientInfo(clients);}
                        case 3 -> {leaseItems(items, clients);}
                        case 4 -> {ShowItemsLeasedByAClient(items, clients);}
                        case 5 -> {ShowAllLeasedItems(items);}
                        case 6 -> {
                            if (books.length == 0) {
                                System.out.println("No books to display.\n");
                            }
                            else {
                                System.out.println(getBiggestBook(books)+ "\n");
                            }
                        }
                        case 7 -> {
                            if (books.length == 0) {
                                System.out.println("No books to copy.\n");
                            }
                            else {
                                books = copyBooks(books);
                            }
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Exiting program.");
                    restart = false;
                }

                default -> {
                    System.out.println("Invalid choice. Exiting program.");
                    restart = false;
                }
            }

        }

        // Close scanner
        scanner.close();
    }// End of main

    // Method to change item information
    public static Object[] changeItemInformation(Item[] items, Book[] books, Journal[] journals, Media[] media) {
        // Prompt user for choice
        System.out.print("""
                \nWhat would you like to do?
                1. Add an item
                2. Edit an item's information
                3. Delete an item
                4. List all item's from a category
                5. Print all items
                Enter your choice:\s""");

        int choice = scanner.nextInt();

        switch(choice) {
            // Adding an item
            case 1 -> {
                System.out.print("""
                        \nSelect the type of item you wish to add:
                        1. Book
                        2. Journal
                        3. Media
                        Enter your choice:\s""");
                int itemType = scanner.nextInt();

                // Prompt user for information
                System.out.print("Enter name: ");
                String name = scanner.next();
                System.out.print("Enter author: ");
                String author = scanner.next();
                System.out.print("Enter year of publication: ");
                int yearOfPublication = scanner.nextInt();

                switch(itemType) {
                    // Adding a Book item
                    case 1 -> {
                        System.out.print("Enter number of pages: ");
                        int numberOfPages = scanner.nextInt();
                        // Create new Book object
                        Book newBook = new Book(name, author, yearOfPublication, numberOfPages);

                        // Adding the book object in the item array
                        //Create copy of items array
                        Item[] tempArray1 = new Item[items.length + 1];
                        System.arraycopy(items, 0, tempArray1, 0, items.length);
                        tempArray1[items.length] = newBook;
                        // Replace old items array by the copy
                        items = tempArray1;

                        // Adding the book item object in the books array
                        // Create copy of books array
                        Book[] tempArray2 = new Book[books.length + 1];
                        System.arraycopy(books, 0, tempArray2, 0, books.length);
                        tempArray2[books.length] = newBook;
                        // Replace old books array by the copy
                        books = tempArray2;

                        System.out.println("Book added successfully.\n");
                    }
                    // Adding a Journal item
                    case 2 -> {
                        System.out.print("Enter volume number: ");
                        int volumeNumber = scanner.nextInt();

                        // Create new Journal object
                        Journal newJournal = new Journal( name, author, yearOfPublication, volumeNumber);
                        // Create copy of items array
                        Item[] tempArray1 = new Item[items.length + 1];
                        System.arraycopy(items, 0, tempArray1, 0, items.length);
                        tempArray1[items.length] = newJournal;
                        // Replace old items array by the copy
                        items = tempArray1;

                        // Adding the journal item object in the books array
                        // Create copy of journals array
                        Journal[] tempArray2 = new Journal[journals.length + 1];
                        System.arraycopy(journals, 0, tempArray2, 0, journals.length);
                        tempArray2[journals.length] = newJournal;
                        // Replace old journals array by the copy
                        journals = tempArray2;

                        System.out.println("Journal added successfully.\n");
                    }
                    // Adding a Media item
                    case 3 -> {
                        System.out.print("Enter type: ");
                        String type = scanner.next();

                        // Create new Media object
                        Media newMedia = new Media( name, author, yearOfPublication, type);
                        // Create copy of items array
                        Item[] tempArray1 = new Item[items.length + 1];
                        System.arraycopy(items, 0, tempArray1, 0, items.length);
                        tempArray1[items.length] = newMedia;
                        // Replace old items array by the copy
                        items = tempArray1;

                        // Adding the media item object in the books array
                        // Create copy of media array
                        Media[] tempArray2 = new Media[media.length + 1];
                        System.arraycopy(journals, 0, tempArray2, 0, media.length);
                        tempArray2[media.length] = newMedia;
                        // Replace old journals array by the copy
                        media = tempArray2;

                        System.out.println("Media added successfully.\n");

                    }
                }
            }

            // Editing an item's information
            case 2 -> {
                if (items.length == 0) {
                    System.out.println("No items found.");
                    return items;
                }
                else {
                    // Prompt user for information
                    System.out.print("Enter the id of the item you wish to update: ");
                    String id = scanner.next();

                    int itemNumber = 0;
                    for (int i = 0; i < items.length; i++) {
                        if (id.equalsIgnoreCase(items[i].getId())){
                            itemNumber = i;
                        }
                        else {
                            System.out.println("Invalid item id.");
                            return items;
                        }
                    }

                    // Display item information
                    System.out.println(items[itemNumber].toString());

                    // Prompt user for information
                    System.out.print("""
                        What information would you like to change?
                        1. Author
                        2. Name
                        3. Year of Publication
                        4. Quit
                        Enter your choice:\s""");
                    int itemOption = scanner.nextInt();

                    // Update book information based on user choice
                    switch (itemOption) {
                        case 1 -> {
                            System.out.print("Enter new author: ");
                            items[itemNumber].setAuthor(scanner.next());
                        }
                        case 2 -> {
                            System.out.print("Enter new name: ");
                            items[itemNumber].setName(scanner.next());
                        }
                        case 3 -> {
                            System.out.print("Enter new year of publication: ");
                            items[itemNumber].setYearOfPublication(scanner.nextInt());
                        }
                        case 4 -> {
                            System.out.println("Quitting...\n");
                        }
                        default -> {
                            System.out.println("Invalid option.\n");
                        }
                    }
                }
            }
            // Deleting an item
            case 3 -> {
                if (items.length == 0) {
                    System.out.println("No items found.");
                    return items;
                }
                else {
                    // Prompt user for information
                    System.out.print("Enter the id of the item you wish to delete: ");
                    String id = scanner.next();

                    int indexToDelete = 0;
                    for (int i = 0; i < items.length; i++) {
                        if (id.equalsIgnoreCase(items[i].getId())){
                            indexToDelete = i;
                        }
                        else {
                            System.out.println("Invalid item id.");
                        }
                    }

                    // Creating a temporary array
                    Item[] tempArray = new Item[items.length - 1];

                    // Adding all items from items array into tempArray except for the one to delete
                    for (int m = 0, n = 0; m < items.length; m++) {
                        if (m != indexToDelete) {
                            tempArray[n++] = items[m];
                        }
                    }
                    // Replace old array
                    items = tempArray;
                    System.out.println("Item deleted successfully!\n");
                }


            }
            // Listing all item's from a category
            case 4 -> {
                // Prompt user for information
                System.out.print("""
                        \nSelect the category of items you wish to display:
                        1. Book
                        2. Journal
                        3. Media
                        Enter your choice:\s""");
                int userChoice = scanner.nextInt();

                String type = "";
                switch(userChoice) {
                    case 1 -> {type = "Book";}
                    case 2 -> {type = "Journal";}
                    case 3 -> {type = "Media";}
                    case 4 -> {
                        System.out.println("Invalid choice.\n");
                        return items;
                    }
                }
                if (items.length == 0) {
                    System.out.println("No items found.\n");
                }
                else {
                    // Compare equality with String type and display items
                    for (int k = 0; k < items.length; k++) {
                        if (items[k].getClass().getSimpleName().equalsIgnoreCase(type)) {
                            System.out.println(items[k].toString());
                        }
                        else {
                            System.out.println("No items found.");
                        }
                    }
                    System.out.print("\n");
                }
            }
            // Printing all items
            case 5 -> {
                if (items.length == 0) {
                    System.out.println("No items found.");
                }
                else {
                    // Loop through the array and display items
                    for (int k = 0; k < items.length; k++) {
                        System.out.println(items[k].toString());
                    }
                }
                System.out.print("\n");
            }
            default -> {System.out.println("Invalid Choice.");}
        }

        return new Object[]{items, books, journals, media};
    }// end of changeItemInformation

    public static Client[] editClientInfo(Client[] clients) {
        // Prompt user for choice
        System.out.print("""
                \nWhat would you like to do?
                1. Add a client
                2. Edit a client
                3. Delete a client
                Enter your choice:\s""");

        int i = scanner.nextInt();
        switch(i) {
            // Adding a client
            case 1 -> {
                // Prompt user for information
                System.out.print("Enter name: ");
                String newName = scanner.next();
                System.out.print("Enter phone number: ");
                String newPhoneNumber = scanner.next();
                System.out.print("Enter email: ");
                String newEmail = scanner.next();

                // Creating new Client object
                Client newclient = new Client(newName, newPhoneNumber, newEmail);

                // Creating a tempArray and copying clients array into it
                Client[] tempArray = new Client[clients.length + 1];
                System.arraycopy(clients, 0, tempArray, 0, clients.length);
                tempArray[clients.length] = newclient;
                // Replace old array
                clients = tempArray;
                System.out.println("Client added successfully.\n");
            }

            // Edit a client's information
            case 2 -> {
                // Display clients
                if (clients.length == 0 ) {
                    System.out.println("No clients available to edit.\n");
                    return clients;
                }
                else {
                    for (int k = 0; k < clients.length; k++) {
                        System.out.println(clients[k].toString());
                    }

                    // Prompt user for information
                    System.out.print("Enter the id of the client whose information you'd like to edit: ");
                    String id = scanner.next();

                    int clientIndex = 0;
                    for (int n = 0; n < clients.length; n++) {
                        if (id.equalsIgnoreCase(clients[n].getId())){
                            clientIndex = n;
                        }
                        else {
                            System.out.println("Invalid client id.\n");
                            return clients;
                        }
                    }

                    // Display client to edit
                    System.out.println(clients[clientIndex].toString());
                    // Prompt user for input
                    System.out.print("""
                        \nWhich information would you like to edit?
                        1. Name
                        2. Phone Number
                        3. Email Address
                        Enter your choice:\s""");
                    int k = scanner.nextInt();

                    //Prompt user for information
                    switch(k) {
                        case 1 -> {
                            System.out.print("Enter new name: ");
                            String newname = scanner.next();
                            clients[clientIndex].setName(newname);
                        }
                        case 2 -> {
                            System.out.print("Enter new phone number: ");
                            String newnumber = scanner.next();
                            clients[clientIndex].setPhoneNumber(newnumber);
                        }
                        case 3 -> {
                            System.out.print("Enter new email address: ");
                            String newaddress = scanner.next();
                            clients[clientIndex].setEmailAddress(newaddress);
                        }
                    }
                    System.out.println(clients[clientIndex].toString() + "\nInformation changed successfully.\n");
                }
            }

            // Delete a client
            case 3 -> {
                // Display clients
                for (int k = 0; k < clients.length; k++) {
                    System.out.println(clients[k].toString());
                }

                // Prompt user for information
                System.out.print("Enter the id of the client you wish to delete: ");
                String id = scanner.next();

                int indexToDelete = 0;
                for (int n = 0; n < clients.length; n++) {
                    if (id.equalsIgnoreCase(clients[n].getId())){
                        indexToDelete = n;
                    }
                    else {
                        System.out.println("Invalid client id.\n");
                        return clients;
                    }
                }

                // Create temporary array
                Client[] tempArray = new Client[clients.length -1];
                // Copy old array into tempArray except for the client to delete
                for (int k = 0, j= 0; k < clients.length; k++) {
                    if (k != indexToDelete) {
                        tempArray[j++] = clients[k];
                    }
                }
                // Replace old array
                clients = tempArray;
                System.out.println("Client deleted successfully!");
                // Display all clients
                for (int j = 0; j < clients.length ; j++) {
                    System.out.println(clients[j]);
                }
                System.out.print("\n");
            }
        }
        return clients;
    }// end of editClientInfo

    public static void runPredefinedScenario() {
        // Create sample objects
        Client client1 = new Client("John Doe", "1234567890", "john@example.com");
        Client client2 = new Client("Jane Smith", "9876543210", "jane@example.com");
        Client client3 = new Client("Alice Johnson", "1112223333", "alice@example.com");

        Book book1 = new Book("Java Programming", "John Smith", 2020, 500);
        Book book2 = new Book("Python Basics", "Alice Brown", 2019, 400);
        Book book3 = new Book("C++ Essentials", "Bob Johnson", 2018, 600);

        Journal journal1 = new Journal("Science Journal", "Jane Doe", 2021, 10);
        Journal journal2 = new Journal("Nature Journal", "John Smith", 2022, 15);
        Journal journal3 = new Journal("Tech Journal", "Alice Brown", 2020, 8);

        Media media1 = new Media("Movie DVD", "Director X", 2022, "video");
        Media media2 = new Media("Music CD", "Artist Y", 2023, "audio");
        Media media3 = new Media("Game DVD", "Developer Z", 2021, "interactive");

        // Create array of items
        Client[] clients = new Client[]{client1, client2, client3};
        Book[] books = new Book[]{book1, book2, book3};
        Journal[] journals = new Journal[]{journal1, journal2, journal3};
        Media[] media = new Media[] {media1, media2, media3};

        // Display information
        System.out.println("Client Information:");
        for (int i = 0; i < clients.length ; i++) {
            System.out.println(clients[i].toString());
        }

        System.out.println("\nBook Information:");
        for (int i = 0; i < books.length ; i++) {
            System.out.println(books[i].toString());
        }

        System.out.println("\nJournal Information:");
        for (int i = 0; i < journals.length ; i++) {
            System.out.println(journals[i].toString());
        }

        System.out.println("\nMedia Information:");
        for (int i = 0; i < media.length ; i++) {
            System.out.println(media[i].toString());
        }

        // Test equality of objects
        System.out.println("\nTesting Equality:");
        System.out.println("Client1 equals Client2: " + clients[0].equals(clients[1]));
        System.out.println("Book1 equals Book2: " + books[0].equals(books[1]));
        System.out.println("Journal1 equals Journal3: " + journals[0].equals(journals[1]));

        // Demonstrate usage of getBiggestBook() method
        Book biggestBook = getBiggestBook(books);
        System.out.println("\nBiggest Book:");
        System.out.println(biggestBook);

        // Demonstrate usage of copyBooks() method
        System.out.println("\nCopied Books:");
        Book[] copiedBooks = copyBooks(books);

        System.out.print("\n");
    }// end of runPredefinedScenario

    public static void leaseItems(Item[] items, Client[] clients) {
        //Prompt user for choice
        System.out.print("""
                \nWhat would you like to do
                1. lease an item to a client
                2. return a leased item from a client
                Enter your choice:\s""");
        int choice = scanner.nextInt();

        // Display items
        for (int i = 0; i < items.length; i++) {
            if (!items[i].getLeased()) {
                System.out.println(items[i].toString());
            }
        }
        switch(choice) {
            // Leasing an item
            case 1 -> {
                if (items.length == 0) {
                    System.out.println("No items found.");
                }
                else if (clients.length == 0) {
                    System.out.println("No clients found.");
                }
                else {
                    //Display items
                    for (int i = 0; i < items.length; i++) {
                        System.out.println(items[i].toString());
                    }

                    // Prompt user for information
                    System.out.print("Enter the id of the number you wish to lease: ");
                    String id = scanner.next();

                    int itemIndex = 0;
                    for (int n = 0; n < items.length; n++) {
                        if (id.equalsIgnoreCase(items[n].getId())){
                            itemIndex = n;
                        }
                        else {
                            System.out.println("Invalid item id.\n");
                            return;
                        }
                    }

                    //Display clients
                    System.out.print("\n");

                    // Prompt user for information
                    System.out.print("Enter the number of the client you wish to lease the item to: ");
                    String clientId = scanner.next();

                    int clientIndex = 0;
                    for (int n = 0; n < clients.length; n++) {
                        if (clientId.equalsIgnoreCase(clients[n].getId())){
                            clientIndex = n;
                        }
                        else {
                            System.out.println("Invalid item id.\n");
                            return;
                        }
                    }

                    if (items[itemIndex].getLeased()) {
                        System.out.print("Sorry this item is already leased.\n");
                    }
                    else {
                        items[itemIndex].setLeased(true);
                        items[itemIndex].setClientLeasedTo(clients[clientIndex]);
                        System.out.println("Item leased to client successfully.\n");
                    }
                }

            }
            case 2 -> {
                // Display leased items
                for (int i = 0; i < items.length; i++) {
                    if (items[i] != null && items[i].getLeased()) {
                        System.out.println("'" + items[i].getId() + "': leased to " + items[i].getLeasedTo().getId());
                    }
                }

                // Prompt for item selection
                System.out.print("Enter the number of the item you want to return: ");
                String itemId = scanner.next();

                int itemIndex = 0;
                for (int n = 0; n < clients.length; n++) {
                    if (itemId.equalsIgnoreCase(clients[n].getId())){
                        itemIndex = n;
                    }
                    else if (!items[itemIndex].getLeased()) {
                        System.out.println("Item isn't leased.");
                        return;
                    }
                    else {
                        System.out.println("Invalid item id.\n");
                        return;
                    }
                }

                // Return the item
                items[itemIndex].setLeased(false);
                items[itemIndex].setClientLeasedTo(null);
                System.out.println("Item returned successfully.");

            }
            default -> System.out.println("Invalid choice.\n");
        }

    }// end of leaseItems

    public static void ShowItemsLeasedByAClient(Item[] items, Client[] clients) {
        //Display clients
        for (int j = 0; j < clients.length; j++) {
            System.out.println(clients[j].toString());
        }

        System.out.print("Enter the client's number to view their leased items: ");
        int clientChoice = scanner.nextInt() - 1;

        System.out.println("Items leased by client "+ clients[clientChoice].getId());

        for (int i = 0; i < items.length; i++) {
            if (items[i].getLeased() && items[i].getLeasedTo().getName().equalsIgnoreCase(clients[clientChoice].getName())) {
                System.out.println(items[i]);
            }
        }
        System.out.print("\n");
    }// end of ShowItemsLeasedByAClient

    public static void ShowAllLeasedItems(Item[] items) {
        int count = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getLeased()) {
                System.out.println(items[i].toString());
                count++;
            }
        }
        if (count == 0) {System.out.println("No items are leased");}
        System.out.println(" ");
    }// end of ShowAllLeasedItems

    public static Book getBiggestBook(Book[] books) {
        Book biggestBook = books[0];
        for (int i = 0; i < books.length; i++){
            if (books[i].getNumberOfPages() > biggestBook.getNumberOfPages()) {
                biggestBook = books[i];
            }
        }
        return biggestBook;
    }// end of getBiggestBook

    public static Book[] copyBooks(Book[] books) {
        Book[] copiedBooks = new Book[books.length];
        for (int i = 0; i < books.length; i++) {
            copiedBooks[i] = new Book(books[i]);
            // Display copied books
            System.out.println(copiedBooks[i].toString());
        }
        System.out.print("\n");
        return copiedBooks;
    }// end of copyBooks
}// end of LibraryDriver
