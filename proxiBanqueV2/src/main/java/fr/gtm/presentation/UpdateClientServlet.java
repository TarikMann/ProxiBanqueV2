package fr.gtm.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gtm.domaine.Client;
import fr.gtm.service.ClientService;

/**
 * Servlet implementation class UpdateClientServlet
 */
public class UpdateClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateClientServlet() {
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
		String idCLientString = request.getParameter("idclient");

		int idClient = Integer.parseInt(idCLientString);
		Client monClient;
		ClientService monServiceClient;
		monClient = new Client();
		monClient.setIdClient(idClient);
		monServiceClient = new ClientService();

		boolean monClientBoool = monServiceClient.getClient(monClient);
		RequestDispatcher dispatcher;
		if (monClientBoool == true) {
			maSession.setAttribute("idClient", monClient.getIdClient());
			maSession.setAttribute("nom", monClient.getNom());
			maSession.setAttribute("prenom", monClient.getPrenom());
			maSession.setAttribute("adresse", monClient.getAdresseClient());
			maSession.setAttribute("cdPostal", monClient.getCodePostaleClient());
			maSession.setAttribute("ville", monClient.getVilleClient());
			maSession.setAttribute("email", monClient.getEmailClient());
			
			
		
			maSession.setAttribute("erreur", " ");
			dispatcher = request.getRequestDispatcher("Client/update.jsp");
		} else {
			maSession.setAttribute("erreur", "Erreur : Probleme de modification du client");

			dispatcher = request.getRequestDispatcher("ListerClientServlet");
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
