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

import pro.java.dashboard.dao.registerdao;
import pro.java.dashboard.model.registerbean;


@WebServlet("/register")
public class usercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private registerdao registerDao;

	public void init() {
		registerDao = new registerdao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		register(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("signup.jsp");
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String password = request.getParameter("psw");
		String passwordd = request.getParameter("psww");
		//PrintWriter out=response.getWriter();
		
		PrintWriter out = response.getWriter();
	  	/*out.println(name);
		out.println(email_id);
		out.println(username);
		out.println(password);
		out.println(role);*/
                   
		registerbean employee = new registerbean();
		employee.setName(name);
		employee.setPhone(phone);
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setPasswordd(passwordd);
		

		try {
			int result = registerDao.registerEmployee(employee);
			if(result==1) {
				out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
				 out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
				 out.println("<script>");
				 out.println("$(document).ready(function(){");
				 out.println("swal(\"DONE\", \"Registered Successfully!\", \"success\"); ");
				 out.println("});");
				 out.println("</script>");
					RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
					dispatcher.include(request, response);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
}
