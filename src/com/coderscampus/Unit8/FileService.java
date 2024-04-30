package com.coderscampus.Unit8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class FileService {

	public void readFile() {
		
		BufferedReader reader = null;
		
	try {
		reader = new BufferedReader(new FileReader("Masterlist.csv.txt"));
		String fileLine;
		while((fileLine = reader.readLine())!= null){
			String[] values = fileLine.split(",");
		for (String value : values) {
			
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

		public Student getStudentInfo(int id,String name, int grade,String course) {
			Student user = new Student();
			
			user.setId(id);
			user.setName(name);
			user.setCourse(course);
			user.setGrade(grade);
			return user; 
		}
}
	
class StudentService {
	
	StoredUsers storedUsers = new StoredUsers();
	
	User[] mainUsers = new User[100]; 
		
	public StudentService() {
	for (int i = 0; i < 100; i++) {
		mainUsers[i] = storedUsers.getStudentInfo("id" + (i+1), "name" + (i+1), "course" + (i+1), "grade" + (i+1));            
		
	}
	
}	
}	

	
	

	
}
