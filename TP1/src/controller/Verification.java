package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Etudiant;

import dao.Gestiondb;

/**
 * Servlet implementation class Verification
 */
public class Verification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String mp =request.getParameter("password");
		
		
		Gestiondb dao = new Gestiondb();
		
		if (dao.verif(user,mp)==true) {
			
			request.getRequestDispatcher("Liste.jsp").forward(request, response) ;
			
		}
		
		else {
			response.sendRedirect("Authentification.jsp");
		}
	}

}
/*HttpSession session= request.getSession();
			session.setAttribute("username",user);
			*/
