package Library_Books_Management_System;

import java.util.ArrayList;
import java.util.List;

public class Library_Racks 
{
	private List<Books> books;

    public Library_Racks() {
        books = new ArrayList<>();
    }

    public void addBook(Books book) {
        books.add(book);
    }

    public void removeBook(Books book) {
        books.remove(book);
    }

    public List<Books> getAllBooks() {
        return books;
    }
}
