package com.lms.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.lms.repository.CourseRepositoryJDBC;

public class CourseServiceJDBC {

	public void insertData() {
		CourseRepositoryJDBC repo = new CourseRepositoryJDBC();

		Connection connection = repo.getConnection();

		try {
			Statement statement = connection.createStatement();

			statement.executeUpdate("INSERT into courses values(null, 'C++', 25.7 , current_date(), 'Colt')");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void readData(int courseID) {
		CourseRepositoryJDBC repo = new CourseRepositoryJDBC();

		Connection connection = repo.getConnection();

		Statement statement;
		ResultSet resultSet;
		try {
			statement = connection.createStatement();

			resultSet = statement.executeQuery("select * from courses where course_id = " + courseID);
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			while (resultSet.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					if (i > 1)
						System.out.print(",  ");
					String columnValue = resultSet.getString(i);
					System.out.print(columnValue + " " + rsmd.getColumnName(i));
				}
				System.out.println("");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateData(int courseID) {
		CourseRepositoryJDBC repo = new CourseRepositoryJDBC();

		Connection connection = repo.getConnection();

		Statement statement;
		try {
			statement = connection.createStatement();

			statement.executeUpdate("update courses set instructor_name = 'Matthew' where course_id = " + courseID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteData(int courseID) {

		CourseRepositoryJDBC repo = new CourseRepositoryJDBC();

		Connection connection = repo.getConnection();

		try {
			Statement statement = connection.createStatement();

			statement.executeUpdate("delete from courses where course_id = " + courseID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
