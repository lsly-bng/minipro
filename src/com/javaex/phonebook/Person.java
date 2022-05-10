package com.javaex.phonebook;

public class Person {

	// field
	private String name;
	private String hp;
	private String company;

	// constructor
	public Person() {
		super();
	}

	public Person(String name, String hp, String company) {
		super();
		this.name = name;
		this.hp = hp;
		this.company = company;
	}

	// method - gs
	public String getName() {
		return name;
	}

	public String getHp() {
		return hp;
	}

	public String getCompany() {
		return company;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	// method - general
	public void showInfo() {
		System.out.println(".  " + name + "   " + hp + "   " + company);
	}

	@Override
	public String toString() {
		return "이름: " + name + "/n 핸드폰: " + hp + "/n 회사: " + company + "]";
	}

}
