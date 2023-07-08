package Library_Books_Management_System;

import java.util.List;
import java.util.Scanner;

public class User_Interface 
{
	public static void main(String[] args) {
        Library_Racks libraryracks = new Library_Racks();

        libraryracks.addBook(new Books("Book 1", "Author 1"));
        libraryracks.addBook(new Books("Book 2", "Author 2"));
        libraryracks.addBook(new Books("Book 3", "Author 3"));

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. View all books");
            System.out.println("2. Issue a book");
            System.out.println("3. Return a book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    displayBooks(libraryracks.getAllBooks());
                    break;
                case 2:
                    displayBooks(libraryracks.getAllBooks());
                    System.out.print("Enter the index of the book to issue: ");
                    int index = sc.nextInt();
                    if (index >= 0 && index < libraryracks.getAllBooks().size()) {
                    	Books bookToIssue = libraryracks.getAllBooks().get(index);
                        if (bookToIssue.isAvailable()) {
                            bookToIssue.setAvailable(false);
                            System.out.println("Book issued successfully!");
                        } else {
                            System.out.println("Book is not available for issue!");
                        }
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;
                case 3:
                    displayBooks(libraryracks.getAllBooks());
                    System.out.print("Enter the index of the book to return: ");
                    int returnIndex = sc.nextInt();
                    if (returnIndex >= 0 && returnIndex < libraryracks.getAllBooks().size()) {
                    	Books bookToReturn = libraryracks.getAllBooks().get(returnIndex);
                        bookToReturn.setAvailable(true);
                        System.out.println("Book returned successfully!");
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

            System.out.println();
        } while (choice != 4);

        sc.close();
    }
	
	private static void displayBooks(List<Books> books) 
    {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("Books available in the library:");
            for (int i = 0; i < books.size(); i++) {
            	Books book = books.get(i);
                System.out.println(i + ". " + book.getTitle() + " by " + book.getAuthor()
                        + (book.isAvailable() ? " (Available)" : " (Not available)"));
            }
        }
        System.out.println();
    }
}
