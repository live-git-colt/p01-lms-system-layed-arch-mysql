package com.lms.model;

import java.io.Serializable;
import java.util.Date;

//MUST IMPLEMENT SERIALIZABLE TO WRITE TO A FILE
public class Course implements Serializable {
	// The fields of each course
	private int courseID;
	private String name;
	private float price;
	private Date date;
	private String instructor;

	// For initializing a course
	public Course(int courseID, String name, float price, Date date, String instructor) {
		this.courseID = courseID;
		this.name = name;
		this.price = price;
		this.date = date;
		this.instructor = instructor;
	}

	// For initializing a blank course
	// ***Can possibly delete later
	public Course() {

	}

	// For formatting sysout output
	@Override
	public String toString() {
		return "Course [courseID=" + courseID + ", name=" + name + ", price=" + price + ", date=" + date
				+ ", instructor=" + instructor + "]";
	}

	// Does what you think
	public int getCourseID() {
		return courseID;
	}

}