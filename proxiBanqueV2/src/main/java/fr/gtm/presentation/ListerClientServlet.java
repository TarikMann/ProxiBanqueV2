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
import fr.gtm.domaine.Conseiller;
import fr.gtm.service.ClientService;
import fr.gtm.service.ConseillerService;

/**
 * Servlet implementation class ListerClient
 */
public class ListerClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListerClientServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());

		// DECLARATION DES VARIABLES LOCALES
		HttpSession maSession = request.getSession(true);
		ClientService monServiceClient;
		ConseillerService monServiceConseiler;
		Conseiller monConseiller;
		monConseiller = (Conseiller) maSession.getAttribute("monConseillerSession");
		monServiceClient = new ClientService();

		// on récupère le conseiller
		String nomConseiller = request.getParameter("monConseillerNom");

		// Declaration List
		List<Client> laListeDesClients = new ArrayList<Client>();
		// Appel service
		laListeDesClients = monServiceClient.getCLientsConseiller(monConseiller);
		
		// HttpSession session = request.getSession();
		maSession.setAttribute("listeClient", laListeDesClients);

		maSession.setAttribute("erreur", " ");
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("Client/index.jsp");
		dispatcher.forward(request, response);



		// this.getServletContext().getRequestDispatcher("/Client/index.jsp").forward(request,
		// response);

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
