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

/**
 * Servlet implementation class UpdateUtilisationCLientServlet
 */
public class UpdateUtilisationCLientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUtilisationCLientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		
		HttpSession maSession = request.getSession(true);

		Conseiller monConseiller;
		ClientService monServiceClient;
		monServiceClient = new ClientService();
	
		monConseiller = (Conseiller) maSession.getAttribute("monConseillerSession");
		System.out.println("le conseiller :" + monConseiller);
		String idClientSeVal = request.getParameter("idClient");
		int idClientSe = Integer.valueOf(idClientSeVal);
		String nomClientSe = request.getParameter("nomClient");
		String prenomClientSe = request.getParameter("prenomClient");
		String emailClientSe = request.getParameter("emailClient");
		String adresseClientSe = request.getParameter("adresseClient");
		String codePostalClientSe = request.getParameter("codePostalClient");
		String villeClientSe = request.getParameter("villeClient");
		
		Client clientCreer = new Client(prenomClientSe,nomClientSe, adresseClientSe, codePostalClientSe, villeClientSe , emailClientSe);
		clientCreer.setIdClient(idClientSe);
		System.out.println("le nomClientSe :" + clientCreer+ emailClientSe );

	  boolean leretour = monServiceClient.updateClient(clientCreer);
	 System.out.println(leretour);
	 RequestDispatcher dispatcher;
	 if (leretour == true) {
			maSession.setAttribute("erreur", " ");
		 dispatcher = request.getRequestDispatcher("ListerClientServlet");
	 }else {
			maSession.setAttribute("erreur", "Probleme d'ajout du Client.");
		 dispatcher = request.getRequestDispatcher("UpdateClientServlet?id=idClientSe");
	 }
		dispatcher.forward(request, response);
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
