package net.agilegeeks.wicketspring.pages.form;

public enum Gender {
	
	MALE("Male"), FEMALE("Female");
	
	private String name;
	
	private Gender(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.name;
	}

}
