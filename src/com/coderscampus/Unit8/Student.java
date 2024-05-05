package com.coderscampus.Unit8;

import java.io.Serializable;

public class Student implements Comparable<Student>, Serializable{


	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String course;
	private int grade;
	
	
	public Student(int id, String name, String course, int grade) {
		this.id = id;
		this.name = name;
		this.course = course;
		this.grade = grade; 
	}


	

	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return 0;
	} 
	@Override
	
	public String toString() {
		return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", grade=" + grade +
                '}';
    }
	
	
}
