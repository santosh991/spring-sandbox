package net.agilegeeks.wicketspring.pages.count;

import java.io.Serializable;

public class Count implements Serializable {

	private static final long	serialVersionUID	= -611962421581994665L;
	
	public long count = 0;
	
	public void increment() {
		count++;
	}
	
	public String toString() {
		return String.valueOf(count);
	}

}
