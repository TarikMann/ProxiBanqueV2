package fr.gtm.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gtm.domaine.Conseiller;
import fr.gtm.service.ConseillerService;

/**
 * Servlet implementation class IdentificationServlet
 */

//@WebServlet("/IdentificationServlet")
public class IdentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IdentificationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ConseillerService monServiceConseiller = new ConseillerService();
		Conseiller monConseiller = null;
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String logConseiller = request.getParameter("logConseiller");
		String psswrdConseiller = request.getParameter("psswrdConseiller");
		monConseiller = monServiceConseiller.getConseillerSession(logConseiller, psswrdConseiller);
		HttpSession maSession = request.getSession();


		RequestDispatcher dispatcher;

		
		if (monConseiller.getIdConseiller() >= 0) {
		maSession.setAttribute("monConseillerSession", monConseiller);
			maSession.setAttribute("monConseillerIdS", monConseiller.getIdConseiller());
//			maSession.setAttribute("monConseillerNom", monConseiller.getNom());
//			maSession.setAttribute("monConseillerPrenom", monConseiller.getPrenom());
			maSession.setAttribute("erreur", " ");
			dispatcher = request.getRequestDispatcher("index.jsp");

		} else {
			maSession.setAttribute("erreur", "Erreur : Login et Password erroné  << Essayer a nouveau>>");
			
			dispatcher = request.getRequestDispatcher("login.jsp");

		}
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
