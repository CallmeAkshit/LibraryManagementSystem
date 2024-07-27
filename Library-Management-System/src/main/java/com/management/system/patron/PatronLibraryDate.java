package com.management.system.patron;

import java.time.LocalDate;

public class PatronLibraryDate {

	// Fields
    private LocalDate issueDate;
    private LocalDate returnDate;
    private LocalDate returnedOnDate;


    // Getters and Setters
    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    
    public LocalDate getReturnedOnDate() {
		return returnedOnDate;
	}

	public void setReturnedOnDate(LocalDate returnedOnDate) {
		this.returnedOnDate = returnedOnDate;
	}
	
	public PatronLibraryDate(LocalDate issueDate, LocalDate returnedOnDate) {
		super();
		this.issueDate = issueDate;
		this.returnDate = issueDate.plusWeeks(2);
		this.returnedOnDate = returnedOnDate;
	}

	// Main method for testing
    public static void main(String[] args) {
        // Example usage
        LocalDate issueDate = LocalDate.now();
        LocalDate returnDate = issueDate.plusWeeks(2); // For example, return date is 2 weeks from issue date
        
        PatronLibraryDate patronLibraryDate = new PatronLibraryDate(issueDate, returnDate);
        System.out.println(patronLibraryDate);
    }
    
}
