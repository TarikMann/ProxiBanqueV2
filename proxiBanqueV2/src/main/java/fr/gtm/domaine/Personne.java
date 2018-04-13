package fr.gtm.domaine;

/**
 * @author Mehdi Colbert Classe abstraite permettant de faire h�riter un nom et
 *         pr�nom aux classes : client - Coonseilleret - Gerant)
 */
public abstract class Personne {

	//=======Propri�t�s Classe=======
	protected String prenom;
	protected String nom;
	//=============================
	
	
	//=======Constructeurs=======
	public Personne() {
		super();
		this.prenom = "inconnu";
		this.nom = "inconnu";
	}
	public Personne(String pPrenom, String pNom) {
		super();
		this.prenom = pPrenom;
		this.nom = pNom;
	}
	//=============================
	
	
	//=======Getters-Setters=======
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	//=============================
}
