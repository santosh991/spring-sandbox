package net.agilegeeks.wicketspring.pages.form;

import java.io.Serializable;

public class FormBean implements Serializable {

	private static final long	serialVersionUID	= -7587711137777606464L;
	
	private String username;
	private Integer age;
	private Gender gender;
	private Boolean allowEmails;
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}
	
	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @return the allowEmails
	 */
	public Boolean getAllowEmails() {
		return allowEmails;
	}

	/**
	 * @param allowEmails the allowEmails to set
	 */
	public void setAllowEmails(Boolean allowEmails) {
		this.allowEmails = allowEmails;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FormBean [username=" + username + ", age=" + age + ", gender=" + gender + ", allowEmails=" + allowEmails + "]";
	}

	
}
