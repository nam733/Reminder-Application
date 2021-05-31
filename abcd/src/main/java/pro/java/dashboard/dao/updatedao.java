package pro.java.dashboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pro.java.dashboard.model.addbean;
import pro.java.dashboard.model.deletebean;
import pro.java.dashboard.model.editbean;
import pro.java.dashboard.model.updatebean;
import pro.java.dashboard.utils.JDBCutils;

public class updatedao {
	public int registerEmployee(updatebean user) throws SQLException {
		String query = "update register set name = ?,phone = ?,password = ?,psw = ? where email = ?;";

		int result = 0;
		try (Connection connection = JDBCutils.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPhone());
			//preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getPasswordd());
			preparedStatement.setString(5, user.getEmail());

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// process sql exception
			JDBCutils.printSQLException(e);
		}
		return result;
	}
	
	public int registerEmployee(editbean user) throws SQLException {
		String query = "update notebooks set notebookname = ? where id = ?;";

		int result = 0;
		try (Connection connection = JDBCutils.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setInt(2, user.getId());
			
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// process sql exception
			JDBCutils.printSQLException(e);
		}
		return result;
	}
	
	public int registerEmployee(addbean user) throws SQLException {
		String query = "update note set note_name = ?,start_date = ?,end_date = ?,reminder_date = ?,status = ?,tag = ?,description = ? where note_id = ?;";

		int result = 0;
		try (Connection connection = JDBCutils.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getStartdate());
			//preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(3, user.getEnddate());
			preparedStatement.setString(4, user.getReminderdate());
			preparedStatement.setString(5, user.getStatus());
			preparedStatement.setString(6, user.getTag());
			preparedStatement.setString(7, user.getDescription());
			preparedStatement.setInt(8, user.getId());

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
