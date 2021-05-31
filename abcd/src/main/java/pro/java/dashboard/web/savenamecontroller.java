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
import pro.java.dashboard.dao.updatedao;
import pro.java.dashboard.model.editbean;
import pro.java.dashboard.model.registerbean;
import pro.java.dashboard.model.updatebean;


@WebServlet("/savename")
public class savenamecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private updatedao updateDao;

	public void init() {
		updateDao = new updatedao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		update(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("signup.jsp");
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
	
		PrintWriter out = response.getWriter();
	  	/*out.println(name);
		out.println(email_id);
		out.println(username);
		out.println(password);
		out.println(role);*/
                   
		editbean user = new editbean();
		user.setName(name);
		user.setId(id);
		

		try {
			int result = updateDao.registerEmployee(user);
			if(result==1) {
				out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
				 out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
				 out.println("<script>");
				 out.println("$(document).ready(function(){");
				 out.println("swal(\"DONE\", \"updated Successfully!\", \"success\"); ");
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
