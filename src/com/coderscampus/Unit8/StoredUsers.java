package com.coderscampus.Unit8;

public class StoredUsers {

	public Student getStudentInfo(Integer id, String name, String course, Integer grade) {
		Student student = new Student(id, name, course, grade);

		student.setId(id);
		student.setName(name);
		student.setCourse(course);
		student.setGrade(grade);
		return student;
	}

}
