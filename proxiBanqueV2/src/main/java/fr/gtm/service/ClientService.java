package fr.gtm.service;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.gtm.dao.ClientDAO;
import fr.gtm.dao.CompteBancaireDAO;
import fr.gtm.dao.ConnectionSQL;
import fr.gtm.domaine.Client;
import fr.gtm.domaine.CompteBancaire;
import fr.gtm.domaine.Conseiller;

public class ClientService {

	// =====================GET ALL CLIENTS D'UN CONSEILLER=====================
	/**
	 * @param pConseiller
	 *            : correspond au conseiller identifier en session.
	 * @return retourne la liste des clients r�cup�r�s. M�thode permettant de
	 *         r�cup�rer la liste de tous les clients ainsi que les informations de
	 *         ces clients.
	 */
	public List<Client> getCLientsConseiller(Conseiller pConseiller) {

		// DECLARATION DES VARIABLES LOCALES
		List<Client> myListClientReturn = new ArrayList<Client>();
		ClientDAO maRefclientDAO = new ClientDAO();

		// Appel de la couche DAO
		myListClientReturn = maRefclientDAO.getCLientsConseiller(pConseiller);

		return myListClientReturn;
	}
	// ========================================================

	// =====================GET CLIENT SERVICE=====================
	/**
	 * @param pClient
	 *            : correspond au client dont on souhaite r�cup�rer les informations
	 *            (contient l'id client)
	 * @return retourne true si la requete bdd lors de l'appel � la couche dao ne
	 *         retourne pas d'exception, false sinon.
	 * 
	 *         M�thode permettant de r�cup�rer les informations d'un objet client �
	 *         partir de son id.
	 */
	public boolean getClient(Client pClient) {
		// DECLARATION DES VARIABLES LOCALES
		ClientDAO maRefclientDAO = new ClientDAO();

		// appel de la couche DAO
		return maRefclientDAO.getClient(pClient);
	}
	// ==============================================================

	// =====================CREATE CLIENT SERVICE=====================
	/**
	 * @paramp Client : correspond � l'objet Client contenant les informations
	 *         rentr�es dans le formulaire.
	 * @param pConseiller
	 *            : correspond au conseiller identifier en session.
	 * @return retourne true si la requete bdd ne retoune pas d'exception (erreur).
	 *         M�thode permettant de cr�er un objet Client en bdd. il est necessaire
	 *         d'avoir egalement le conseiller mis en session.
	 */
	public boolean creationClient(Client pClient, Conseiller pConseiller) {
		// DECLARATION DES VARIABLES LOCALES
		ClientDAO maRefclientDAO = new ClientDAO();

		// appel de la couche DAO
		return maRefclientDAO.creationClient(pClient, pConseiller);
	}
	// ===============================================================

	// =====================UPDATE CLIENT SERVICE=====================
	/**
	 * @paramp pClient : correspond � l'objet Client contenant les nouvelles
	 *         informations rentr�es dans le formulaire
	 * @return retourne true si la requete bdd ne retoune pas d'exception (erreur).
	 *         M�thode permettant de modifier les informations d'un objet client
	 *         dans la base de donn�e � partir de son id.
	 */
	public boolean updateClient(Client pClient) {
		// DECLARATION DES VARIABLES LOCALES
		ClientDAO maRefclientDAO = new ClientDAO();

		// appel de la couche DAO
		return maRefclientDAO.updateClient(pClient);
	}
	// ==========================================================================

	// ========================= Delete CLIENT SERVICE ==========================
	/**
	 * 
	 * @return retourne true si la requete bdd ne retoune pas d'exception (erreur).
	 * 
	 *         M�thode permettant de supprimer un objet client existant de la base
	 *         de donn�e � partir de son id. Cette m�thode supprime egalement les
	 *         comptes associ�s � ce client. Un client ne pourra �tre supprim�
	 *         seulement si la r�ponse bdd de la requ�te "suppression compte" ne
	 *         retourne pas d'exception.
	 */
	public boolean deleteClient(Client pClient) {
		// DECLARATION DES VARIABLES LOCALES
		ClientDAO maRefclientDAO = new ClientDAO();
		CompteBancaireService monServiceCompte = new CompteBancaireService();
		CompteBancaireDAO maDAOCompte = new CompteBancaireDAO();
		boolean testDeleteComptes = false;
		ArrayList<CompteBancaire> myListComptesReturn = new ArrayList<CompteBancaire>();

		// On r�cup�re la liste des comptes du client
		myListComptesReturn = monServiceCompte.getComptesClient(pClient);

		if (myListComptesReturn.size() == 0) {
			// Suppression du client
			return maRefclientDAO.deleteClient(pClient);
		}

		// Suppession des comptes associ�s aux clients : appel de la couche DAO
		if (maDAOCompte.deleteCompte(pClient)) {
			// Suppression du client
			return maRefclientDAO.deleteClient(pClient);
		}
		return false;

	}
	// ========================================================

	// ========================= Virement compte � compte ==========================
	/**
	 * @param pCompteDebiteur
	 *            : correspond au compte d�biteur.
	 * @param pCompteCrediteur
	 *            : correspond au compte crediteur.
	 * @param psomme
	 *            : correspond au montant de la transaction.
	 * @return retourne true si toutes les requetes bdd ( gat compte ou update
	 *         compte ) ne retounent pas d'exception (erreur). False sinon.
	 * 
	 *         M�thode permettant de r�aliser un virement de compte � compte.
	 */
	public boolean VirementCompteACompte(CompteBancaire pCompteDebiteur, CompteBancaire pCompteCrediteur,
			float pSomme) {

		// DECLARATION DES VARIABLES LOCALES
		ClientDAO maRefClientDAO = new ClientDAO();
		CompteBancaireService maRefCompteService = new CompteBancaireService();
		CompteBancaireDAO maDAOCompte = new CompteBancaireDAO();

		// Onrecup�re les informations des comptes avec un getCompte : appel couche
		// compteservice.
		if (maRefCompteService.getCompte(pCompteDebiteur) && maRefCompteService.getCompte(pCompteCrediteur)) {
			// Modification des soldes des comptes.
			this.transactionVirement(pCompteDebiteur, pCompteCrediteur, pSomme);
			// update bdd des compte : appel couche service
			if (maRefCompteService.updateCompte(pCompteDebiteur) && maRefCompteService.updateCompte(pCompteCrediteur)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	// =========================================================================

	// ========================= Transaction Virement ==========================
	/**
	 * @param pCompteDebiteur
	 *            : correspond au compte d�biteur.
	 * @param pCompteCrediteur
	 *            : correspond au compte crediteur.
	 * @param psomme
	 *            : correspond au montant de la transaction.
	 * @return retourne true si toutes les requetes bdd ( get compte ou update
	 *         compte ) ne retounent pas d'exception (erreur). False sinon.
	 * 
	 *         M�thode permettant de r�aliser la transation d'un virement
	 *         (modification de la valeur solde des comptes.
	 */
	public void transactionVirement(CompteBancaire pCompteDebiteur, CompteBancaire pCompteCrediteur, float pSomme) {

		pCompteDebiteur.setSoldeCompte(pCompteDebiteur.getSoldeCompte() - pSomme);
		pCompteCrediteur.setSoldeCompte(pCompteCrediteur.getSoldeCompte() + pSomme);
	} // =========================================================================

}
