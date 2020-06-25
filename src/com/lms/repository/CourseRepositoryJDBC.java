package com.lms.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CourseRepositoryJDBC {

	private Connection connection;

	public Connection getConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "root");
			return connection;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}