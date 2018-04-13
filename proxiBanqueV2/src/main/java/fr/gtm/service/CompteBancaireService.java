package fr.gtm.service;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.gtm.dao.ClientDAO;
import fr.gtm.dao.CompteBancaireDAO;
import fr.gtm.dao.ConnectionSQL;
import fr.gtm.domaine.Client;
import fr.gtm.domaine.CompteBancaire;
import fr.gtm.domaine.CompteCourant;
import fr.gtm.domaine.CompteEpargne;

public class CompteBancaireService {

	
	// ========== M�thodes create Comptes Client Service============
	
	/**
	 * @param pCompte : correspond au compte que l'on souhait eenregistrer en bdd.
	 * @param pClient : correspond au client qui poss�de ce compte.
	 * @return true si la requete en bdd ne retourne pas d'exception.
	 * 
	 * M�thode permettant de cr�er un compte li� � un client en bdd � partir de l'id du client.
	 */
	public boolean creationCompte(CompteCourant pCompte, Client pClient) {
		
		//DECLARATION DES VARIABLES LOCALES
		CompteBancaireDAO maDAOCompte = new CompteBancaireDAO();
		
		//APPEL DE LA COUCHE  DAO
		return maDAOCompte.creationCompte(pCompte, pClient);
	}
	public boolean creationCompte(CompteEpargne pCompte, Client pClient) {
		
		//DECLARATION DES VARIABLES LOCALES
		CompteBancaireDAO maDAOCompte = new CompteBancaireDAO();
		
		//APPEL DE LA COUCHE  DAO
		return maDAOCompte.creationCompte(pCompte, pClient);
		
	}
	// ========================================================
	
	
	// ========== M�thodes get Comptes Client Service============
	/**
	 * 
	 * @return myListComptesReturn : correspond � la liste des comptes retourn�e par la BDD. 
	 * Cette m�thode permet d'accerder � la m�thode getAllComptes de la couche dao.
	 */
	public ArrayList<CompteBancaire> getAllComptes() {

		// DECLARATION DES VARIABLES
		ArrayList<CompteBancaire> myListComptesReturn = new ArrayList <CompteBancaire>();
		CompteBancaireDAO maDAOCompte = new CompteBancaireDAO();
		
		//APPEL DE LA COUCHE DAO
		myListComptesReturn = maDAOCompte.getAllComptes();
		
		return myListComptesReturn;
	}
	// ========================================================
	
	
	// ========== M�thodes get Comptes Client Service============
	/**
	 *
	 * @param pClient
	 *            : client li� au compte enregistr�
	 * @return myListComptesReturn : correspond � la liste des comptes li�s � un client.
	 * Cette m�thode permet d'accerder � la m�thode getComptesClient de la couche dao.
	 */
	public ArrayList<CompteBancaire> getComptesClient(Client pClient) {

		// DECLARATION DES VARIABLES
		ArrayList<CompteBancaire> myListComptesReturn = new ArrayList <CompteBancaire>();
		CompteBancaireDAO maDAOCompte = new CompteBancaireDAO();
		
		//APPEL DE LA COUCHE DAO
		myListComptesReturn = maDAOCompte.getComptesClient(pClient);
		
		return myListComptesReturn;
	}
	// ========================================================
	
	
	// ========== M�thodes update Compte Service============
	/**
	 *
	 * @param pCompte : correspond au compte � modifier.
	 * @return true si la m�thode updateCompte de la couche DAO return true, false sinon
	 * Cette m�thode permet d'accerder � la m�thode updateCompte de la couche dao.
	 */
	public boolean updateCompte(CompteBancaire pCompte) {

		// DECLARATION DES VARIABLES
		CompteBancaireDAO maDAOCompte = new CompteBancaireDAO();
		
		//APPEL DE LA COUCHE DAO

		return maDAOCompte.updateCompte(pCompte);
	}
	// ========================================================
	
	
	// ========== M�thodes delete Compte Service============
	/**
	 *
	 * @param pCompte : correspond au compte � supprimer.
	 * @return true si la m�thode deleteCompte de la couche DAO return true, false sinon
	 * Cette m�thode permet d'accerder � la m�thode deleteCompte de la couche dao.
	 */
	public boolean deleteCompte(CompteBancaire pCompte) {

		// DECLARATION DES VARIABLES
		CompteBancaireDAO maDAOCompte = new CompteBancaireDAO();
		
		//APPEL DE LA COUCHE DAO
		
		return maDAOCompte.deleteCompte(pCompte);
	}
	// ========================================================
	
	// ========== M�thodes get Compte Service============
	/**
	 * @param pCompte : correspond  au compte dont on souhaite r�cup�rer les informations (contient l'id client)
	 * @return retourne true si la requete bdd ne retourne pas d'exception, false
	 *         sinon.
	 * 
	 *         M�thode permettant de r�cup�rer les informations d'un objet Compte
	 *         � partir de son id.
	 */
	public boolean getCompte(CompteBancaire pCompte) {
		// TODO Auto-generated method stub
		// DECLARATION DES VARIABLES LOCALES
		CompteBancaireDAO maRefcompteDAO = new CompteBancaireDAO();

		// appel de la couche DAO
		return maRefcompteDAO.getCompte(pCompte);
	}
	// ========================================================
	
}
