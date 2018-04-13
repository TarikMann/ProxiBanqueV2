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
import fr.gtm.service.ClientService;
import fr.gtm.service.CompteBancaireService;

/**
 * Servlet implementation class AfficherClientServlet
 */
public class AfficherClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AfficherClientServlet() {
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
		HttpSession maSession = request.getSession(true);
		String idCLientString = request.getParameter("idclient");

		int idClient = Integer.parseInt(idCLientString);
		Client monClient;
		ClientService monServiceClient;
		
		monClient = new Client();
		CompteBancaire monCompteBancaire;
		CompteBancaireService monCompteBancaireService;
		
		List<CompteBancaire> laListeDesComptes = new ArrayList<CompteBancaire>();
		
		
		
		monClient.setIdClient(idClient);
		System.out.println(" retour Client : " + monClient);
		monServiceClient = new ClientService();
		monCompteBancaireService = new CompteBancaireService();
		boolean monClientBoool = monServiceClient.getClient(monClient);
		System.out.println(" retour Clientremp : " + monClient);
		RequestDispatcher dispatcher;
		if (monClientBoool == true) {
			maSession.setAttribute("idClient", monClient.getIdClient());
			maSession.setAttribute("nom", monClient.getNom());
			maSession.setAttribute("prenom", monClient.getPrenom());
			maSession.setAttribute("adresse", monClient.getAdresseClient());
			maSession.setAttribute("cdPostal", monClient.getCodePostaleClient());
			maSession.setAttribute("ville", monClient.getVilleClient());
			maSession.setAttribute("email", monClient.getEmailClient());
			
			laListeDesComptes = monCompteBancaireService.getComptesClient( monClient);
			maSession.setAttribute("listeComptes", laListeDesComptes);
		System.out.println(laListeDesComptes);
			maSession.setAttribute("erreur", " ");
			dispatcher = request.getRequestDispatcher("Client/afficher.jsp");
		} else {
			maSession.setAttribute("erreur", "Erreur : Probleme d'affichage des informations client");

			dispatcher = request.getRequestDispatcher("ListerClientServlet");
		}
		dispatcher.forward(request, response);
		// session.setAttribute("age", monClient.getAge());
		// session.setAttribute("adresse", monClient.getAdresse());
		// session.setAttribute("sexe", monClient.getSexe());
		// this.getServletContext().getRequestDispatcher("/AfficherDresseur.jsp").forward(request,
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
