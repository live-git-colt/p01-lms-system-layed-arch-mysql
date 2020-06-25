package com.lms;

import java.util.Date;

import com.lms.model.Course;
import com.lms.repository.CourseRepository;
import com.lms.service.CourseService;

public class LMSApplication {
	public static void main(String args[]) {

		Date date = new Date();

		// HARDCODED DATA to simulate user input
		Course course1 = new Course(1, "HTML", 75.9f, date, "Anna");
		Course course2 = new Course(2, "Python", 99.9f, date, "Bobert");
		Course course3 = new Course(3, "Advanced Java", 86.9f, date, "Subra");

		// Adding courses to a collection
		CourseRepository.addCourse(course1);
		CourseRepository.addCourse(course2);
		CourseRepository.addCourse(course3);

		// Write Data to a file "Courses.dat"
		CourseService.saveCourseData(CourseRepository.getCourseRepository());

		// Get a course from the file whose course ID matches the input courseID
		CourseService.findCourse(1);

		// Delete a course from the file whose course ID matches the input courseID and
		// show the course is now removed
		CourseService.deleteCourse(1, CourseRepository.getCourseRepository());

		// This method works by deleting the previous instance at the specified courseID
		// and getting user input for a new Course with the same ID
		CourseService.updateCourse(2);

		// COPY AND PASTE THIS LINE FOR TESTING
		// System.out.println(CourseRepository.getCourseRepository());
	}

}
