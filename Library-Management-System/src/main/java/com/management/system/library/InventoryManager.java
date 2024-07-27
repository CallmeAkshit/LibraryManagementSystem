package com.management.system.library;

import com.management.system.patron.Patron;

public interface InventoryManager {
	
	public BookCopy lendBook(Book book, Patron p);
		
	public void removeBook(Book book, BookCopy bookCopy);

	void acceptReturn(BookCopy bookCopy, Patron p);

	void addBook(Book book, Integer numCopies);

}
