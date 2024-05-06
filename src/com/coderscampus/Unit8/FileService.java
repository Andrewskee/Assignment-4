package com.coderscampus.Unit8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FileService {

//	private static final int MAX_STUDENTS = 100;

	public Student[] readStudentsFromFile() {
		Student[] students = new Student[100];
		int studentCount = 0;

		try {
			BufferedReader reader = new BufferedReader(new FileReader("Masterlist.csv.txt"));
			String fileLine;
			boolean isFirstLine = true;
			while ((fileLine = reader.readLine()) != null && studentCount < 100) {
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

		// Separate students by course and write to CSV files

		try (

				BufferedWriter writer1 = new BufferedWriter(new FileWriter("course1.txt"));
				BufferedWriter writer2 = new BufferedWriter(new FileWriter("course2.txt"));
				BufferedWriter writer3 = new BufferedWriter(new FileWriter("course3.txt"))

		) {
			// Write header to each file
			writer1.write("Student ID,Student Name,Course,Grade\n");
			writer2.write("Student ID,Student Name,Course,Grade\n");
			writer3.write("Student ID,Student Name,Course,Grade\n");

			// Sort students by grade in descending order
			Arrays.sort(students, (s1, s2) -> Integer.compare(s2.getGrade(), s1.getGrade()));

			for (Student student : students) {
				if (student != null) {

					String course = student.getCourse();
					int spaceIndex = course.indexOf(" ");
					if (spaceIndex != -1) {
						String coursePrefix = course.substring(0, spaceIndex);
						String courseSuffix = course.substring(spaceIndex + 1);
						BufferedWriter writer;
						if (courseSuffix.matches("\\d+")) {

							if (coursePrefix.equals("COMPSCI")) {
								writer = writer1; // Use writer1 for COMPSCI
							} else if (coursePrefix.equals("APMTH")) {
								writer = writer2; // Use writer2 for APMTH
							} else if (coursePrefix.equals("STAT")) {
								writer = writer3; // Use writer3 for STAT
							} else {
								continue;
							}
							writeStudentToTxt(writer, student);
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

}
