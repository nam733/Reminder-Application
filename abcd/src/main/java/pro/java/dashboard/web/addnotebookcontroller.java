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
import javax.servlet.http.HttpSession;

import pro.java.dashboard.dao.addnotebookdao;
import pro.java.dashboard.model.addnotebookbean;



@WebServlet("/addnotebook")
public class addnotebookcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private addnotebookdao addnotebookDao;

	public void init() {
		addnotebookDao = new addnotebookdao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		add(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String notebookname = request.getParameter("notebookname");
		HttpSession session=request.getSession();
		int user_id = (int) session.getAttribute("user_id");
		//PrintWriter out=response.getWriter();
		
		PrintWriter out = response.getWriter();
	  	/*out.println(name);
		out.println(email_id);
		out.println(username);
		out.println(password);
		out.println(role);*/
                   
		addnotebookbean addbook = new addnotebookbean();
		addbook.setNotebookname(notebookname);
		addbook.setUser_id(user_id);
		
		try {
			int result = addnotebookDao.addnote(addbook);
			if(result==1) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("notebook.jsp");
					dispatcher.include(request, response);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
}
