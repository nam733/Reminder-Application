package pro.java.dashboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pro.java.dashboard.model.loginbean;
import pro.java.dashboard.model.registerbean;
import pro.java.dashboard.utils.JDBCutils;

public class logindao {

	public boolean validate(loginbean loginBean) throws ClassNotFoundException {
		boolean status = false;

		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = JDBCutils.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from register where email = ? and password = ? ")) {
			preparedStatement.setString(1, loginBean.getEmail());
			preparedStatement.setString(2, loginBean.getPassword());

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();

		} catch (SQLException e) {
			// process sql exception
			JDBCutils.printSQLException(e);
		}
		return status;
	}
	
	public int find(String email) throws SQLException {
		int result = 0;
		try (Connection connection = JDBCutils.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement("select * from register where email = ?")) {
			preparedStatement.setString(1, email);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				result=rs.getInt("id");
			}

		} catch (SQLException e) {
			// process sql exception
			JDBCutils.printSQLException(e);
		}
		return result;
	}
	public String findname(int user_id) throws SQLException {
		String result="";
		try (Connection connection = JDBCutils.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement("select * from register where id = ?")) {
			preparedStatement.setInt(1, user_id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				result=rs.getString("name");
			}

		} catch (SQLException e) {
			// process sql exception
			JDBCutils.printSQLException(e);
		}
		return result;
	}
	
	
}
