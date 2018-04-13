package fr.gtm.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gtm.dao.CompteBancaireDAO;
import fr.gtm.domaine.Client;
import fr.gtm.domaine.CompteBancaire;
import fr.gtm.domaine.CompteCourant;
import fr.gtm.domaine.CompteEpargne;
import fr.gtm.domaine.Conseiller;
import fr.gtm.service.ClientService;
import fr.gtm.service.CompteBancaireService;

/**
 * Servlet implementation class AddCompteServlet
 */
public class AddCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCompteServlet() {
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
		boolean leretour = false;
		Conseiller monConseiller;
		Client monClient;
		CompteBancaireService monServiceCompte;
		monServiceCompte = new CompteBancaireService();
		CompteCourant monCompteCourant;
		CompteEpargne monCompteEpargne;
		monCompteCourant = new CompteCourant();
		monCompteEpargne = new CompteEpargne();
		monClient = new Client();

		monConseiller = (Conseiller) maSession.getAttribute("monConseillerSession");

		String idValClientSe = request.getParameter("IDClient");
		int idClientSe = Integer.valueOf(idValClientSe);
		String typeCompteSe = request.getParameter("typeCompte");
		String SoldevalCompteSe = request.getParameter("SoldeCompte");
		Float SoldeCompteSe = Float.valueOf(SoldevalCompteSe);
		monClient.setIdClient(idClientSe);
		System.out.println(typeCompteSe);
		RequestDispatcher dispatcher;
		if (typeCompteSe.equals("typeCompteEpargne")) {
			monCompteEpargne = new CompteEpargne(SoldeCompteSe, "Epargne", idClientSe);
			leretour = monServiceCompte.creationCompte(monCompteEpargne, monClient);

		} else {
			monCompteCourant = new CompteCourant(SoldeCompteSe, "Courant", idClientSe);
			leretour = monServiceCompte.creationCompte(monCompteCourant, monClient);

		}

		if (leretour == true) {

			dispatcher = request.getRequestDispatcher("ListerClientServlet");
		} else {
			maSession.setAttribute("erreur", "Probleme d'ajout du compte.");
			dispatcher = request.getRequestDispatcher("ListerClientServlet");
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
