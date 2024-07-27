package com.management.system.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.management.system.patron.Patron;

public class Inventory implements InventoryManager{

	private Long id;
	Library library;
	
	private Map<Book,Set<BookCopy>> bookCopiesByParentBook;
	
	private Map<BookCopy, Patron> bookByPatron;
	
	private Map<String, Book> booksByIsbn;
    private Map<String, List<Book>> booksByTitle;
    private Map<String, List<Book>> booksByAuthor;
   

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Map<Book, Set<BookCopy>> getBookCopiesByParentBook() {
		return bookCopiesByParentBook;
	}

	public void setBookCopiesByParentBook(Map<Book, Set<BookCopy>> bookCopiesByParentBook) {
		this.bookCopiesByParentBook = bookCopiesByParentBook;
	}

	public Map<BookCopy, Patron> getBookByPatron() {
		return bookByPatron;
	}

	public void setBookByPatron(Map<BookCopy, Patron> bookByPatron) {
		this.bookByPatron = bookByPatron;
	}
	
	@Override
	public BookCopy lendBook(Book book, Patron p) {
		
		Set<BookCopy> bookCopies= bookCopiesByParentBook.get(book);
		if(bookCopies != null && bookCopies.size() != 0) {
			for(BookCopy copy: bookCopies ) {
				if(bookByPatron.get(copy) == null) {
					bookByPatron.put(copy, p);
					return copy;
				}
			}
			
			System.out.println("Book not in stock");
		}else {
			System.out.println("Book : " + book.getTitle() + " does not exist" );
		}
		
		return null;
	}
	
	@Override
	public void acceptReturn(BookCopy bookCopy, Patron p) {
		bookByPatron.put(bookCopy, null);
		
	}
	@Override
	public void addBook(Book book, Integer numCopies) {
		Long numExistingCopies = (long) (bookCopiesByParentBook.get(book) == null ? 0 : bookCopiesByParentBook.get(book).size());
		for(int i=1 ; i<=numExistingCopies; i++) {
			BookCopy bookCopy = new BookCopy(book.getId(), numExistingCopies+i);
			if(bookCopiesByParentBook.get(book) == null) {
				List<BookCopy> bookCopies = new ArrayList<>();
				bookCopies.add(bookCopy);
			}else {
				bookCopiesByParentBook.get(book).add(bookCopy);
			}
			
			bookByPatron.put(bookCopy, null);
		}
		
		booksByIsbn.put(book.getIsbn(), book);

        booksByTitle.computeIfAbsent(book.getTitle().toLowerCase(), k -> new ArrayList<>()).add(book);
        booksByAuthor.computeIfAbsent(book.getAuthor().toLowerCase(), k -> new ArrayList<>()).add(book);
		
	}
	
	@Override
	public void removeBook(Book book, BookCopy bookCopy) {
		if(!bookCopy.isIssued()) {
			bookCopiesByParentBook.get(book).remove(bookCopy);
		}
		System.out.println("Book cannot be removed, already issued to a patron.");
		
	}
	
	// Find books by title
    public List<Book> findBooksByTitle(String title) {
        return booksByTitle.getOrDefault(title.toLowerCase(), new ArrayList<>());
    }

    // Find books by author
    public List<Book> findBooksByAuthor(String author) {
        return booksByAuthor.getOrDefault(author.toLowerCase(), new ArrayList<>());
    }

    // Find a book by ISBN
    public Book findBookByIsbn(String isbn) {
        return booksByIsbn.get(isbn);
    }
	

	public Inventory() {
		super();
		this.bookCopiesByParentBook = new HashMap<>();
		this.bookByPatron = new HashMap<>();
	}
	
	public Set<BookCopy> getBookCopiesForParentBook(Book book) {
		Set<BookCopy> bookCopies = bookCopiesByParentBook.get(book);
		if(bookCopies.size() == 0) {
			System.out.println("No book copy avaiable for book:" + book.getTitle());
			return null;
		}
		
		return bookCopies;
	}
	
	
	
	
}
