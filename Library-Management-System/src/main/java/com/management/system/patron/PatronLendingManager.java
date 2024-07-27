package com.management.system.patron;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.management.system.library.Book;
import com.management.system.library.BookCopy;
import com.management.system.library.Inventory;
import com.management.system.library.Library;

public class PatronLendingManager {


	private Patron patron;
	
	private Map<Patron, Set<Library>> librariesMapByPatron;
	
	private Map<Library, Map<BookCopy, PatronLibraryDate>> patronHistoryMapByLibrary;
	
	public PatronLendingManager(Patron patron) {
		super();
		this.patron = patron;
		patronHistoryMapByLibrary = new HashMap<>();
		librariesMapByPatron = new HashMap<>();
	}
	
	public void registerAtLibrary(Library library) {
		library.registerNewMember(patron);
		librariesMapByPatron.put(patron, new HashSet<>());
	}

	public Map<BookCopy, PatronLibraryDate> getPatronHistoryByLibrary(Library library) {
		return patronHistoryMapByLibrary.get(library);
	}
	
	public BookCopy borrowBook(Book book, Library library) {
		
		Inventory inventory = library.getInventory();
		BookCopy issuedBook = inventory.lendBook(book, patron);
		Map<BookCopy, PatronLibraryDate> patronHistory = patronHistoryMapByLibrary.get(library);
		
		LocalDate issue = LocalDate.now();
		PatronLibraryDate patronDate= new PatronLibraryDate(issue, null);
		patronHistory.put(issuedBook, patronDate);
		patronHistoryMapByLibrary.put(library, patronHistory);
		issuedBook.setIssued(true);
		return issuedBook;
		
	}
	
	public void returnBook(BookCopy bookCopy, Library library) {
		Inventory inventory = library.getInventory();
		inventory.acceptReturn(bookCopy, patron);
		Map<BookCopy, PatronLibraryDate> patronHistory = patronHistoryMapByLibrary.get(library);
		LocalDate currentDate = LocalDate.now();
		PatronLibraryDate patronDate = patronHistory.get(bookCopy);
		patronDate.setReturnDate(currentDate);
		patronHistory.put(bookCopy, patronDate);
		patronHistoryMapByLibrary.put(library, patronHistory);
		bookCopy.setIssued(false);
	}
	
	
}
