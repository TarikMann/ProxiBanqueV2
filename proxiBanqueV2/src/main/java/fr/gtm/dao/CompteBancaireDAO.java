package fr.gtm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.gtm.domaine.Client;
import fr.gtm.domaine.CompteBancaire;
import fr.gtm.domaine.CompteCourant;
import fr.gtm.domaine.CompteEpargne;
import fr.gtm.domaine.Conseiller;

public class CompteBancaireDAO {

	// ======================Propriétés Classe=====================
	private ResultSet rs = null;
	private static String typeCompteEpargne = "Epargne";
	private static String typeCompteCourant = "Courant";
	// ============================================================

	// ========== Méthodes get id type compte============
	/**
	 * @param pLibelle
	 *            : correspond au type du compte cosidéré.
	 * @return typeCompteid : correspond au numero inscrit en bdd correspondant au
	 *         type de compte. Cette Méthode retourne
	 */
	public int getidTypeCompte(String pLibelle) {

		// VARIABLES LOCALES
		int typeCompteid = 0;
		// Initialisation de la connection
		ConnectionSQL.connect();
		// Requete pour récupérer la clé type_Compte de la table typecompte de la bdd.
		String sql = "Select typeCompte_id from typecompte where typeCompte_libelle ='" + pLibelle + "'";
		// + " ";
		try {
			// On envoie la requete a la base de données
			this.rs = ConnectionSQL.getSt().executeQuery(sql);
			// Om met le curseur sur la première ligne des données
			this.rs.first();
			// Affectation des propriétés de l'objet client
			typeCompteid = this.rs.getInt("typeCompte_id");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return typeCompteid;
	}// ========================================================

	// ========== Méthodes creationCompte Epargne et courant============
	/**
	 * @param pCompte
	 *            : compte à enregistrer
	 * @param pClient
	 *            : client lié au compte enregistré
	 * @return true si la requête à bien été gérée par la bdd false sinon. Cette
	 *         méthode permet d'enregistrer en base donnée un compte Epargne dont
	 *         les informations ont été saisies par l'utilisateur à partir de l'id
	 *         du client.
	 */
	public boolean creationCompte(CompteEpargne pCompte, Client pClient) {

		// DECLARATION DES VARIABLES LOCALES
		int typeCompteBdd = 0;
		typeCompteBdd = getidTypeCompte(typeCompteEpargne);
		System.out.println("numtypecompte Epargne :" + typeCompteBdd);

		// Initialisation de la connection
		ConnectionSQL.connect();

		// creation de la requete
		String sqlCreation = "insert into compte (compte_numCompte, compte_solde, compte_dt_Creation, compte_typeCompte_id, compte_client_id)"
				+ "VALUES ('" + pCompte.getNumCompte() + "'," + pCompte.getSoldeCompte() + ",'"
				+ pCompte.getDateOuvertureCompte() + "'," + typeCompteBdd + "," + pClient.getIdClient() + ")";
		try {
			// On envoie la requete a la base de données
			ConnectionSQL.getSt().executeUpdate(sqlCreation);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @param pCompte
	 *            : compte à enregistrer
	 * @param pClient
	 *            : client lié au compte enregistré
	 * @return true si la requête à bien été gérée par la bdd, false sinon. Cette
	 *         méthode permet d'enregistrer en base donnée un compte Courant dont
	 *         les informations ont été saisies par l'utilisateur à partir de l'id
	 *         du client.
	 */
	public boolean creationCompte(CompteCourant pCompte, Client pClient) {

		// DECLARATION DES VARIABLES LOCALES
		int typeCompteBdd = 0;
		typeCompteBdd = getidTypeCompte(typeCompteCourant);
		System.out.println("numtypecompte Courant :" + typeCompteBdd);
		// Initialisation de la connection
		ConnectionSQL.connect();

		// creation de la requete
		String sqlCreation = "insert into compte (compte_numCompte, compte_solde, compte_dt_Creation, compte_typeCompte_id, compte_client_id)"
				+ "VALUES ('" + pCompte.getNumCompte() + "'," + pCompte.getSoldeCompte() + ",'"
				+ pCompte.getDateOuvertureCompte() + "'," + typeCompteBdd + "," + pClient.getIdClient() + ")";
		try {
			// On envoie la requete a la base de données
			ConnectionSQL.getSt().executeUpdate(sqlCreation);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}// ========================================================

	// =====================GET ALL Comptes=====================
	/**
	 * 
	 * @return myListComptesReturn : retourne la liste des comptes récupérés.
	 *         Méthode permettant de récupérer la liste de tous les comptes
	 *         enregistrés en bddainsi que leurs informations.
	 */
	public ArrayList<CompteBancaire> getAllComptes() {

		// DECLARATION DES VARIABLES
		ArrayList<CompteBancaire> myListComptesReturn = new ArrayList<CompteBancaire>();

		// Initialisation de la connection + declaration statement
		ConnectionSQL.connect();

		String sql = "SELECT * FROM compte INNER JOIN typecompte WHERE compte.compte_typeCompte_id = typecompte.typeCompte_id ";
		try {
			// On envoie la requete a la base de données
			this.rs = ConnectionSQL.getSt().executeQuery(sql);
			while (this.rs.next()) {
				if (this.rs.getString("typeCompte_libelle").equals(typeCompteEpargne)) {
					CompteEpargne compteReturn = new CompteEpargne();
					compteReturn.setTypeCompte(typeCompteEpargne);
					// Affectation des propriétés de l'objet client
					compteReturn.setIdCompte(this.rs.getInt("compte_id"));
					compteReturn.setNumCompte(this.rs.getString("compte_numCompte"));
					compteReturn.setSoldeCompte(this.rs.getInt("compte_solde"));
					compteReturn.setDateOuvertureCompte(this.rs.getString("compte_dt_Creation"));
					compteReturn.setIdClient(this.rs.getInt("compte_client_id"));
					System.out.println(compteReturn);
					myListComptesReturn.add(compteReturn);
				} else {
					CompteCourant compteReturn = new CompteCourant();
					compteReturn.setTypeCompte(typeCompteCourant);
					// Affectation des propriétés de l'objet client
					compteReturn.setIdCompte(this.rs.getInt("compte_id"));
					compteReturn.setNumCompte(this.rs.getString("compte_numCompte"));
					compteReturn.setSoldeCompte(this.rs.getInt("compte_solde"));
					compteReturn.setDateOuvertureCompte(this.rs.getString("compte_dt_Creation"));
					compteReturn.setIdClient(this.rs.getInt("compte_client_id"));
					System.out.println(compteReturn);
					myListComptesReturn.add(compteReturn);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myListComptesReturn;
	} // =========================================================================================

	// ========== Méthodes get Comptes Client============
	/**
	 *
	 * @param pClient
	 *            : client lié au compte enregistré
	 * @return myListComptesReturn : correspond à la liste des comptes liés à un
	 *         client. il ne peut y avoir que deux liés à un client Cette méthode
	 *         recupérer les comptes et leurs informations enregistrés en base
	 *         donnée à partir de l'id du client.
	 */
	public ArrayList<CompteBancaire> getComptesClient(Client pClient) {

		// DECLARATION DES VARIABLES
		ArrayList<CompteBancaire> myListComptesReturn = new ArrayList<CompteBancaire>();

		// Initialisation de la connection + declaration statement
		ConnectionSQL.connect();

		String sql = "SELECT * FROM compte INNER JOIN typecompte WHERE compte.compte_typeCompte_id = typecompte.typeCompte_id AND compte_client_id = "
				+ pClient.getIdClient() + " ";
		try {
			// On envoie la requete a la base de données
			this.rs = ConnectionSQL.getSt().executeQuery(sql);
			while (this.rs.next()) {
				if (this.rs.getString("typeCompte_libelle").equals(typeCompteEpargne)) {
					CompteEpargne compteReturn = new CompteEpargne();
					compteReturn.setTypeCompte(typeCompteEpargne);
					// Affectation des propriétés de l'objet client
					compteReturn.setIdCompte(this.rs.getInt("compte_id"));
					compteReturn.setNumCompte(this.rs.getString("compte_numCompte"));
					compteReturn.setSoldeCompte(this.rs.getInt("compte_solde"));
					compteReturn.setDateOuvertureCompte(this.rs.getString("compte_dt_Creation"));
					compteReturn.setIdClient(this.rs.getInt("compte_client_id"));
					System.out.println(compteReturn);
					myListComptesReturn.add(compteReturn);
				} else {
					CompteCourant compteReturn = new CompteCourant();
					compteReturn.setTypeCompte(typeCompteCourant);
					// Affectation des propriétés de l'objet client
					compteReturn.setIdCompte(this.rs.getInt("compte_id"));
					compteReturn.setNumCompte(this.rs.getString("compte_numCompte"));
					compteReturn.setSoldeCompte(this.rs.getInt("compte_solde"));
					compteReturn.setDateOuvertureCompte(this.rs.getString("compte_dt_Creation"));
					compteReturn.setIdClient(this.rs.getInt("compte_client_id"));
					System.out.println(compteReturn);
					myListComptesReturn.add(compteReturn);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myListComptesReturn;
	}// ========================================================

	// ================= Méthodes get Compte===================
	/**
	 * @param pCompte
	 *            : compte dont on souhaite obtenir les information (contient l(id
	 *            du compte)
	 * @return return true si la requete en bdd ne retourne pas d'exception, false
	 *         sinon.
	 * 
	 *         Methode permettant de recupérer les informations d'un compte (épargne
	 *         ou courant) à partir de son id.
	 */
	public boolean getCompte(CompteBancaire pCompte) {

		// DECLARATION DES VARIABLES

		// Initialisation de la connection + declaration statement
		ConnectionSQL.connect();

		// creation de la requete
		String sql = "SELECT * FROM compte WHERE compte_id = " + pCompte.getIdCompte() + " ";
		try {
			// On envoie la requete a la base de données
			this.rs = ConnectionSQL.getSt().executeQuery(sql);
			// Om met le curseur sur la première ligne des données
			this.rs.first();
			// Affectation des propriétés de l'objet client
			pCompte.setNumCompte(this.rs.getString("compte_numCompte"));
			pCompte.setSoldeCompte(this.rs.getInt("compte_solde"));
			pCompte.setDateOuvertureCompte(this.rs.getString("compte_dt_Creation"));
			pCompte.setIdClient(this.rs.getInt("compte_client_id"));
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}// ========================================================

	// =====================Methode update Compte=====================
	/**
	 * @param pCompte
	 *            : correspond au compte que l'on souhaite modifier
	 * @return : retourne true si la base de donnée ne renvoie pass d'exception,
	 *         false sinon.
	 * 
	 *         Cette méthode permet de mettre à jour certaines informations d'un
	 *         compte Bancaire (epargne ou courant) grace à son id suite à un
	 *         virement compte à compte par exemple.
	 */

	public boolean updateCompte(CompteBancaire pCompte) {
		// Initialisation de la connection
		ConnectionSQL.connect();
		// creation de la requete
		String sql = "update compte set compte_solde = " + pCompte.getSoldeCompte() + " WHERE compte_id =  "
				+ pCompte.getIdCompte() + " ";
		try {
			// On envoie la requete a la base de données
			int iInsert = ConnectionSQL.getSt().executeUpdate(sql);
			return true;
		} catch (SQLException e) {

		}
		return false;
	}// ========================================================

	// ==================Methode deleteClient==================
	/**
	 * @param pCompte
	 *            : correspond au compte que l'on souhaite modifier
	 * @return retourne true si la base de donnée ne renvoie pass d'exception, false
	 *         sinon.
	 * 
	 *         Ces méthodes (surchargées) permettent de supprimer un compte Bancaire
	 *         (epargne ou courant) de la bdd grace à son id.
	 */
	public boolean deleteCompte(CompteBancaire pCompte) {

		// Initialisation de la connection
		ConnectionSQL.connect();
		// creation de la requete
		String sql = " delete from compte where compte_id = " + pCompte.getIdCompte() + " ";
		try {
			// On envoie la requete a la base de données
			ConnectionSQL.getSt().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteCompte(Client pClient) {

		// Initialisation de la connection
		ConnectionSQL.connect();
		// creation de la requete
		String sql = " delete from compte where compte_client_id = " + pClient.getIdClient() + " ";
		try {
			// On envoie la requete a la base de données
			ConnectionSQL.getSt().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	} // ========================================================

}
