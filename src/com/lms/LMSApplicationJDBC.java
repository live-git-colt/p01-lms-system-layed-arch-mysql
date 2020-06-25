package com.lms;

import java.sql.SQLException;

import com.lms.repository.CourseRepositoryJDBC;
import com.lms.service.CourseServiceJDBC;

public class LMSApplicationJDBC {

	public static void main(String[] args) {

		CourseRepositoryJDBC connection = new CourseRepositoryJDBC();
		CourseServiceJDBC service = new CourseServiceJDBC();

		service.readData(2);

		service.insertData();

		service.deleteData(4);

		service.updateData(3);

		try {
			connection.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
