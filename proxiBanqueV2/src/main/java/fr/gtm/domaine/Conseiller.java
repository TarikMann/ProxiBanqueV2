package fr.gtm.domaine;


/**
 * @author Mehdi-Tarik
 *  Classe correspondant à l'utilisateur "conseiller"
 */
public class Conseiller extends Personne {

	//=======Propriétés Classe=======
	private int idConseiller ;
	String login = "Inconne";
	String password = "Inconnu";
	//=============================
	
	
	//=======constructeur=======
	public Conseiller() {
		super();
		this.idConseiller = -1;
		this.setPrenom("Inconnu");
		this.setNom("Inconnu");
		this.login = "Inconnu";
		this.password = "Inconnu";
	}
	public Conseiller(String pPrenom, String pNom, int idConseiller, String login, String password) {
		super(pPrenom, pNom);
		this.idConseiller = -1;
		this.login = login;
		this.password = password;
	}
	//=============================
	
	
	//=======Getters-Setters=======
	public int getIdConseiller() {
		return idConseiller;
	}
	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//=============================
	
	

	//=======ToString method=======
	public String toString() {
		return "[ id : " + this.idConseiller + "--" + " prenom : " + this.getPrenom() + "--" + "nom :" + this.getNom() + "]";
	}
	//=============================
}
