package fr.gtm.presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gtm.domaine.Client;
import fr.gtm.domaine.CompteBancaire;
import fr.gtm.service.CompteBancaireService;

/**
 * Servlet implementation class InitVirementClientServlet
 */
public class InitVirementClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InitVirementClientServlet() {
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
		response.getWriter().append("Served at:dsdsdsd ").append(request.getContextPath());

		HttpSession maSession = request.getSession(true);

		CompteBancaireService maRefCompteBancaireService = new CompteBancaireService();
		String idCLientString = request.getParameter("idclient");

		int idClients = Integer.parseInt(idCLientString);
		Client monClient;

		monClient = new Client();
		monClient.setIdClient(idClients);

		List<CompteBancaire> laListeDesComptes = new ArrayList<CompteBancaire>();
		laListeDesComptes = maRefCompteBancaireService.getComptesClient(monClient);

		maSession.setAttribute("listeComptes", laListeDesComptes);
		maSession.setAttribute("listeComptesCrediteur", laListeDesComptes);
		maSession.setAttribute("listeComptesDebiteur", laListeDesComptes);
		maSession.setAttribute("erreur", " ");
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("virement.jsp");
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
