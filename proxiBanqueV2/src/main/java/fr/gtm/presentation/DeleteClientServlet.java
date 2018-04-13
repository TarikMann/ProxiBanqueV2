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
 * Servlet implementation class DeleteClientServlet
 */
public class DeleteClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteClientServlet() {
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
		monClient.setIdClient(idClient);
		monServiceClient = new ClientService();

		boolean monClientBoool = monServiceClient.deleteClient(monClient);

		RequestDispatcher dispatcher;
		if (monClientBoool == true) {
			maSession.setAttribute("erreur", "Le client est bien supprimé");
			dispatcher = request.getRequestDispatcher("ListerClientServlet");
		} else {
			maSession.setAttribute("erreur", "Probleme de suppresion du Client.");
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
