package fr.gtm.domaine;

public class Patrimoine {

	// =======Propriétés Classe=======
	private int idPatrimoine;
	private int idCompte;
	private int valeurPatrimoine;
	private String villePatrimoine;
	// =============================

	
	
	// =======Constructeurs=======
	public Patrimoine(int pIdPatrimoine, int pIdCompte, int pValeurPatrimoine, String pVillePatrimoine) {
		super();
		this.idPatrimoine = -1;
		this.idCompte = pIdPatrimoine;
		this.valeurPatrimoine = pValeurPatrimoine;
		this.villePatrimoine = pVillePatrimoine;
	}
	
	public Patrimoine() {
		super();
		this.idPatrimoine = -1;
		this.valeurPatrimoine = 0;
		this.villePatrimoine = "Inconnu";
	}
	// =============================
	
	
	// =======Getters-Setters=======
	public int getIdPatrimoine() {
		return idPatrimoine;
	}
	public void setIdPatrimoine(int idPatrimoine) {
		this.idPatrimoine = idPatrimoine;
	}
	public int getIdCompte() {
		return idCompte;
	}
	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}
	public int getValeurPatrimoine() {
		return valeurPatrimoine;
	}
	public void setValeurPatrimoine(int valeurPatrimoine) {
		this.valeurPatrimoine = valeurPatrimoine;
	}
	public String getVillePatrimoine() {
		return villePatrimoine;
	}
	public void setVillePatrimoine(String villePatrimoine) {
		this.villePatrimoine = villePatrimoine;
	}

	// =============================
	
}
