package com.coderscampus.Unit8;

public class StudentService {
	
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
