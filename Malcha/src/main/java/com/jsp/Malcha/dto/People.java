package com.jsp.Malcha.dto;

public class People {

	private String id;
	private int age;
	private int number;
	private String name;

	public People() {
	}

	public People(String id, int age, int number, String name) {
		super();
		this.id = id;
		this.age = age;
		this.number = number;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
