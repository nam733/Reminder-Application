package pro.java.dashboard.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pro.java.dashboard.dao.logindao;

import pro.java.dashboard.model.loginbean;


@WebServlet("/loginn")
public class logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private logindao loginDao;
	

	public void init() {
		loginDao = new logindao();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			authenticate(request, response);
	}

	private void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		loginbean loginBean = new loginbean();
		loginBean.setEmail(email);
		loginBean.setPassword(password);
		PrintWriter out = response.getWriter();
		try {
			int user_id=loginDao.find(email);
			 HttpSession session=request.getSession();
			 session.setAttribute("user_id", user_id);
			 String name=loginDao.findname(user_id);
			 request.setAttribute("username", name);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	     

		try {
			if (loginDao.validate(loginBean)) {
				out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
				 out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
				 out.println("<script>");
				 out.println("$(document).ready(function(){");
				 out.println("swal(\"WELCOME\", \"Login Successfull!\", \"success\"); ");
				 out.println("});");
				 out.println("</script>");
				
				 
				// System.out.print(username);
				 int user_id=loginDao.find(email);
				 HttpSession session=request.getSession();
				 session.setAttribute("user_id", user_id);
				 String name=loginDao.findname(user_id);
				 System.out.println(name);
				 session.setAttribute("name",name);
				 
				 
				 RequestDispatcher dispatcher = request.getRequestDispatcher("notebook.jsp");
					dispatcher.include(request, response);
				
			} else {
				
				out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
				 out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
				 out.println("<script>");
				 out.println("$(document).ready(function(){");
				 out.println("swal(\"ERROR\", \"Invalid Login!\", \"error\"); ");
				 out.println("});");
				 out.println("</script>"); 
				 RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
					dispatcher.include(request, response);
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
