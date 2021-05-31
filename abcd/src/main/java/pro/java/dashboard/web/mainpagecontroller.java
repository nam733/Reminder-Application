package pro.java.dashboard.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pro.java.dashboard.dao.mainpagedao;
import pro.java.dashboard.model.mainpagebean;
@WebServlet("/mainpage")
public class mainpagecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private mainpagedao mainpageDao;
	
	public void init() {
		mainpageDao = new mainpagedao(); 
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		task(request, response);
	}


	private void task(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		//ServletContext sc = getServletContext();
        //String str = (String) sc.getAttribute("user"); 
		HttpSession session=request.getSession();
		int user_id = (int) session.getAttribute("user_id");
		//List<mainpagebean> task = mainpageDao.display(username);
		//System.out.print(username);
		mainpagebean dash=mainpageDao.display(user_id);
		System.out.print(dash);
		request.setAttribute("dash", dash);
		RequestDispatcher dispatcher = request.getRequestDispatcher("edituser.jsp");
		dispatcher.forward(request, response);
	}
}

