package com.management.system.library;

public class Book {
	
	// Fields
    private String title;
    private String author;
    private String isbn;
    private Integer publicationYear;
    private Long id;
    private Integer numberOfCopies;
    private Genre genre;

    // Enum for Genre
    public enum Genre {
        FICTION, NON_FICTION, MYSTERY, FANTASY, SCI_FI, BIOGRAPHY, HISTORY, ROMANCE, THRILLER
    }

    // Constructor
    public Book(String title, String author, String isbn, int publicationYear, Long id, int numberOfCopies, Genre genre) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.id = id;
        this.numberOfCopies = numberOfCopies;
        this.genre = genre;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    
    

}
