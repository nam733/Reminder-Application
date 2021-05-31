package pro.java.dashboard.web;

import java.io.IOException;
//import java.io.PrintWriter;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
//import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.java.dashboard.dao.mainpagedao;
import pro.java.dashboard.dao.registerdao;
import pro.java.dashboard.dao.updatedao;
import pro.java.dashboard.model.editbean;
import pro.java.dashboard.model.registerbean;
import pro.java.dashboard.model.updatebean;


@WebServlet("/display")
public class displaynotescontroller extends HttpServlet {
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
		edit(request, response);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		//editbean todo = mainpageDao.selectTodo(id);
		//System.out.print(todo);
		ServletContext sc = getServletContext();
		sc.setAttribute("book_id", id);
        //request.setAttribute("book_id", id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("notes.jsp");
		dispatcher.forward(request, response);
		
	}
}
