package fr.gtm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.gtm.domaine.Client;
import fr.gtm.domaine.Conseiller;

/**
 * @author Mehdi-Tarik Cette classe rassemble les différentes méthodes
 *         permettant d'interroger la table Conseiller de la base de données
 */
public class ConseillerDAO {

	// ===================Propriétés Classe===================
	private ResultSet rs = null;
	// =======================================================

	// ===================Méthode getConseiller===================
	/**
	 * @param pClient
	 * @return retourne le Conseiller récupéré en BDD ou retourne le même Conseiller
	 *         envoyé en argument. Cette méthode permettra de chercher un Conseiller
	 *         dans la base de données à l'aide de son login et password. Si aucun
	 *         conseiller n'est trouvé le conseiller retourné possèdera un id = -1.
	 */
	public Conseiller getConseillerSession(String pLogin, String pPassword) {

		// Declaration des variables locales
		Conseiller conseillerReturn = new Conseiller();

		// Initialisation de la connection
		Statement st = null;

		st = ConnectionSQL.connect();
		// creation de la requete
		String sql = "Select * from conseiller where conseiller_login = '" + pLogin + "' AND conseiller_password = '"
				+ pPassword + "'";
		try {
			// On envoie la requete a la base de données
			this.rs = st.executeQuery(sql);
			// Om met le curseur sur la première ligne des données
			this.rs.first();
			// Affectation des propriétés de l'objet client
			conseillerReturn.setIdConseiller(this.rs.getInt("conseiller_id"));
			conseillerReturn.setNom(this.rs.getString("conseiller_nom"));
			conseillerReturn.setPrenom(this.rs.getString("conseiller_prenom"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conseillerReturn;
	}
	// ========================================================



}
