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
		
		// Compare by ID
	    if (this.id < o.id) {
	        return -1;
	    } else if (this.id > o.id) {
	        return 1;
		}
	    // If IDs are the same, compare by name
		int nameCompare = this.name.compareTo(o.name);
	    if (nameCompare != 0) {
	        return nameCompare;
	    }
	    
	    // If names are the same, compare by course
	    int courseCompare = this.course.compareTo(o.course);
	    if (courseCompare != 0) {
	        return courseCompare;
	    }
	    
	    // If courses are the same, compare by grade
	    return Integer.compare(this.grade, o.grade);
		
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
