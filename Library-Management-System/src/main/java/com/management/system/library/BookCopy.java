package com.management.system.library;


public class BookCopy {
	
	private String parentBookId;
	
	private Long id;
	
	private boolean isIssued;

	public String getParentBookId() {
		return parentBookId;
	}

	public void setParentBookId(String parentBookId) {
		this.parentBookId = parentBookId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isIssued() {
		return isIssued;
	}

	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}

	public BookCopy(String parentBookId, Long id) {
		super();
		this.parentBookId = parentBookId;
		this.id = id;
		this.isIssued = false;
	}
	
	
	

}
