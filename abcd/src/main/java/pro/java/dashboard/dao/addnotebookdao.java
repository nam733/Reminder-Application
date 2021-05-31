package pro.java.dashboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pro.java.dashboard.model.addnotebookbean;
import pro.java.dashboard.utils.JDBCutils;

public class addnotebookdao {
	public int addnote(addnotebookbean addbook) throws SQLException {
		String query = "INSERT INTO notebooks"
				+ "  (notebookname,reg_id) VALUES "
				+ " (?,?);";

		int result = 0;
		try (Connection connection = JDBCutils.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, addbook.getNotebookname());
			preparedStatement.setInt(2, addbook.getUser_id());

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
