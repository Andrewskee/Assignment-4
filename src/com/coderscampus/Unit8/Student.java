package com.coderscampus.Unit8;

import java.io.Serializable;

public class Student implements Comparable<Student>, Serializable{


	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String course;
	private int grade;
	
	
	public Student(Integer id, String name, String course, Integer grade) {
		this.id = id;
		this.name = name;
		this.course = course;
		this.grade = grade; 
	}


	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return 0;
	} 
	
	
}
