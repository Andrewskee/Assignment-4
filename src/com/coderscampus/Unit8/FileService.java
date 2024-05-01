package com.coderscampus.Unit8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileService {

	public Student[] readStudentsFromFile() {
		Student[] students = new Student[100];
		int studentValues = 0;
	
	
	try {BufferedReader reader = new BufferedReader(new FileReader("Masterlist.csv.txt"));
		String fileLine;
		boolean isFirstLine = true;
		while((fileLine = reader.readLine())!= null && studentValues <100){
			if (isFirstLine ) {
				isFirstLine = false;
				continue;
			}
			String[] values = fileLine.split(",");
			if (values.length >= 4) {
				int id = Integer.parseInt(values[0]);
				String name = values[1];
				int grade = Integer.parseInt(values[2]);
				String course = values[3];
				
				String[] courseParts = course.split(" ");
				if (courseParts.length >= 2) {
					String courseName = courseParts[0];
					int courseNumber = Integer.parseInt(courseParts[1]);
					
				}else {
					 System.out.println("Invalid course format: " + course);
					 
				}
				
				
				StoredUsers storedUsers = new StoredUsers();
				students[studentValues++] = storedUsers.getStudentInfo(id, name, course, grade);
				
				
			}
		}
		reader.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return students;
	}
	
class StoredUsers {
		
//		public User studentUser;

		public Student getStudentInfo(Integer id,String name, String course,Integer grade ) {
			Student student = new Student(id, name, course, grade);
			
			student.setId(id);
			student.setName(name);
			student.setCourse(course);
			student.setGrade(grade);
			return student; 
		}
}
	
class StudentService {
	
	FileService fileService = new FileService();
	Student[] mainUsers = fileService.readStudentsFromFile();
//	StoredUsers storedUsers = new StoredUsers();
//	Student[] mainUsers = new Student[100];
		
	public StudentService() {
//	for (int i = 0; i < 100; i++) {
//		mainUsers[i] = storedUsers.getStudentInfo(id, name, course, grade);
//		
//	}
	
}	
}	

	
	

	
}
