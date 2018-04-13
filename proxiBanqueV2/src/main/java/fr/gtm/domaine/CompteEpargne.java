package fr.gtm.domaine;

public class CompteEpargne extends CompteBancaire {

	// =======Propriétés Classe=======
	private float tauxRemCompteEpargne;
	// =============================

	// =======Constructeurs=======
	public CompteEpargne() {
		super();
		this.tauxRemCompteEpargne = 0;
	}
	public CompteEpargne(float pSoldeCompte, String pTypeCompte, int pIdClient) {
		super(pSoldeCompte, pTypeCompte);
		this.tauxRemCompteEpargne = 0.0f;
		this.setNumCompte("E" + "00" + Integer.toString(pIdClient)) ;
	}
	// =============================

	
	// =======Getters-Setters=======
	public float getTauxRemCompteEpargne() {
		return tauxRemCompteEpargne;
	}
	public void setTauxRemCompteEpargne(float tauxRemCompteEpargne) {
		this.tauxRemCompteEpargne = tauxRemCompteEpargne;
	}
	// =============================

}
