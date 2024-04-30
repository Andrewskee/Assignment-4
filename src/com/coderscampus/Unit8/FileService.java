package com.coderscampus.Unit8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class FileService {

	public void readFile() {
		
		BufferedReader reader = null;
		String fileLine;
	try {
		reader = new BufferedReader(new FileReader("Masterlist.csv.txt"));
		
		while((fileLine = reader.readLine())!= null){
			String[] values = fileLine.split(",");
		for (String value : values) {
			System.out.println(values);
		}
		}
		reader.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	
class StoredUsers {
		
//		public User studentUser;

		public Student getStudentInfo(Integer id,String name, Integer grade,String course) {
			Student student = new Student(id, name, course, grade);
			
			student.setId(id);
			student.setName(name);
			student.setCourse(course);
			student.setGrade(grade);
			return student; 
		}
}
	
class StudentService {
	
	StoredUsers storedUsers = new StoredUsers();
	
	User[] mainUsers = new User[100]; 
		
	public StudentService() {
	for (int i = 0; i < 100; i++) {
		mainUsers[i] = storedUsers.getStudentInfo(id, name, course, grade)
		
	}
	
}	
}	

	
	

	
}
