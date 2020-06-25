package com.lms.repository;

import java.util.ArrayList;

import com.lms.model.Course;

public class CourseRepository {

	// The list of courses
	private static ArrayList<Course> courses = new ArrayList<>();

	// Kind of unnecessary isn't it now that I'm writing this comment
	public static void addCourse(Course course) {

		courses.add(course);
	}

	// Does what you think
	public static ArrayList<Course> getCourseRepository() {
		return courses;
	}

	@Override
	public String toString() {
		return "\nCourses [courses=" + courses + "]";
	}

}
