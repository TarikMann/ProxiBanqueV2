package fr.gtm.domaine;

public class CompteCourant extends CompteBancaire{
	
	// =======Constructeurs=======
	public CompteCourant() {
		super();
	}
	public CompteCourant (float pSoldeCompte, String pTypeCompte, int pIdClient) {
		super(pSoldeCompte, pTypeCompte);
		this.setNumCompte("C" + "00" + Integer.toString(pIdClient)) ;
	}
	// =============================
	
}
