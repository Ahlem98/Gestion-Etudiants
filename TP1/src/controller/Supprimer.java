package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Etudiant;

import dao.Gestiondb;

/**
 * Servlet implementation class Supprimer
 */
public class Supprimer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gestiondb dao = new Gestiondb();
		int num = Integer.parseInt(request.getParameter("num"));		
		dao.deletEtudiant(num);
		List <Etudiant>listEtudiants=dao.getAllEtudiants();
		request.setAttribute("listEtudiants",listEtudiants);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Liste.jsp");
		dispatcher.forward(request, response);
	}

}