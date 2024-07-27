package com.management.system.patron;

public class Patron  {

    private String name;
    private int id;
    private String contactNo;
    private String emailId;
    private String occupation;
    private String educationBackground;

    public Patron(String name, int id, String contactNo, String emailId, String occupation, String educationBackground) {
        this.name = name;
        this.id = id;
        this.contactNo = contactNo;
        this.emailId = emailId;
        this.occupation = occupation;
        this.educationBackground = educationBackground;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEducationBackground() {
        return educationBackground;
    }

    public void setEducationBackground(String educationBackground) {
        this.educationBackground = educationBackground;
    }
    
    public void udpatePatron(Patron p, String name, String emailId, String contact) {
    	
    }

}
