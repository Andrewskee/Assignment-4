package com.coderscampus.Unit8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class FileService {

	private static final int MAX_STUDENTS = 100;

	public Student[] readStudentsFromFile() {
		Student[] students = new Student[MAX_STUDENTS];
		int studentCount = 0;

		try {
			BufferedReader reader = new BufferedReader(new FileReader("Masterlist.csv.txt"));
			String fileLine;
			boolean isFirstLine = true;
			while ((fileLine = reader.readLine()) != null && studentCount < MAX_STUDENTS) {
				if (isFirstLine) {
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
		sortStudentsByCourseAndGrade(students);

		// Separate students by course and write to CSV files

		try (   

				BufferedWriter writer1 = new BufferedWriter(new FileWriter("course1.txt"));
				BufferedWriter writer2 = new BufferedWriter(new FileWriter("course2.txt"));
				BufferedWriter writer3 = new BufferedWriter(new FileWriter("course3.txt"))){
			
			
			for (Student student : students) {
				if (student != null) {

					BufferedWriter writer = null; 
					
				try {
					if (student.getCourse().equals("COMPSCI")) {
			           
			            writer = writer1;  // Use writer1 for COMPSCI
			        } else if (student.getCourse().equals("APMTH")) {
			        
			            writer = writer2;  // Use writer2 for APMTH
			        } else if (student.getCourse().equals("STAT")) {
	
			            writer = writer3;  // Use writer3 for STAT
					} else {
						continue;
					}
					
					writeStudentToTxt(writer, student);
	                } finally {
	                    if (writer != null) {
	                        writer.close();
	                    }
	                }
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}	  
	private void writeStudentToTxt(BufferedWriter writer, Student student) {
		try {
			writer.write(student.getId() + "," + student.getName() + "," + student.getCourse() + ","
					+ student.getGrade() + "\n");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sortStudentsByCourseAndGrade(Student[] students) {
		
		
		Arrays.sort(students, new Comparator<Student>() {

			@Override
			public int compare(Student s1, Student s2) {

//				// First, compare by course
				int courseCompare = s1.getCourse().compareTo(s2.getCourse());
				if (courseCompare != 0) {
					return courseCompare;

				}
//				 If courses are the same, compare by grade in descending order
				return Integer.compare(s2.getGrade(), s1.getGrade());
			}
		});
	}


}
//	}
