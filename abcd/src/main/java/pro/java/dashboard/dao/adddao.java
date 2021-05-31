package pro.java.dashboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pro.java.dashboard.model.addbean;
import pro.java.dashboard.utils.JDBCutils;

public class adddao {
	public int registerEmployee(addbean employee) throws SQLException {
		String query = "INSERT INTO note"
				+ "  (note_name, start_date, end_date, reminder_date, status, tag, description, notebook_id, reg_id) VALUES "
				+ " (?, ?, ?, ?, ?, ?, ?, ?, ?);";

		int result = 0;
		try (Connection connection = JDBCutils.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getStartdate());
			preparedStatement.setString(3, employee.getEnddate());
			preparedStatement.setString(4, employee.getReminderdate());
			preparedStatement.setString(5, employee.getStatus());
			preparedStatement.setString(6, employee.getTag());
			preparedStatement.setString(7, employee.getDescription());
			preparedStatement.setInt(8, employee.getId());
			preparedStatement.setInt(9, employee.getUser_id());
			

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// process sql exception
			JDBCutils.printSQLException(e);
		}
		return result;
	}
	
	
	
}
