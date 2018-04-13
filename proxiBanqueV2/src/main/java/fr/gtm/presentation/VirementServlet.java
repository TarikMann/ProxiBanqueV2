package fr.gtm.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gtm.domaine.CompteCourant;
import fr.gtm.service.ClientService;

/**
 * Servlet implementation class VirementServlet
 */
public class VirementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VirementServlet() {
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
		
		String valsomme = request.getParameter("SommeVirement");
		String valIdCompteDebiteur = request.getParameter("idCompteDebiteur");
		String valIdCompteEmeteur = request.getParameter("idCompteEmeteur");
		int idCompteDebiteur = Integer.valueOf(valIdCompteDebiteur);
		int idCompteEmeteur = Integer.valueOf(valIdCompteEmeteur);

		CompteCourant monCompteDebiteur;
		CompteCourant monCompteCrediteur;
		ClientService maRefClientService = new ClientService();
		
		
		float somme = Float.valueOf(valsomme);
		monCompteDebiteur = new CompteCourant();
		monCompteCrediteur = new CompteCourant();
		monCompteDebiteur.setIdCompte(idCompteDebiteur);
		monCompteCrediteur.setIdCompte(idCompteEmeteur);

		boolean test = false;
		test = maRefClientService.VirementCompteACompte(monCompteDebiteur, monCompteCrediteur, somme);
		System.out.println("virement compte à compte :" + test);

		 RequestDispatcher dispatcher;
		 if (test == true) {
				maSession.setAttribute("valid", "Virement effectuer.");
			 dispatcher = request.getRequestDispatcher("InitVirementServlet");
		 }else {
				maSession.setAttribute("erreur", "Probleme du Virement.");
			 dispatcher = request.getRequestDispatcher("InitVirementServlet");
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
