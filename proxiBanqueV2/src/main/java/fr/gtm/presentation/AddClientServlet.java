package fr.gtm.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gtm.domaine.Client;
import fr.gtm.domaine.Conseiller;
import fr.gtm.service.ClientService;
import fr.gtm.service.ConseillerService;

/**
 * Servlet implementation class AddClientServlet
 */
public class AddClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddClientServlet() {
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
		response.getWriter().append("Served at ????: ").append(request.getContextPath());
		HttpSession maSession = request.getSession(true);

		Conseiller monConseiller;
		ClientService monServiceClient;
		monServiceClient = new ClientService();

		monConseiller = (Conseiller) maSession.getAttribute("monConseillerSession");

		String nomClientSe = request.getParameter("nomClient");
		String prenomClientSe = request.getParameter("prenomClient");
		String emailClientSe = request.getParameter("emailClient");
		String adresseClientSe = request.getParameter("adresseClient");
		String codePostalClientSe = request.getParameter("codePostalClient");
		String villeClientSe = request.getParameter("villeClient");

		Client clientCreer = new Client(prenomClientSe, nomClientSe, adresseClientSe, codePostalClientSe, villeClientSe,
				emailClientSe);

		boolean leretour = monServiceClient.creationClient(clientCreer, monConseiller);
		RequestDispatcher dispatcher;
		if (leretour == true) {

			dispatcher = request.getRequestDispatcher("ListerClientServlet");
		} else {
			maSession.setAttribute("erreur", "Probleme d'ajout du Client.");
			dispatcher = request.getRequestDispatcher("AddClientServlet");
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
