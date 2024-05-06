package com.coderscampus.Unit8;

public class SortingApp {

	public static void main(String[] args) {
		
		FileService fileService = new FileService();
		fileService.processStudentData(); 
		Student[] students = fileService.readStudentsFromFile();
		
		for (Student student : students) {
			if (student != null) {
				
			}
		}
	}

}