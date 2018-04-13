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

	
	// ========== Méthodes create Comptes Client Service============
	
	/**
	 * @param pCompte : correspond au compte que l'on souhait eenregistrer en bdd.
	 * @param pClient : correspond au client qui possède ce compte.
	 * @return true si la requete en bdd ne retourne pas d'exception.
	 * 
	 * Méthode permettant de créer un compte lié à un client en bdd à partir de l'id du client.
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
	
	
	// ========== Méthodes get Comptes Client Service============
	/**
	 * 
	 * @return myListComptesReturn : correspond à la liste des comptes retournée par la BDD. 
	 * Cette méthode permet d'accerder à la méthode getAllComptes de la couche dao.
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
	
	
	// ========== Méthodes get Comptes Client Service============
	/**
	 *
	 * @param pClient
	 *            : client lié au compte enregistré
	 * @return myListComptesReturn : correspond à la liste des comptes liés à un client.
	 * Cette méthode permet d'accerder à la méthode getComptesClient de la couche dao.
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
	
	
	// ========== Méthodes update Compte Service============
	/**
	 *
	 * @param pCompte : correspond au compte à modifier.
	 * @return true si la méthode updateCompte de la couche DAO return true, false sinon
	 * Cette méthode permet d'accerder à la méthode updateCompte de la couche dao.
	 */
	public boolean updateCompte(CompteBancaire pCompte) {

		// DECLARATION DES VARIABLES
		CompteBancaireDAO maDAOCompte = new CompteBancaireDAO();
		
		//APPEL DE LA COUCHE DAO

		return maDAOCompte.updateCompte(pCompte);
	}
	// ========================================================
	
	
	// ========== Méthodes delete Compte Service============
	/**
	 *
	 * @param pCompte : correspond au compte à supprimer.
	 * @return true si la méthode deleteCompte de la couche DAO return true, false sinon
	 * Cette méthode permet d'accerder à la méthode deleteCompte de la couche dao.
	 */
	public boolean deleteCompte(CompteBancaire pCompte) {

		// DECLARATION DES VARIABLES
		CompteBancaireDAO maDAOCompte = new CompteBancaireDAO();
		
		//APPEL DE LA COUCHE DAO
		
		return maDAOCompte.deleteCompte(pCompte);
	}
	// ========================================================
	
	// ========== Méthodes get Compte Service============
	/**
	 * @param pCompte : correspond  au compte dont on souhaite récupérer les informations (contient l'id client)
	 * @return retourne true si la requete bdd ne retourne pas d'exception, false
	 *         sinon.
	 * 
	 *         Méthode permettant de récupérer les informations d'un objet Compte
	 *         à partir de son id.
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
