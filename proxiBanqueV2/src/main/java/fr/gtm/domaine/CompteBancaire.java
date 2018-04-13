package fr.gtm.domaine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class  CompteBancaire {

	// =======Propriétés Classe=======
	protected int idCompte;
	protected float soldeCompte;
	protected String dateOuvertureCompte;
	protected float decouvertMaxCompte;
	protected float debitCompte;
	protected String typeCompte;
	protected String numCompte;
	protected int idClient;
	private static String typeCompteEpargne = "Epargne";
	private static String typeCompteCourant = "Courant";
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // * Definition du format utilise pour les dates
	// =============================

	// =======Constructeurs=======
	
	public CompteBancaire() {
		this.idCompte = -1;
		this.soldeCompte = 0;
		this.dateOuvertureCompte = dateFormat.format(new Date());
		this.decouvertMaxCompte = 0;
		this.debitCompte = 0;
		this.typeCompte = "inconnu";
		this.idClient = 0;
	}
	
	public CompteBancaire(float pSoldeCompte, 
			String pTypeCompte) {
		this.idCompte = -1;
		this.soldeCompte = pSoldeCompte;
		this.dateOuvertureCompte = dateFormat.format(new Date());
		this.decouvertMaxCompte = 1000;
		this.debitCompte = 0;
		this.typeCompte = pTypeCompte;
		this.idClient = -1;
	}
	// =============================


	// =======Getters-Setters=======
	public int getIdCompte() {
		return idCompte;
	}
	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}
	public float getSoldeCompte() {
		return soldeCompte;
	}
	public void setSoldeCompte(float soldeCompte) {
		this.soldeCompte = soldeCompte;
	}
	public String getDateOuvertureCompte() {
		return dateOuvertureCompte;
	}
	public void setDateOuvertureCompte(String dateOuvertureCompte) {
		this.dateOuvertureCompte = dateOuvertureCompte;
	}
	public float getDecouvertMaxCompte() {
		return decouvertMaxCompte;
	}
	public void setDecouvertMaxCompte(float decouvertMaxCompte) {
		this.decouvertMaxCompte = decouvertMaxCompte;
	}
	public float getDebitCompte() {
		return debitCompte;
	}
	public void setDebitCompte(float debitCompte) {
		this.debitCompte = debitCompte;
	}
	public String getTypeCompte() {
		return typeCompte;
	}
	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}

	public static String getTypeCompteEpargne() {
		return typeCompteEpargne;
	}

	public static void setTypeCompteEpargne(String typeCompteEpargne) {
		CompteBancaire.typeCompteEpargne = typeCompteEpargne;
	}

	public static String getTypeCompteCourant() {
		return typeCompteCourant;
	}

	public static void setTypeCompteCourant(String typeCompteCourant) {
		CompteBancaire.typeCompteCourant = typeCompteCourant;
	}
	// =============================


	//=======ToString method=======
	public String toString() {
		return "[ id : " + this.getIdCompte() + "--" + " solde : " + this.getSoldeCompte() + "--" + "typecompte :" + this.getTypeCompte() + " dateCreation : " + this.getDateOuvertureCompte() +  "]";
	}
	//=============================
	
}
