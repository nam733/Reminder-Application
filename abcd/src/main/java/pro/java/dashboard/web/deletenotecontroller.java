package pro.java.dashboard.web;

import java.io.IOException;
//import java.io.PrintWriter;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.java.dashboard.dao.deletedao;
import pro.java.dashboard.model.deletebean;


@WebServlet("/deletenote")
public class deletenotecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private deletedao deleteDao;

	public void init() {
		deleteDao = new deletedao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		update(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int noteid = Integer.parseInt(request.getParameter("noteid"));
		
		
		
		PrintWriter out = response.getWriter();
	  	/*out.println(name);
		out.println(email_id);
		out.println(username);
		out.println(password);
		out.println(role);*/
                   
		deletebean user = new deletebean();
		user.setId(noteid);
		
		

		try {
			int res=deleteDao.Employee(user);
			if(res==1) {
				out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
				 out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
				 out.println("<script>");
				 out.println("$(document).ready(function(){");
				 out.println("swal(\"DONE\", \"Deleted Successfully!\", \"success\"); ");
				 out.println("});");
				 out.println("</script>");
					RequestDispatcher dispatcher = request.getRequestDispatcher("notebook.jsp");
					dispatcher.include(request, response);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
}
