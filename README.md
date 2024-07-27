Library Management System
Library Management System is a Java-based application to manage books, patrons, and lending processes efficiently. This project demonstrates the understanding and application of Object-Oriented Programming (OOP), SOLID principles, and relevant design patterns.

Table of Contents
1. Features
2. Installation
3. Usage
4. Class Structure
5. Design Principles and Patterns
6. Logging
7. Contributing
8. License
9. Features

    
Book Management: Add, remove, and update books with attributes such as title, author, ISBN, and publication year.
Patron Management: Add new patrons, update their information, and track their borrowing history.
Lending Process: Implement book checkout and return functionalities.
Inventory Management: Track available and borrowed books.
Search Functionality: Find books by title, author, or ISBN.

Installation
To set up the project locally:

Clone the repository:
git clone https://github.com/your-username/library-management-system.git
Navigate to the project directory:
cd library-management-system
Build and run the project using your preferred IDE or command line tool.
Usage
To get started with the Library Management System:

Example Code
Here's an example demonstrating the creation of a library system with patrons, books, and lending functionality:

public class LibraryRunner {

    public static void main(String[] args) {
        // new patrons created
        Patron p1 = new Patron("Rahul", "9915023955", "rahul.singh@gmial.com", "Student", "Engineering");
        Patron p2 = new Patron("Shreya", "9966551010", "Shreya.goyal@gmial.com", "Software Engineer", "Engineering");

        // new library created
        Library nalandaLibrary = new Library("Nalanda Library");

        // registered members with library
        nalandaLibrary.registerNewMember(p1);
        nalandaLibrary.registerNewMember(p2);

        // created books
        Book book1 = new Book("The Body Keeps the score", "B. Van Der Kolk", "9780141978611", 2017, Genre.NON_FICTION);
        Book book2 = new Book("The gift of imperfections", "Dr. Benne Brown", "9780141922001", 2012, Genre.NON_FICTION);
        Book book3 = new Book("The Kite Runner", "Khaled H.", "9780141921010", 2013, Genre.FICTION);

        // number of copies in library
        nalandaLibrary.getInventory().addBook(book1, 10);
        nalandaLibrary.getInventory().addBook(book2, 5);
        nalandaLibrary.getInventory().addBook(book3, 4);

        // remove damaged book copy
        BookCopy damagedBookCopy = nalandaLibrary.getInventory().getBookCopiesForParentBook(book3)
                .stream().filter(copy -> copy.getId() == 2).collect(Collectors.toList()).get(0);
        nalandaLibrary.getInventory().removeBook(book3, damagedBookCopy);

        // patron borrowing book
        PatronLendingManager patronManagerforP1 = new PatronLendingManager(p1);
        patronManagerforP1.borrowBook(book1, nalandaLibrary);

        // borrowing history
        patronManagerforP1.getPatronHistoryByLibrary(nalandaLibrary);

        // find book by ISBN
        nalandaLibrary.getInventory().findBookByIsbn("9780141978611");
    }
}
Class Structure
Patron: Represents library members with attributes like name, contact details, and occupation.
Book: Represents books with attributes like title, author, ISBN, publication year, and genre.
Library: Manages inventory and patron registrations.
BookCopy: Represents individual book copies.
PatronLendingManager: Manages book lending for a specific patron.


