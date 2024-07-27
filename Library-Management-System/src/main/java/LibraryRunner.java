import java.util.Set;
import java.util.stream.Collectors;

import com.management.system.library.Book;
import com.management.system.library.Book.Genre;
import com.management.system.library.BookCopy;
import com.management.system.library.Library;
import com.management.system.patron.Patron;
import com.management.system.patron.PatronLendingManager;

public class LibraryRunner {

	public static void main(String[] args) {
		
		//new patrons created
		Patron p1 = new Patron("Rahul", "9915023955", "rahul.singh@gmial.com", "Student", "Engineering");
		Patron p2 = new Patron("Shreya", "9966551010", "Shreya.goyal@gmial.com", "Software Engineer", "Engineering");
		
		//new library created
		Library nalandaLibrary = new Library("Nalanda Library");
		
		//registered members with library
		nalandaLibrary.registerNewMember(p1);
		nalandaLibrary.registerNewMember(p2);
		
		//created book1
		Book book1 = new Book("The Body Keeps the score", "B. Van Der Kolk", "9780141978611", 2017, Genre.NON_FICTION);
		
		//number of copies in library for book1
		Integer numCopiesBook1 = 10;
		
		//created book1
		Book book2 = new Book("The gift of imperfections", "Dr. Benne Brown", "9780141922001", 2012, Genre.NON_FICTION);
		
		//number of copies in library for book2
		Integer numCopiesBook2 = 5;
		
		//created book1
		Book Book3 = new Book("The Kite Runner", "Khaled H.", "9780141921010", 2013, Genre.FICTION);
				
		//number of copies in library for book2
		Integer numCopiesBook3 = 4;
		
		//added book copies in inventory of library 1
		nalandaLibrary.getInventory().addBook(book1, numCopiesBook1);
		nalandaLibrary.getInventory().addBook(book2, numCopiesBook2);
		nalandaLibrary.getInventory().addBook(Book3, numCopiesBook3);
		
		//get all book copies of a book
		Set<BookCopy> bookCopiesOfBook3 = nalandaLibrary.getInventory().getBookCopiesForParentBook(Book3);
		
		//remove book copy with id 2 for book3 as it is damaged
		BookCopy damagedBookCopy = bookCopiesOfBook3.stream().filter(copy -> copy.getId() == 2).collect(Collectors.toList()).get(0);
		nalandaLibrary.getInventory().removeBook(Book3, damagedBookCopy);
		
		PatronLendingManager patronManagerforP1 = new PatronLendingManager(p1);
		
		//p1 borrowed a book from nalandaLibrary
		patronManagerforP1.borrowBook(book1, nalandaLibrary);
		
		//borrow history for p1 from Nalanda library
		patronManagerforP1.getPatronHistoryByLibrary(nalandaLibrary);
		
		nalandaLibrary.getInventory().findBookByIsbn("9780141978611");
		

	}

}
