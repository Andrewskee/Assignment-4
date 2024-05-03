package com.coderscampus.Unit8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class FileService {
	
	private static final int MAX_STUDENTS = 100;

	public Student[] readStudentsFromFile() {
		Student[] students = new Student[MAX_STUDENTS];
		int studentCount = 0;
	
	
	try {BufferedReader reader = new BufferedReader(new FileReader("Masterlist.csv.txt"));
		String fileLine;
		boolean isFirstLine = true;
		while((fileLine = reader.readLine())!= null && studentCount <100){
			if (isFirstLine ) {
				isFirstLine = false;
				continue;
			}
			String[] values = fileLine.split(",");
			if (values.length >= 4) {
				int id = Integer.parseInt(values[0]);
				String name = values[1];
				String course = values[2];
				int grade = Integer.parseInt(values[3]);
				 Student student = new Student(id, name, course, grade);
                 students[studentCount++] = student;

				
			
				}
				
			
		}
		
		reader.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
	 // Resize the array to remove null elements
	 Student[] resizedStudents = new Student[studentCount];
     System.arraycopy(students, 0, resizedStudents, 0, studentCount);
     return resizedStudents;
	}
	
	public void processStudentData() {
		Student[] students = readStudentsFromFile();
		  sortStudentsByGrade(students);
		 
		  // Separate students by course and write to CSV files
		  
		
			  try (FileOutputStream fileOutputStream1 = new FileOutputStream("course1.csv");
				   FileOutputStream fileOutputStream2 = new FileOutputStream("course2.csv");
				   FileOutputStream fileOutputStream3 = new FileOutputStream("course3.csv");
				   BufferedWriter writer1 = new BufferedWriter(new OutputStreamWriter(fileOutputStream1));
				   BufferedWriter writer2 = new BufferedWriter(new OutputStreamWriter(fileOutputStream2));
				   BufferedWriter writer3 = new BufferedWriter(new OutputStreamWriter(fileOutputStream3))) {
		        
		     
		        writer1.write("Student ID,Student Name,Course,Grade\n");
		        writer2.write("Student ID,Student Name,Course,Grade\n");
		        writer3.write("Student ID,Student Name,Course,Grade\n");
		        
		        for (Student student : students) {
		            if (student != null) {
		                String line = student.getId() + "," + student.getName() + "," + student.getCourse() + "," + student.getGrade() + "\n";
		                if (student.getCourse().equals("COMPSCI 310")) {
		                    writer1.write("\n" + line);
		                } else if (student.getCourse().equals("APMTH 134")) {
		                    writer2.write("\n" + line);
		                } else if (student.getCourse().equals("STAT 236")) {
		                    writer3.write("\n" +line);
		                }
		            }
		        }

		      
		  } catch (IOException e) {
		        e.printStackTrace();
		  }
	  }	  
	

	
	
	 private void sortStudentsByGrade(Student[] students) {
		 Arrays.sort(students, new Comparator<Student>() {

			@Override
			public int compare(Student s1, Student s2) {
				
				return Integer.compare(s2.getGrade(), s1.getGrade());
			}
		 });
	 }
	
	
	private void writeStudentToCsv(int id, String name, String course, int grade) {
		String fileName = "C:\\Coders Campus Workspace\\Coders Campus 2024\\Student Master list CSV\\" + course.replaceAll("[^a-zA-Z0-9]", "") + ".csv";
	
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
			File file = new File(fileName);
			if (new File(fileName).length()== 0) { // Check if file is empty
		writer.write("Student ID,Student Name,Course,Grade");
		writer.newLine();
			}
			 writer.write(id + "," + name + "," + course + "," + grade + "\n");
	            writer.newLine();
			
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	
//	private String getCourseFileName(String course) {
//		return course.replace(" ", "") + ".csv";
	}
//class StoredUsers {
//		
//		public User studentUser;
//
//		public Student getStudentInfo(Integer id,String name, String course,Integer grade ) {
//			Student student = new Student(id, name, course, grade);
//			
//			student.setId(id);
//			student.setName(name);
//			student.setCourse(course);
//			student.setGrade(grade);
//			return student; 
//		}
//}
//	
//class StudentService {
//	
//	FileService fileService = new FileService();
//	Student[] mainUsers = fileService.readStudentsFromFile();
////	StoredUsers storedUsers = new StoredUsers();
////	Student[] mainUsers = new Student[100];
//		
//	public StudentService() {
////	for (int i = 0; i < 100; i++) {
////		mainUsers[i] = storedUsers.getStudentInfo(id, name, course, grade);
////		
////	}
//	
//}	
	

	
	

	

