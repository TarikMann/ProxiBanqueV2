package fr.gtm.domaine;

public class Gerant extends Personne{

	//=======Propriétés Classe=======
	private int idGerant;
	private int idAgence ;
	//=============================
	
	
	//=======Getters-Setters=======
	public int getIdConseiller() {
		return idGerant;
	}
	public void setIdConseiller(int idConseiller) {
		this.idGerant = idConseiller;
	}
	public int getIdGerant() {
		return idGerant;
	}
	public void setIdGerant(int idGerant) {
		this.idGerant = idGerant;
	}
	//=============================
	
	
	//=======ToString method=======
	public String toString() {
		return "[ id : " + this.idGerant + "--" + " prenom : " + this.getPrenom() + "--" + "nom :" + this.getNom() + "]";
	}
	//=============================
	
}
