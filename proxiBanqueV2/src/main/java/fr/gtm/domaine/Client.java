package fr.gtm.domaine;

/**
 * @author Mehdi-Tarik
 * Classe correspondant aux clients de la banque.
 */
public class Client extends Personne {

	//=======Propriétés Classe=======
	private int idClient ;
	private String adresseClient;
	private String codePostaleClient;
	private String	villeClient;
	private String emailClient;
	private int idConseiller;
	//=============================
	
	
	//=======Constructeurs=======
	public Client(String pPrenom, String pNom, String pAdresseClient, String pCodePostaleClient,
			String pVilleClient, String pEmail) {
		super(pPrenom, pNom);
		this.idClient = -1;
		this.adresseClient = pAdresseClient;
		this.codePostaleClient = pCodePostaleClient;
		this.villeClient = pVilleClient;
		this.emailClient = pEmail;
		this.idConseiller = -1;
	}
	public Client() {
		super("inconnu", "inconnu");
		this.idClient = -1;
		this.adresseClient = "inconnu";
		this.codePostaleClient = "inconnu";
		this.villeClient = "inconnu";
		this.emailClient = "inconnu";
		this.idConseiller = -1;
	}
	//=============================
	
	
	//=======Getters-Setters=======
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getAdresseClient() {
		return adresseClient;
	}
	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}
	public String getCodePostaleClient() {
		return codePostaleClient;
	}
	public void setCodePostaleClient(String codePostaleClient) {
		this.codePostaleClient = codePostaleClient;
	}
	public String getVilleClient() {
		return villeClient;
	}
	public void setVilleClient(String villeClient) {
		this.villeClient = villeClient;
	}
	public int getIdConseiller() {
		return idConseiller;
	}
	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}
	public String getEmailClient() {
		return emailClient;
	}
	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}
	//=============================
	
	
	//=======ToString method=======
	public String toString() {
		return "[ id : " + this.idClient + "--" + " prenom : " + this.getPrenom() + "--" + "nom :" + this.getNom() + "]";
	}
	//=============================
}
