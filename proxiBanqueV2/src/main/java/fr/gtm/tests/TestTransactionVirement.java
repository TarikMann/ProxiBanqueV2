package fr.gtm.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import fr.gtm.domaine.CompteBancaire;
import fr.gtm.domaine.CompteCourant;
import fr.gtm.service.ClientService;
import junit.framework.Assert;

public class TestTransactionVirement {

	private CompteCourant monCompteDebiteur;
	private CompteCourant monCompteCrediteur;
	private ClientService monServiceclient;
	private float somme;

	@Before
	public void setUp() throws Exception {
		this.monCompteDebiteur = new CompteCourant();
		this.monCompteCrediteur = new CompteCourant();
		this.monServiceclient = new ClientService();
		System.out.println(">> declanche before : creation compte");
	}

	/**
	 * @param monCompteDebiteur
	 *            : corresond au compte débiteur
	 * @param monCompteCrediteur
	 *            : correspond au compte créditeur
	 * @param somme
	 *            : montant de la transaction
	 * @param monServiceclient
	 *            : instancier pour appeler la méthode transactionVirement de la
	 *            couche service (classe : Clientservice)
	 * 
	 *            Test la méthode transaction virement afin de vérifier si les
	 *            soldes des compte créditeur et débiteur sont coorecte après la
	 *            transaction
	 */

	@SuppressWarnings("deprecation")
	@Test
	public void test() {

		// =============premier test=========================
		 this.monCompteDebiteur.setSoldeCompte(1000.0f);
		 this.monCompteCrediteur.setSoldeCompte(1000.0f);
		 this.somme = 200.0f;
		 this.monServiceclient.transactionVirement(this.monCompteDebiteur,
		 this.monCompteCrediteur, somme);
		 System.out.println(this.monCompteDebiteur.getSoldeCompte());
		
		 Assert.assertEquals( 800.0, monCompteDebiteur.getSoldeCompte(), 0.0f);
		 
			// =============premier test=========================
		 this.monCompteDebiteur.setSoldeCompte(500.0f);
		 this.monCompteCrediteur.setSoldeCompte(1000.0f);
		 this.somme = 600.0f;
		 this.monServiceclient.transactionVirement(this.monCompteDebiteur,
		 this.monCompteCrediteur, somme);
		 System.out.println(this.monCompteDebiteur.getSoldeCompte());
		
		 Assert.assertEquals( -100.0, monCompteDebiteur.getSoldeCompte(), 0.0f);
	}

	@After
	public void tearDown() throws Exception {
		monCompteDebiteur = null;
		monCompteCrediteur = null;
		System.out.println(">> declanche apres chaque test");
	}

}
