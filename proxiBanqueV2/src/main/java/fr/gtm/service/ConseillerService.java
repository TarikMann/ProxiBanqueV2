package fr.gtm.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.gtm.dao.ClientDAO;
import fr.gtm.dao.ConnectionSQL;
import fr.gtm.dao.ConseillerDAO;
import fr.gtm.domaine.Client;
import fr.gtm.domaine.Conseiller;

public class ConseillerService {

	
	
	
	
	// ===================M�thode getConseiller===================
	/**
	 * @param pLogin : login rentr� par l'utilisateur
	 * @param pPassword : mot de passe rentr� par l'utilisateur
	 * @return retourne le Conseiller r�cup�r� depuis la couche DAO. Cette m�thode de la couche service permettra d'acceder � la classe getConseillerSession de la couche DAO.
	 */
	public Conseiller getConseillerSession(String pLogin, String pPassword ) {

		//Declaration des variables locales
		Conseiller conseillerSession = new Conseiller() ;
		ConseillerDAO maRefConseillerDAO = new ConseillerDAO();
		
		//Appel de la couche DAO
		conseillerSession = maRefConseillerDAO.getConseillerSession(pLogin, pPassword);
		
		return conseillerSession;
	}
	// ========================================================
	
	
	// =====================GET ALL CLIENTS D'UN CONSEILLER=====================
	/**
	 * 
	 * @return retourne la liste des clients r�cup�r�s. M�thode permettant de
	 *         r�cup�rer la liste de tous les clients ainsi que les informations de
	 *         ces clients.
	 */
	public List<Client> getCLientsConseiller(Conseiller pConseiller) {
		
		// DECLARATION DES VARIABLES LOCALES
		List<Client> myListClientReturn = new ArrayList<Client>();
		ClientDAO maRefclientDAO = new ClientDAO();
		
		//Appel de la couche DAO
		myListClientReturn = maRefclientDAO.getCLientsConseiller(pConseiller);
		
		return myListClientReturn;
	}
	// ========================================================

	
	
}
