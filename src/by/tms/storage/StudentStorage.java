package by.tms.storage;

import by.tms.domain.Student;

import java.sql.*;

public class StudentStorage {

	public void updateStudentById (long id , Student student) {
		Connection connection = null;
			try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
			PreparedStatement preparedStatement = connection.prepareStatement("update studentbase set login = ?, password = ?, name = ?, faculty = ?, groupa = ? where id = ?");
			preparedStatement.setString(1, student.getLogin());
			preparedStatement.setString(2, student.getPassword());
			preparedStatement.setString(3, student.getPassword());
			preparedStatement.setString(4, student.getFaculty());
			preparedStatement.setString(5, student.getGroup());
			preparedStatement.setLong(6, id);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updatePasswordById (long id , String password) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
			PreparedStatement preparedStatement = connection.prepareStatement("update studentbase set password = ? where id = ?");
			preparedStatement.setString(1, password);
			preparedStatement.setLong(2, id);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateNameById (long id , String name) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
			PreparedStatement preparedStatement = connection.prepareStatement("update studentbase set name = ? where id = ?");
			preparedStatement.setString(1, name);
			preparedStatement.setLong(2, id);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateFacultyById (long id , String faculty) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
			PreparedStatement preparedStatement = connection.prepareStatement("update studentbase set faculty = ? where id = ?");
			preparedStatement.setString(1, faculty);
			preparedStatement.setLong(2, id);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateGroupById (long id , String groupa) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
			PreparedStatement preparedStatement = connection.prepareStatement("update studentbase set groupa = ? where id = ?");
			preparedStatement.setString(1, groupa);
			preparedStatement.setLong(2, id);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
