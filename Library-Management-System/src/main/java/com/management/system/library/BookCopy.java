package com.management.system.library;


public class BookCopy {
	
	Long parentBookId;
	
	Long id;

	public Long getParentBookId() {
		return parentBookId;
	}

	public void setParentBookId(Long parentBookId) {
		this.parentBookId = parentBookId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BookCopy(Long parentBookId, Long id) {
		super();
		this.parentBookId = parentBookId;
		this.id = id;
	}
	
	
	

}
