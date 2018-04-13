package fr.gtm.domaine;

import java.util.Date;

/**
 * @author Mehdi Colbert
 *Classe correspondant à une agence.
 *@param 
 */
public class Agence {
	
	//=======Propriétés Classe=======
	public Date dateAgence;
	public int idAgence;
	public int numAgence;
	//=============================
	
	//=======Getters-Setters=======
	public int getIdAgence() {
		return idAgence;
	}
	public void setIdAgence(int idAgence) {
		this.idAgence = idAgence;
	}
	public int getNumAgence() {
		return numAgence;
	}
	public void setNumAgence(int numAgence) {
		this.numAgence = numAgence;
	}
	//=============================

}
