package pro.java.dashboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import pro.java.dashboard.model.registerbean;
import pro.java.dashboard.utils.JDBCutils;

public class registerdao {
	public int registerEmployee(registerbean employee) throws SQLException {
		String query = "INSERT INTO register"
				+ "  (name, phone, email, password, psw) VALUES "
				+ " (?, ?, ?, ?, ?);";

		int result = 0;
		try (Connection connection = JDBCutils.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getPhone());
			preparedStatement.setString(3, employee.getEmail());
			preparedStatement.setString(4, employee.getPassword());
			preparedStatement.setString(5, employee.getPasswordd());
			

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
