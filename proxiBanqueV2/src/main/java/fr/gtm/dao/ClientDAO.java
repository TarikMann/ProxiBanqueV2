package fr.gtm.dao;

import fr.gtm.domaine.Client;
import fr.gtm.domaine.Conseiller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mehdi-Tarik Cette classe rassemble les différentes méthodes
 *         permettant d'interroger la table client de la base de données
 */
public class ClientDAO {

	// ===================Propriétés Classe===================
	private float soldeMax = 50000;
	private ResultSet rs = null;
	// =======================================================

	// ===================Méthode creationClient===================
	/**
	 * @param pClient
	 * @return retourne true si la requete à bien été gérer par la base de données.
	 *         Cette méthode permettra de créer un client à partir des informations
	 *         rentrées par l'utilisateur. l'iDclient est gérer par la bdd et
	 *         l'idConseiller correspond à celui qui est actuellement connecté.
	 */
	public boolean creationClient(Client pClient, Conseiller pConseiller) {
		// Declaratio ndes variables locales

		// Initialisation de la connection
		ConnectionSQL.connect();
		System.out.println(pClient);
		System.out.println(pConseiller);
		// creation de la requete
		String sql = "insert into client (client_nom, client_prenom, client_adresse, client_cdPostal, client_ville, client_email, client_conseiller_id)"
				+ " VALUES ('" + pClient.getNom() + "','" + pClient.getPrenom() + "','" + pClient.getAdresseClient()
				+ "','" + pClient.getCodePostaleClient() + "','" + pClient.getVilleClient() + "','"
				+ pClient.getEmailClient() + "'," + pConseiller.getIdConseiller() + ")";
		try {
			// On envoie la requete a la base de données
			int iInsert = ConnectionSQL.getSt().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	// ========================================================

	// ===================Méthode getClient===================
	/**
	 * @param pClient
	 * @return retourne le client récupéré ou retourne le même client envoyé en
	 *         argument. Cette méthode permettra de chercher un client dans la base
	 *         de données à l'aide de son idClient qui correspond à la clé primaire
	 *         de la bdd. Si aucun client n'est trouvé le client retourné possèdera
	 *         un id = -1
	 */
	public boolean getClient(Client pClient) {

		// Initialisation de la connection + declaration statement
		ConnectionSQL.connect();

		String sql = "SELECT * FROM client WHERE client_id = " + pClient.getIdClient() + " ";
		try {
			// On envoie la requete a la base de données
			this.rs = ConnectionSQL.getSt().executeQuery(sql);
			// Om met le curseur sur la première ligne des données
			this.rs.first();
			// Affectation des propriétés de l'objet client
			pClient.setIdClient(this.rs.getInt("client_id"));
			pClient.setNom(this.rs.getString("client_nom"));
			pClient.setPrenom(this.rs.getString("client_prenom"));
			pClient.setAdresseClient(this.rs.getString("client_adresse"));
			pClient.setCodePostaleClient(this.rs.getString("client_cdPostal"));
			pClient.setVilleClient(this.rs.getString("client_ville"));
			pClient.setEmailClient(this.rs.getString("client_email"));
			pClient.setIdConseiller(this.rs.getInt("client_conseiller_id"));
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	// ========================================================

	// =====================Methode updateCLIENT=====================
	/**
	 * @param pClient
	 * @return retourne le client recu en arguement si la requete sql a été gérée
	 *         par la bdd retourn un ref null sinon.
	 * 
	 *         Cette méthode permet de mettre à jour certaines informations d'un
	 *         client grace à son id. les nouvelles informations sont rentrées par
	 *         l'utilisateur
	 */
	public boolean updateClient(Client pClient) {
		// Initialisation de la connection
		ConnectionSQL.connect();
		// creation de la requete
		String sql = "update client set client_nom = '" + pClient.getNom() + "', client_prenom = '"
				+ pClient.getPrenom() + "',client_adresse = '" + pClient.getAdresseClient() + "', client_cdPostal = '"
				+ pClient.getCodePostaleClient() + "', client_ville = '" + pClient.getVilleClient()
				+ "', client_email = '" + pClient.getEmailClient() + "' where client_id = " + pClient.getIdClient()
				+ " ";
		try {
			// On envoie la requete a la base de données
			int iInsert = ConnectionSQL.getSt().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	// ========================================================

	// ==================Methode deleteClient==================
	/**
	 * @param pClient
	 * @return true si la bdd a géré correctement la requete, false sinon
	 */
	public boolean deleteClient(Client pClient) {

		// Initialisation de la connection
		ConnectionSQL.connect();
		// creation de la requete
		String sql = "delete from client where client_id = " + pClient.getIdClient();
		try {
			// On envoie la requete a la base de données
			ConnectionSQL.getSt().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	// ========================================================

	// =====================GET ALL CLIENT=====================
	/**
	 * 
	 * @return retourne la liste des clients récupérés. Méthode permettant de
	 *         récupérer la liste de tous les clients ainsi que les informations de
	 *         ces clients.
	 */
	public List<Client> getAllCLients() { // A FAIRE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		// DECLARATION DES VARIABLES LOCALES
		List<Client> myListClientReturn = new ArrayList<Client>();

		// Initialisation de la connection + seclaration
		ConnectionSQL.connect();
		// creation de la requete
		String sql = "SELECT * FROM client";
		try {
			// On envoie la requete a la base de données et on récup-re le resultat
			this.rs = ConnectionSQL.getSt().executeQuery(sql);
			while (this.rs.next()) {
				Client clientReturn = new Client();
				// Affectation des propriétés de l'objet client
				clientReturn.setIdClient(this.rs.getInt("client_id"));
				clientReturn.setPrenom(this.rs.getString("client_prenom"));
				clientReturn.setNom(this.rs.getString("client_nom"));
				clientReturn.setAdresseClient(this.rs.getString("client_adresse"));
				clientReturn.setCodePostaleClient(this.rs.getString("client_cdPostal"));
				clientReturn.setVilleClient(this.rs.getString("client_ville"));
				clientReturn.setEmailClient(this.rs.getString("client_email"));
				clientReturn.setIdConseiller(this.rs.getInt("client_conseiller_id"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return myListClientReturn;
	}
	// ========================================================

	// =====================GET ALL CLIENTS D'UN CONSEILLER=====================
	/**
	 * @param pConseiller
	 *            : correspond au conseiller actuellement connecté (en session)
	 * @return retourne la liste des clients récupérés. Méthode permettant de
	 *         récupérer la liste de tous les clients ainsi que les informations de
	 *         ces clients.
	 */
	public List<Client> getCLientsConseiller(Conseiller pConseiller) {
		// DECLARATION DES VARIABLES LOCALES
		List<Client> myListClientReturn = new ArrayList<Client>();

		// Initialisation de la connection + seclaration
		ConnectionSQL.connect();

		// creation de la requete
		String sql = "SELECT * FROM client INNER JOIN conseiller WHERE client.client_conseiller_id = conseiller.conseiller_id AND client_conseiller_id ="
				+ pConseiller.getIdConseiller();
		try {
			// On envoie la requete a la base de données et on récup-re le resultat
			this.rs = ConnectionSQL.getSt().executeQuery(sql);
			while (this.rs.next()) {
				Client clientReturn = new Client();
				// Affectation des propriétés de l'objet client
				clientReturn.setIdClient(this.rs.getInt("client_id"));
				clientReturn.setNom(this.rs.getString("client_nom"));
				clientReturn.setPrenom(this.rs.getString("client_prenom"));
				clientReturn.setAdresseClient(this.rs.getString("client_adresse"));
				clientReturn.setCodePostaleClient(this.rs.getString("client_cdPostal"));
				clientReturn.setVilleClient(this.rs.getString("client_ville"));
				clientReturn.setEmailClient(this.rs.getString("client_email"));
				clientReturn.setIdConseiller(this.rs.getInt("client_conseiller_id"));
				myListClientReturn.add(clientReturn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return myListClientReturn;
	}
	// ========================================================

	// =====================GET ALL CLIENT FORTUNE=====================
	/**
	 * 
	 * @return retourne la liste des clients fortunés récupérés. Méthode permettant
	 *         de récupérer la liste des clients fortuné (solde > 50000) ainsi que
	 *         les informations de ces clients (non utilisé pour la version V2 de
	 *         proxibanque).
	 */
	public List<Client> getClientsFortune() {
		// DECLARATION DES VARIABLES LOCALES
		List<Client> myListClientReturn = new ArrayList<Client>();

		// Initialisation de la connection
		ConnectionSQL.connect();
		// creation de la requete
		String sql = "SELECT * FROM client WHERE client_solde >=" + soldeMax;
		try {
			// On envoie la requete a la base de données et on récup-re le resultat
			this.rs = ConnectionSQL.getSt().executeQuery(sql);
			while (this.rs.next()) {
				Client clientReturn = new Client();
				// Affectation des propriétés de l'objet client
				clientReturn.setIdClient(this.rs.getInt("client_id"));
				clientReturn.setPrenom(this.rs.getString("client_prenom"));
				clientReturn.setNom(this.rs.getString("client_nom"));
				clientReturn.setAdresseClient(this.rs.getString("client_adresse"));
				clientReturn.setCodePostaleClient(this.rs.getString("client_cdPostal"));
				clientReturn.setVilleClient(this.rs.getString("client_ville"));
				clientReturn.setIdConseiller(this.rs.getInt("client_conseiller_id"));
				myListClientReturn.add(clientReturn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return myListClientReturn;
	}
	// ===========================================

}