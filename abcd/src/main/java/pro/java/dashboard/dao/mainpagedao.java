package pro.java.dashboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pro.java.dashboard.model.addbean;
import pro.java.dashboard.model.editbean;
import pro.java.dashboard.model.mainpagebean;
import pro.java.dashboard.utils.JDBCutils;

public class mainpagedao {

	private static final String DISPLAY="select * from register where id = ?;";
	private static final String DISPLAY1="select * from notebooks where id = ?;";
	private static final String DISPLAY2="select * from note where note_id = ?;";
	
	public mainpagedao() {
	}
	
	public mainpagebean display(int id)
	{
		mainpagebean dash=null;
		//List<mainpagebean> assign = new ArrayList<>();
		try(Connection connection = JDBCutils.getConnection();
				PreparedStatement statement= connection.prepareStatement(DISPLAY);)
		{
			statement.setInt(1, id);
			System.out.println(statement);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String passwordd = rs.getString("psw");
				//System.out.print(name);
				//System.out.print(phone);
				//System.out.print(password);
				//System.out.print(passwordd);
				dash=new mainpagebean(id, name, phone, email, password, passwordd);
			}
		} catch (SQLException exception) {
		JDBCutils.printSQLException(exception);
	}
		return dash;
	}
	
	public editbean selectTodo(int id)
	{
		editbean jash=null;
		//List<mainpagebean> assign = new ArrayList<>();
		try(Connection connection = JDBCutils.getConnection();
				PreparedStatement statements= connection.prepareStatement(DISPLAY1);)
		{
			statements.setInt(1, id);
			System.out.println(statements);
			ResultSet rs = statements.executeQuery();
			while (rs.next()) {
				int idd = rs.getInt("id");
				String name = rs.getString("notebookname");
				//System.out.print(idd);
				//System.out.print(name);
				//System.out.print(phone);
				//System.out.print(password);
				//System.out.print(passwordd);
				jash=new editbean(idd, name);
				//System.out.println(jash);
			}
		} catch (SQLException exception) {
		JDBCutils.printSQLException(exception);
	}
		return jash;
	}
	
	
	public addbean details(int noteid)
	{
		addbean josh=null;
		//List<mainpagebean> assign = new ArrayList<>();
		try(Connection connection = JDBCutils.getConnection();
				PreparedStatement statements= connection.prepareStatement(DISPLAY2);)
		{
			statements.setInt(1, noteid);
			System.out.println(statements);
			ResultSet rs = statements.executeQuery();
			while (rs.next()) {
				String name = rs.getString("note_name"); 
                String startdate = rs.getString("start_date"); 
                String enddate = rs.getString("end_date");
                String reminderdate = rs.getString("reminder_date");
                String status = rs.getString("status");
                String tag = rs.getString("tag");
                String description = rs.getString("description");
                josh=new addbean(noteid, name, startdate, enddate, reminderdate, status, tag, description);
			}
		} catch (SQLException exception) {
		JDBCutils.printSQLException(exception);
	}
		return josh;
	}
	
}
