package com.coderscampus.Unit8;

public class SortingApp {

	public static void main(String[] args) {
		
		FileService fileService = new FileService();
		Student[] students = fileService.readStudentsFromFile();
		
		for (Student student : students) {
			if (student != null) {
				System.out.println(student);
			}
		}
	}

}