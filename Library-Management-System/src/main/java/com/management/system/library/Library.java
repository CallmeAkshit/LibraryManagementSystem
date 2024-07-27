package com.management.system.library;

import java.util.Map;

import com.management.system.patron.Patron;

public class Library implements LibraryManager{

	private String branch;
	private Inventory inventory;
	private Map<Patron, Integer> membersByStatus;
	
	@Override
	public void registerNewMember(Patron patron) {
		membersByStatus.put(patron, 1);
		
	}
	@Override
	public void closeMemberAccount(Patron patron) {
		membersByStatus.put(patron, 0);
		
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public Inventory getInventory() {
		return inventory;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	public Map<Patron, Integer> getMembersByStatus() {
		return membersByStatus;
	}
	public void setMembersByStatus(Map<Patron, Integer> membersByStatus) {
		this.membersByStatus = membersByStatus;
	}
	
	
}
