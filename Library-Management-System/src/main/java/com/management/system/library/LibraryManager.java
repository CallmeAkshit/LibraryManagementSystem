package com.management.system.library;

import com.management.system.patron.Patron;

public interface LibraryManager {
	
	public void registerNewMember(Patron patron);
	
	public void closeMemberAccount(Patron patron);
	

}
