package model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Student {
	
	private String id;
	private String name;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")//auto convert from string to date
	private Date dob;
	private int age;
	
	
	
	public Student() {
	
	}
	public Student(String id, String name, Date dob, int age) {
		
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", dob=" + dob + ", age=" + age + "]";
	}
	
	
}
