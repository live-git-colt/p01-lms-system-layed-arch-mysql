package com.lms.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.lms.model.Course;
import com.lms.repository.CourseRepository;

public class CourseService {

	static File courseData;

	public static void saveCourseData(ArrayList<Course> courses) {

		// Create file courses.dat
		courseData = new File("Courses.dat");
		try {
			// Create object stream and write passed in objects to the file
			FileOutputStream fOutput = new FileOutputStream(courseData);
			ObjectOutputStream oOutput = new ObjectOutputStream(fOutput);

			oOutput.writeObject(courses);

			// close resources
			fOutput.close();
			oOutput.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Method for finding the matching courseID
	public static void findCourse(int courseID) {

		// Read the file to retrieve data
		try {
			FileInputStream fInput = new FileInputStream("Courses.dat");
			ObjectInputStream oInput = new ObjectInputStream(fInput);

			ArrayList<Course> courseRead = (ArrayList<Course>) oInput.readObject();

			// Print out the data that matches the query
			for (Course course : courseRead) {
				if (courseID == course.getCourseID()) {
					// Prove that it was found
					System.out.println(course.toString());
				}
			}

			// close resources
			fInput.close();
			oInput.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Method to delete a Course from the array list and file
	public static void deleteCourse(int courseID, ArrayList<Course> courses) {

		// Create an iterator to loop over the array list
		for (Iterator<Course> iterator = courses.iterator(); iterator.hasNext();) {

			Course course = iterator.next();

			// If the courseID at the current iterator location matches the courseID passed
			// in remove it
			if (course.getCourseID() == courseID) {
				iterator.remove();

			}
		}
		// Save over the file with the matching indexes removed
		saveCourseData(courses);
	}

	// Method to change a course currently in the file
	public static void updateCourse(int courseID) {
		// Created a new date instead of passing one in
		Date date = new Date();

		// Simulate user input with hardcoded data
		Course updatedCourse = new Course(courseID, "C++", 23.7f, date, "Bob");

		// Call delete method so no duplicates exist
		deleteCourse(courseID, CourseRepository.getCourseRepository());

		// Add the new course to the arraylist
		CourseRepository.addCourse(updatedCourse);

		// Save the data to the file
		saveCourseData(CourseRepository.getCourseRepository());

	}
}
