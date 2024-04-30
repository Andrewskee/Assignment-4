package com.coderscampus.Unit8;

public class StoredUsers {
		
		public User studentUser;

		public Student studentUser(Integer id,String name, Integer grade,String course) {
			Student user = new Student(id, name, course, grade);
			
			user.setId(id);
			user.setName(name);
			user.setCourse(course);
			user.setGrade(grade);
			return user; 
		}


	
}
