package Library_Books_Management_System;

import java.util.List;
import java.util.Scanner;

public class Admin_Operator 
{
	public static void main(String[] args) 
	{
		Library_Racks libraryracks = new Library_Racks();

		libraryracks.addBook(new Books("Book 1", "Author 1"));
		libraryracks.addBook(new Books("Book 2", "Author 2"));
		libraryracks.addBook(new Books("Book 3", "Author 3"));

        Scanner sc = new Scanner(System.in);
        int choice;

        do 
        {
            System.out.println("1. View all books");
            System.out.println("2. Add a book");
            System.out.println("3. Remove a book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) 
            {
                case 1:
                    displayBooks(libraryracks.getAllBooks());
                    break;
                case 2:
                    sc.nextLine();
                    System.out.print("Enter the title of the book: ");
                    String title = sc.nextLine();
                    System.out.print("Enter the author of the book: ");
                    String author = sc.nextLine();
                    libraryracks.addBook(new Books(title, author));
                    System.out.println("Book added successfully!");
                    break;
                case 3:
                    displayBooks(libraryracks.getAllBooks());
                    System.out.print("Enter the index of the book to remove: ");
                    int index = sc.nextInt();
                    if (index >= 0 && index < libraryracks.getAllBooks().size()) 
                    {
                    	Books bookToRemove = libraryracks.getAllBooks().get(index);
                    	libraryracks.removeBook(bookToRemove);
                        System.out.println("Book removed successfully!");
                    } 
                    else 
                    {
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
        }
        while (choice != 4);

        sc.close();
    }

    private static void displayBooks(List<Books> books) 
    {
        if (books.isEmpty()) 
        {
            System.out.println("No books available.");
        } 
        else 
        {
            System.out.println("Books available in the library:");
            for (int i = 0; i < books.size(); i++) 
            {
            	Books book = books.get(i);
                System.out.println(i + ". " + book.getTitle() + " by " + book.getAuthor() + (book.isAvailable() ? " (Available)" : " (Not available)"));
            }
        }
        System.out.println();
    }
}
