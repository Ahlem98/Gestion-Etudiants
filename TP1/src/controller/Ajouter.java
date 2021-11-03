package controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Gestiondb;
import model.Etudiant;

/**
 * Servlet implementation class Ajouter
 */
public class Ajouter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajouter() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gestiondb dao = new Gestiondb();
		String nom = request.getParameter("nom");
		if (nom != null) {
		String prenom = request.getParameter("prenom");
		int num = Integer.parseInt(request.getParameter("num"));
		String tel = request.getParameter("tel");
		Etudiant e = new Etudiant(num,nom, prenom,tel);
		dao.addEtudiant(e);
		List <Etudiant>listEtudiants=dao.getAllEtudiants();
		request.setAttribute("listEtudiants",listEtudiants);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Liste.jsp");
		dispatcher.forward(request, response);}
		else {
		List <Etudiant>listEtudiants=dao.getAllEtudiants();
		request.setAttribute("listEtudiants",listEtudiants);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Liste.jsp");
		dispatcher.forward(request, response);
	}}

	

}
